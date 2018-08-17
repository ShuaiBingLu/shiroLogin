package cn.bin2.shiro.manager;

import org.apache.shiro.SecurityUtils;

import cn.bin2.shiro.token.UserToken;
import cn.bin2.web.entity.User;

public class TokenManager {
	
	
	public static User userLogin(User user,Boolean remeber){
		UserToken token = new UserToken(user.getUserName(), user.getUserPwd());
		token.setRememberMe(remeber);
		SecurityUtils.getSubject().login(token);
		return (User)SecurityUtils.getSubject().getPrincipal();
	}
}
