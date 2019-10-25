package com.wang.service.impl;

import org.springframework.stereotype.Component;

import com.wang.service.DataService;
@Component
public class DataServiceFailImpl implements DataService{

	@Override
	public String getMusic() {
		return "getMusic 调用失败，返回默认结果";
	}

	@Override
	public String getNoMusic() {
		return "getNoMusic 调用失败，返回默认结果";
	}

}
