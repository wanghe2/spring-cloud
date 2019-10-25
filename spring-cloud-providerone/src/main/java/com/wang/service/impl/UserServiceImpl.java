package com.wang.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wang.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{

	@Override
	public List<String> getUserList() {
		List<String>users=Arrays.asList("楚留香","胡铁花","原随风");
		return users;
	}
 
}
