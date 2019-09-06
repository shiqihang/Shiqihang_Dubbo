package com.shiqihang.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shiqihang.entity.Control;
import com.shiqihang.entity.User;

public interface StudentMapper {
	
	@Select("select a.*,group_concat(c.type) types from user a left join middle b on a.id=b.uid left join control c on b.cid=c.id group by a.id")
	List<Map> list();
	
	@Select("select * from control")
	List<Control> selectControl();
	
	@Select("select * from user where id=#{id}")
	User getUser(Integer id);
	
	@Select("select group_concat(c.type) type from user a left join middle b on a.id=b.uid left join control c on b.cid=c.id group by a.id having id=#{id}")
	List<Control> getControl(Integer id);

	void deleteUser(String[] ids);

	void deleteControl(String id);

	void saveUser(User user);

	void saveMiddle(@Param("uid")Integer uid, @Param("cid")Integer cid);
	
}
