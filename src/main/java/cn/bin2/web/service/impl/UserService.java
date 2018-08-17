package cn.bin2.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bin2.web.dao.UserDao;
import cn.bin2.web.entity.User;
import cn.bin2.web.service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserDao userDao;
	public User userLogin(String userName,String pwd){
		return userDao.userLogin(userName, pwd);
	}
	public int updateLoginTime(User user) {
		// TODO Auto-generated method stub
		return userDao.updateLoginTime(user);
	}
}
