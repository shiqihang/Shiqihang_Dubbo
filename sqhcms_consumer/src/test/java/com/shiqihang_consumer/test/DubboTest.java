package com.shiqihang_consumer.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shiqihang.entity.User;
import com.shiqihang.service.StudentService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class DubboTest {
	@Reference
	StudentService studentService;
	
	@Test
	public void TestHello() {
		String sysHello = studentService.sysHello("shiyi");
		System.out.println(sysHello+"@@@@");
	}
	
	@Test
	public void TestStudent() {
		User selectsStudent = studentService.selectsStudent("shier");
		System.out.println(selectsStudent);
	}
}
