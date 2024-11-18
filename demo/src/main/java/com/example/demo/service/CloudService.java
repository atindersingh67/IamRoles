package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Resource;

public interface CloudService {
	
	List<Resource> getResource() throws Exception;

}
