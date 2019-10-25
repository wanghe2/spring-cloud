package com.wang.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.service.impl.DataServiceFailImpl;

/**
 * 利用feign形式远程访问
 * @author wanghe
 *
 */
@Component
@FeignClient(name="spring-cloud-provider",fallback=DataServiceFailImpl.class)
public interface DataService {
	
	@RequestMapping("getMusic")
	public String getMusic();
	
	@RequestMapping("getNoMusic")
	public String getNoMusic();
	
}
