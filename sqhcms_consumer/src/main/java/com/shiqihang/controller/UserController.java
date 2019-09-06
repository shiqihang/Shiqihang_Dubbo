package com.shiqihang.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.shiqihang.entity.Control;
import com.shiqihang.entity.User;
import com.shiqihang.service.StudentService;
/**
 * @author admin
 *	控制类
 */
@Controller
public class UserController {
	@Reference
	private StudentService StudentService;
	
	/**
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return 展示列表方法
	 */
	@GetMapping("list")
	public String selectObject(HttpServletRequest request,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="3")Integer pageSize) {
		PageInfo<Map> pageInfo = StudentService.list(pageNum, pageSize);
		request.setAttribute("pageInfo", pageInfo);
		return "user_list";
	}
	/**
	 * 
	 * @param request
	 * @return
	 * 添加查询权限集合
	 */
	@GetMapping("toSaveUser")
	public String toSaveUser(HttpServletRequest request) {
		List<Control> list = new ArrayList<>();
		/*if(redisTemplate.hasKey("Exam01_type")) {
			list = (List<Control>) redisTemplate.opsForValue().get("Exam01_type");
		}else {
			list = StudentService.selectControl();
			redisTemplate.opsForValue().set("Exam01_type", list);
		}*/
		list = StudentService.selectControl();
		request.setAttribute("list", list);
		return "user_save";
	}
	/**
	 * 
	 * @param ids
	 * @return
	 * 批量删除
	 */
	@ResponseBody
	@PostMapping("deleteAll")
	public boolean deleteAll(String[] ids) {
		return StudentService.deleteAll(ids);
	}
	/**
	 * 
	 * @param request
	 * @param id
	 * @return
	 * 用户查看
	 */
	@GetMapping("getUser")
	public String getUser(HttpServletRequest request,Integer id) {
		User user = StudentService.getUser(id);
		List<Control> control = StudentService.getControl(id);
		request.setAttribute("user", user);
		request.setAttribute("control", control);
		return "user_char";
	}
	/**
	 * 
	 * @param user
	 * @param ids
	 * @return
	 * 添加用户
	 */
	@ResponseBody
	@PostMapping("saveUser")
	public boolean saveUser(User user,Integer[] ids) {
		return StudentService.saveUser(user,ids);
	}
}
