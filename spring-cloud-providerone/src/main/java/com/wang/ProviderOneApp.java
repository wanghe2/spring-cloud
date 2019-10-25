package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderOneApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ProviderOneApp.class, args);
    }
}
