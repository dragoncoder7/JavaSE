# Nacos 服务发现（注册中心/配置中心）

其他 [Eureka](https://spring.io/projects/spring-cloud-netflix), [Consul](https://spring.io/projects/spring-cloud-consul), [Zookeeper](https://spring.io/projects/spring-cloud-zookeeper), and even [Kubernetes](https://spring.io/projects/spring-cloud-kubernetes)' 

官方学习文档：

https://spring-cloud-alibaba-group.github.io/github-pages/2021/en-us/index.html#_spring_cloud_alibaba_nacos_discovery

https://github.com/alibaba/nacos/

https://nacos.io/



![image-20250806005536046](C:\Users\10262\AppData\Roaming\Typora\typora-user-images\image-20250806005536046.png)





1. Nacos 既可以当服务发现注册中心 也可以当配置中心
   - 引入不同的依赖即可 
   - 注册中心 discovery / 配置中心 config
2. 注册中心 如何发起远程调用 RestTemplate、 公共数据模块、负载均衡
   1. 服务注册 配置文件中配置Nacos地址（首先得启动Nacos）
   2. 首先开启服务发现 @EnableDiscoveryClient
   3. 再服务发现 通过DiscoveryClient注解（通用的服务发现API） 调用方法获取所有服务的所有实例下的ip+host  / 以及专门的Nacos服务发现API NacosServiceDiscovery注解 (一般使用RPC远程调用)
   4. 负载均衡（三种实现方式 都需要引入负载均衡依赖 loadbalancer）
      1. LoadBalanced 注解 加到RestTemplate的bean上即可。
      2. LoadBalancerClient 注解 choose方法 轮询负载均衡。
3. 配置中心
   1. 优先级 Nacos配置中心 外部 > 内部配置 **约定大于配置**
   2. 引入相关依赖
   3. 引入Nacos中配置中心的配置文件 需要 spring.config.import = nacos:xxx.(yml/properties) #nacos+具体的配置文件名称
   4. 动态刷新
      1. @value + @refreshscope 实现自动刷新 仅针对具体页面
      2. @configationProperties **无感自动刷新**
      3. @NacosConfigManager 监听配置变化
   5. nacos namespace区分多环境 group区分多微服务 data-id区分多配置文件
   6. 数据隔离 动态切换环境
      1. 确认命名空间 spring.cloud.nacos.config.namespace=xxx
      2. spring.config.import=naocs+具体配置文件+?group=xxx









# openFeign（远程调用）

官方学习文档

https://github.com/OpenFeign/feign

https://spring.io/projects/spring-cloud-openfeign

https://docs.spring.io/spring-cloud-openfeign/reference/spring-cloud-openfeign.html

1. 启用OpenFeign @EnableFeignClients
2. 发起远程调用（业务远程调用小技巧 把其他微服务的请求方法直接复制过来即可）
3. 创建对应微服务模块的OpenFeign接口 @FeignClient
   1. 如果是第三方 通过@FeignClient url参数指定地址 再通过path参数请求路径

4. 配置openFeign常见属性（超时控制时间（连接超时 / 读取超时） 超时重试机制 注入Retry Bean）
5. openFeign 请求/响应拦截器 
6. Fallback FeignClients fallback 参数兜底策略机制 （需要配合开启sentinel使用）









# Sentinel（服务保护 限流 熔断降级）

官方学习文档

https://sentinelguard.io/zh-cn/docs/introduction.html

https://github.com/alibaba/spring-cloud-alibaba/wiki/Sentinel

https://github.com/alibaba/Sentinel

构建资源（@SentinelResource / Web接口 / @FeignClients）

声明式资源@SentinelResource 编程式资源 重写 Sphu API

控制台管理（懒加载机制 只有访问过才会展示规则配置 可以配置文件 eager: true）

1. 定义资源
   - 异常处理
     1. Web接口导致  拦截器 拦截  BlockExceptionHandler
     2. @SentinelResource  对注解 切面AOP 也是硬编码 entry （blockhandler 优先级 > fallback）
     3. OpenFeign远程调用 fallback兜底回调
     4. SphU.entry 硬编码 自行try catch
2. 流量控制
   1. 模式（直接 / 链路 / 关联）
      1. 直接：Warm up 和 排队等待 **只有在直接模式下生效** 即直接控制对应的资源（QPS or 并发线程）
      2. 链路：比如a b资源 b资源是通过a资源访问的 那对b资源链路a 实际上是限制a资源
      3. 关联：比如a b资源 b资源关联了a 如果a资源的请求量大， 才会限流b资源。（即保证被关联了的资源a的访问）
   2. 效果（快速失败 / Warm up / 排队等待）
      1. 快速失败：直接返回失败提示 
      2. Warm up 慢慢达到最大访问能力 慢慢递增接受资源的请求 （设置预热时间 达到后满载资源）
      3. 排队等待：固定排队 （设置最大排队时长 达到后停止排队）
3. 异常熔断
   1. 断路器（）
      - 断开
      - 闭合
      - 半开
   2. 断路策略（熔断时长 统计时长 最小请求数）
      - 慢调用比例 （最大响应时长 超过即认为是慢调用）设定一个判断为慢调用的阈值 达到即认为是慢调用 当达到一定比例后 断开断路器 即不可继续访问该异常资源。达到熔断时间后再调用尝试机制（尝试性发生请求 如果成功 连通断路。否则继续保持熔断）
      - 异常比例
      - 异常数量
   3. 热点限流
      1. 热点参数限流 如果带了某个热点参数的资源访问 进行qps限制
      2. 额外配置 可针对某一热点参数的值进行单独限定配置



# SpringCloud GateWay 网关

https://github.com/spring-cloud/spring-cloud-gateway

https://spring.io/projects/spring-cloud-gateway

1. Route 路由
   1. 一般都使用均衡负载路由
   2. lb://service-id
2. Predicates 断言 
   1. 多种静态工厂 用的最多的 是 path 和 参数路由
   2. （xx时间前 / xx时间后 / xx和xx时间之间 / Cookie路由 / header路由 / ip路由 / 请求方法路由 / 参数路由）
   3. 支持自定义重写
3. filter 过滤
   1. 支持全局filter 如token验证等等 - 响应式编程
   2. 多种静态工厂 
   3. （添加请求头 / 添加path请求参数 / 添加响应头 / 重写路径 / ）





# Seate 分布式事务

为何要引入分布式事务？

在微服务架构之间 各个模块的数据库是单独存放在对应模块中的 而有的远程调用可能涉及多个微服务之间的调用，关联到各个模块的数据库，那么就可能出现某些模块事务执行成功 而部分的没成功 导致数据一致性问题。

分布式事务就是为了解决这个问题。

如何实现的？核心就是TC TM RM

TC（Transaction Coordinator）：全局事务管理器 协调最终事务是否全部提交或者全部回滚 会有一个全局事务ID

TM（Transaction Manager）：定义全局事务范围 可以说是一次性的事务管理 与TC沟通 通知TC一次分布式事务的开始执行和结束 提交/回滚全局事务

RM（Resource Manger）：资源管理器 管理各个分支事务

1. TC TM RM
2. 二阶段提交
   1. 先是分支事务  保存快照 然后执行SQL命令 通知TC分支事务状态 如果有失败的 TM会感知到 最后决定到底要不要全部回滚 如果要 再通知TC 全部回滚 TC再通知各分支事务 进行回滚操作 以及undo log的删除和事务上下文删除 
3. AT（auto）模式