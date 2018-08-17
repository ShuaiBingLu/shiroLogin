package cn.bin2.web.dao;

import org.apache.ibatis.annotations.Param;

import cn.bin2.web.entity.User;

public interface UserDao {
	User userLogin(@Param("userName")String userName,@Param("userPwd")String pwd);
	
	int updateLoginTime(User user);
}
