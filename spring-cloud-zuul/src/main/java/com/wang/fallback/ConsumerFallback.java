package com.wang.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
/**
 * 主要测试 zuul的断路机制（这里针对的 是spring-cloud-consumer 消费者模块）
 * @author wanghe
 *
 */
@Component
public class ConsumerFallback implements FallbackProvider{

	@Override
	public String getRoute() {
		/**
		 * consumer 是配置文件里zuul.routes.consumer.serviceId=spring-cloud-consumer 的spring-cloud-consumer
		 * 由此，是对spring-cloud-consumer这个模块进行断路回退
		 * 
		 * 如果是 return "*",那么就是对所有路由都进行这个回退
		 */
		return "spring-cloud-consumer";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) { 
		System.err.println("route: "+route+"   ;cause :"+cause.getLocalizedMessage());
		return new ClientHttpResponse() {
	        @Override
	        public HttpStatus getStatusCode() throws IOException {
	            return HttpStatus.OK;
	        }
	
	        @Override
	        public int getRawStatusCode() throws IOException {
	            return 200;
	        }
	
	        @Override
	        public String getStatusText() throws IOException {
	            return "OK";
	        }
	
	        @Override
	        public void close() {
	
	        }
	
	        @Override
	        public InputStream getBody() throws IOException {
	        	String fallback="路由无法访问，返回默认结果";
	            return new ByteArrayInputStream(fallback.getBytes());
	        }
	
	        @Override
	        public HttpHeaders getHeaders() {
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_JSON);
	            return headers;
	        }
	    };
	}
 
}
