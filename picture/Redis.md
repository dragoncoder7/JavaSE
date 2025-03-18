## Redis 中常见的数据类型有哪些？

### **什么是Redis？**

是一种通过内存来存储数据的可持久化非关系数据库，数据存储类型为KV类型，即键值对类型。拥有超快的取值速度，差不多能达到10w的QPS

QPS（Query Per Second）：表示系统每秒处理的请求量。

QPS = 总请求量 / 时间窗口（秒）。

例：某API1分钟处理6000次请求，6000 / 60 = 1000QPS

1. **字符串 String** 

   可以存储各种类型的值，包括文本、数字、二级制数据，最大长度512MB。

   使用场景：页面信息缓存，用户session缓存。

2. **哈希 Hash**

   一个键值对集合，适合存储对象的属性。

   使用场景：商品对象，以及其属性。

3. **列表 List**

   有序字符串集合，支持从两端弹入或弹出数据。

   使用场景：消息队列；简单任务调度/消息传递

4. **集合 Set**

   每个元素都有唯一性且无序，集合内不存在重复数据。

   使用场景：标签系统，存储兴趣标签避免重复。唯一用户集合

5. **有序集合 Zset/ Sorted Set**

   集合有序，每个元素都有一个分数，可用来排序。

   使用场景：排行榜、任务调度

非常用：

1. BitMap Version 2.2

   一种以位为单位存储数据的方式。适合用来表示状态等内容、boolean值。

2. HyperLogLog Version 2.8

   概率性数据结构，主要用于估算基数（不同元素数量），适用于大规模数据的去重和计数。

3. GEO Version 3.2

   一种用于存储地理位置信息的数据结构，存储经纬度等支持空间查询，计算距离和获取范围内的坐标。

4. Stream Version 5.0

   一种日志数据结构，适用于存储时间序列数据或消息流，具有持久性和序列化特性。





## 命令行实战以及常用方法：

通用方法：

- **`DEL key`：删除键。**
- **`EXPIRE key seconds`：设置键的过期时间。**
- **`TTL key`：查看键的剩余生存时间。**
- **`KEYS pattern`：匹配键名（生产慎用）。**



#### 登录客户端

redis-cli 进入redis客户端端口 如有密码需要验证后方可操作。

auth <你的redis登录密码>

![image-20250228172948724](C:\Users\maoyunlong\AppData\Roaming\Typora\typora-user-images\image-20250228172948724.png)

1. #### **字符串**String

   - `SET key value`：设置值。

   - `GET key`：获取值。

   - `INCR key`：将整数值自增 1。

   - `DECR key`：将整数值自减 1。

   - `APPEND key value`：追加内容。

   - `MSET key1 value1 key2 value2...`：批量设置键值。

   - `MGET key1 key2...`：批量获取值。

   - `SETEX key seconds value`：设置值并指定过期时间（秒）

   ![image-20250228173851138](C:\Users\maoyunlong\AppData\Roaming\Typora\typora-user-images\image-20250228173851138.png)

2. #### 哈希Hash

   - `HSET key field value`：设置字段值（支持多字段，如 `HSET key f1 v1 f2 v2`）。
   - `HGET key field`：获取字段值。
   - `HGETALL key`：获取所有字段和值。
   - `HDEL key field`：删除字段。
   - `HINCRBY key field increment`：将字段的整数值增加指定值。
   - `HKEYS key`：获取所有字段名。
   - `HEXISTS key field`：检查字段是否存在。

   ![image-20250228173913088](C:\Users\maoyunlong\AppData\Roaming\Typora\typora-user-images\image-20250228173913088.png)

3. #### 列表List

   - `LPUSH key value1 value2...`：从左侧插入元素。
   - `RPUSH key value1 value2...`：从右侧插入元素。
   - `LPOP key`：从左侧弹出元素。
   - `RPOP key`：从右侧弹出元素。
   - `LRANGE key start end`：获取指定范围的元素（如 `0 -1` 表示全部）。
   - `LLEN key`：获取列表长度。

   ![image-20250228173947133](C:\Users\maoyunlong\AppData\Roaming\Typora\typora-user-images\image-20250228173947133.png)

4. #### 集合Set

   - `SADD key member1 member2...`：添加元素。
   - `SMEMBERS key`：获取所有元素。
   - `SREM key member`：删除元素。
   - `SISMEMBER key member`：判断元素是否存在。
   - `SINTER key1 key2...`：求多个集合的交集。
   - `SUNION key1 key2...`：求多个集合的并集。
   - `SCARD key`：获取元素数量。

   ![image-20250228174027194](C:\Users\maoyunlong\AppData\Roaming\Typora\typora-user-images\image-20250228174027194.png)

5. #### 有序集合Sorted Set / Zset

   - `ZADD key score1 member1 score2 member2...`：添加元素（带分数）。
   - `ZRANGE key start end [WITHSCORES]`：按分数升序获取元素。
   - `ZREVRANGE key start end [WITHSCORES]`：按分数降序获取元素。
   - `ZREM key member`：删除元素。
   - `ZRANK key member`：获取元素的升序排名。
   - `ZSCORE key member`：获取元素的分数。
   - `ZINCRBY key increment member`：增加元素的分数。

   ![image-20250228174228426](C:\Users\maoyunlong\AppData\Roaming\Typora\typora-user-images\image-20250228174228426.png)






## Redis 的持久化机制有哪些？



主要是两种方式：

1. AOF 

   - AOF会把每一次的写操作完成后都记录到硬盘上的日志文件，这样能保证数据的一致性。

   - 优点是数据恢复精确度高，缺点是要记录的写操作多，日志文件体积大，以及恢复时的速度会比较慢。

2. RDB

   - RDB是记录某一时刻的快照，生成二进制的日志文件，可以通过配置指定RDB记录间隔时长，RDB相对AOF来说体积更小，二进制的数据恢复速率也更快。适合灾难恢复和备份。
   - 缺点是由于它是间隔性的持久化，如果在快照记录时或者是突然发生Redis宕机，那么从备份后到发生异常的这段时间内的数据会造成丢失。



那么这两种方式都有各自的优缺点，如何解决该问题？

在Redis4.0版本后，Redis引入了RDB和AOF的混合持久化机制，兼并了两者的优点。

具体机制：

在AOF开始持久化的时候，首先fork子线程，保证主线程的正常读写。执行RDB快照备份，在该期间产生的写操作会先记录到一个缓存区域中，然后RDB快照备份完后，以RDB格式写入AOF文件，完成后将缓存区的写操作也写入AOF中，保证数据的一致性。最后将最新的AOF替换掉原来的AOF文件。



Q：如何开启混合持久化？

A：

- 首先要开启AOF，因为该混合机制是基于AOF的运行。
- 然后配置文件中设置 aof-use-rdb-preamble yes



以及为了优化AOF日志文件过大的问题，Redis有对应的AOF重写机制。在保证数据一致性的前提下，优化了AOF的文件日志大小。



Q：AOF的具体重写过程？

A：