# OJ



## 数据库设计

1. 用户表
2. 题目表
3. 用户提交题目表







总体



- 用户 

1. 写题目 
2. 提交题目

管理员

1. 创建题目
2. 判题





微服务架构：

Nacos 服务发现

**用户模块**：基础的用户注册、登录、删除（逻辑删除）、修改、以及获取一批用户列表页面展示、vo脱敏等等。

**网关模块**：

1. 对用户模块、题目模块以及判断服务模块进行了统一网关管理 都是固定以api + 对应的模块名称
2. 定义了全局过滤器 区分网关请求以及内部请求 如何实现？（响应式编程 filter 如果网关请求转发中有inner 就保存 因为网关是对外的 不是对内的 不应该带inner ）

**题目模块**（ [yuoj-backend-question-service](D:\project\studyProject\yuoj-backend-microservice-master\yuoj-backend-question-service) ）：题目效验 / 消息队列解耦请求判题 / Mybatis plus 分页插件 

**判题服务模块**（ [yuoj-backend-judge-service](D:\project\studyProject\yuoj-backend-microservice-master\yuoj-backend-judge-service) ）：内部调用判题 / 消息队列解耦调用判题 / 代码沙箱

- > *代码沙箱模块*（实现方式）**单独有代码**
  
  1.  示例代码沙箱z
  2. 远程代码沙箱
  3. 第三方代码沙箱（调用其他人现成的代码沙箱）
- 静态工厂 枚举值（default remote thirdpart） 可以通过Nacos配置中心无感修改
- 判题策略 采用策略模式 针对不同语言实现不同的判题策略

**公共模块**：IP获取 全局异常器 用户权限效验

**通用模型层**模块：基础VO  DTO、

**后端服模块**：内部调用判题模块、用户模块、题目模块





**问题1： 编程语言（language）这一块是怎么处理的？研究一下今天**

回答：策略模式



**问题2：inner 内部的controller 有内部互相调用吗？ 在哪里从源头开始调用的？ 研究一下今天**