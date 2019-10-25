实现一个简单的springcloud 项目，包括以下模块：
1.euraka 注册中心

2.服务提供者

3.消费者 （实现方式 1.远程访问，配合熔断机制hytrix 和ribbon负载均衡   2.feign方式）

4.网关路由 （zuul）

5.全局配置 （spring cloud config）

6.附加 springcloud 仪表盘


---
netflix 提供的模式包括服务发现（Eureka），断路器（Hystrix），智能路由（Zuul）和客户端负载平衡（Ribbon）。


注：springcloud和springboot的版本要对应

providerone 和 providertwo 不仅充当服务提供者，还有一个测试点：
它们配合spring-cloud-config模块，读取github的配置文件(这样的话，providerone和providertwo都是spring-cloud-config的客户端)



--血的教训
一定要引入相应的jar包，不要以为有了注解就引入jar包了

如果想被注册（就是eureka客户端），一定要引入spring-cloud-starter-netflix-eureka-client

如果想读取config配置中心的内容（即config客户端），要引入 spring-cloud-starter-config