package com.wang.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbUtil {
	
	@Value("${datasource.url}")
	public  String url;
	
	@Value("${datasource.username}")
	public  String username;
	
	@Value("${datasource.password}")
	public  String password;
	
	@Value("${datasource.driver}")
	public  String driver;
	

}
