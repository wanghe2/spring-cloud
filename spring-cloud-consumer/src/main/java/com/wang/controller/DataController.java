package com.wang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wang.service.DataService;

@RestController
public class DataController {
	
	private static final String REMOTE_SEVER="http://spring-cloud-provider/";

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DataService dataSerice;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("getData")
	public List<String>getData(){
		List<String> userList=restTemplate.getForEntity(REMOTE_SEVER+"getUsers", List.class).getBody();
		return userList;
	}
	/**
	 * 模拟远程访问接口宕机，（其实我这是错误的连接），所以要有断路器，保证其他服务正常运行
	 * @return
	 */
	@RequestMapping("getNodata")
	@HystrixCommand(fallbackMethod="getDataFail")
	public String getNoData(){
		String data=restTemplate.getForEntity("http://spring-cloud-notexistserver/getdata", String.class).getBody();
		data+="--附加内容，模拟进行后续操作";
		return data;
	}
	
	public String getDataFail() {
		return "远程访问失败，返回默认结果";
	}
	
	@RequestMapping("getDataByFeign")
	public String getDataByFeign() {
		String music=dataSerice.getMusic();
		return music;
	}
	
	@RequestMapping("getNoDataByFeign")
	public String getNoDataByFeign() {
		String music=dataSerice.getNoMusic();
		return music;
	}
}
