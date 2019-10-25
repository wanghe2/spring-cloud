package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * 这里说明一下
 * 同时引用了@EnableCircuitBreaker 和 @EnableFeignClients ,
 * 主要是想用两种方式实现断路器（hytrix 方式、feign方式）
 * 注：使用feign的断路器，要在配置文件中加入配置feign.hystrix.enabled=true
 * @author wanghe
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class ConsumeApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ConsumeApp.class, args);
    }
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }
}
