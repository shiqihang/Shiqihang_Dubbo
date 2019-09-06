package com.shiqihang.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.shiqihang.entity.Control;
import com.shiqihang.entity.User;

public interface StudentService {
	
	String sysHello(String name);
	
	User selectsStudent(String name);
	
	PageInfo<Map> list(Integer pageNum,Integer pageSize);
	
	List<Control> selectControl();

	boolean deleteAll(String[] ids);

	User getUser(Integer id);

	List<Control> getControl(Integer id);
	
	boolean saveUser(User user, Integer[] ids);
}
