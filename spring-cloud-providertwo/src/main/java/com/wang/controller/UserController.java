package com.wang.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wang.bean.DbUtil;
import com.wang.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DbUtil dbUtil;
	
	@RequestMapping("getUsers")
	public List<String>getUsers(){
		List<String>users=userService.getUserList();
		return users;
	}
	
	@RequestMapping("getMusic")
	public String getMusic() {
		return "千里之外，青花瓷，发如雪，东风破-2";
	}
	
	@RequestMapping("getDb")
	public List<String> getDb(){
		return Arrays.asList(dbUtil.url,dbUtil.username,dbUtil.password,dbUtil.driver);
	}
}
