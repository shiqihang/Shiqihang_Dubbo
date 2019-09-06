package com.shiqihang;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;
import com.shiqihang.entity.User;
import com.shiqihang.service.StudentService;

public class Start {
	
	static Logger log = Logger.getLogger(Start.class);
	
	public static void main(String[] args) throws IOException {
		log.trace("十五开始");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		/*StudentService ss = context.getBean(StudentService.class);
		PageInfo<User> list = ss.list(1, 3);
		System.out.println(list+"@@--------------------------");*/
		log.trace("结束!");
		System.in.read();
	}
}
