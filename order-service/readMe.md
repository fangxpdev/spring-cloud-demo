#Ribbon
### 服务调用
eureka集成了ribbon：
1. 创建restTemplate时，声明@LoadBlanced注解
2. 使用restTemplate调用微服务，调用时使用服务名替换ip+端口

### 负载均衡
@LoadBalanced负载均衡功能
修改方法：服务名：ribbon：

### 重试机制
1. 引入spring重试机制
2. 对ribbon进行重试配置
