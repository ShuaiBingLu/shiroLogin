package cn.bin2.web.service;

import org.springframework.http.StreamingHttpOutputMessage;

import cn.bin2.web.entity.User;

public interface IUserService {
	User userLogin(String userName,String pwd);
	int updateLoginTime(User user);
}
