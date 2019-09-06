package com.shiqihang.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiqihang.entity.Control;
import com.shiqihang.entity.User;
import com.shiqihang.mapper.StudentMapper;

@Service(interfaceClass=StudentService.class)
public class StudentServiceImpl implements StudentService {
	@Resource
	StudentMapper studentMapper;
	
	@Override
	public String sysHello(String name) {
		// TODO Auto-generated method stub
		return "hi,"+name;
	}

	@Override
	public User selectsStudent(String name) {
		// TODO Auto-generated method stub
		return new User(1,name,new Date());
	}

	@Override
	public PageInfo<Map> list(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<>(studentMapper.list());
	}

	@Override
	public List<Control> selectControl() {
		// TODO Auto-generated method stub
		return studentMapper.selectControl();
	}

	@Override
	public boolean deleteAll(String[] ids) {
		// TODO Auto-generated method stub
		try {
			studentMapper.deleteUser(ids);
			for (String id : ids) {
				studentMapper.deleteControl(id);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.getUser(id);
	}

	@Override
	public List<Control> getControl(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.getControl(id);
	}

	@Override
	public boolean saveUser(User user, Integer[] ids) {
		// TODO Auto-generated method stub
		try {
			studentMapper.saveUser(user);
			for (Integer id : ids) {
				studentMapper.saveMiddle(user.getId(),id);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
