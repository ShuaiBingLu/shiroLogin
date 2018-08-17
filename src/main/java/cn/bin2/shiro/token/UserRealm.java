package cn.bin2.shiro.token;

import java.util.Date;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.bin2.web.entity.User;
import cn.bin2.web.service.IUserService;
import cn.bin2.web.service.impl.UserService;
import sun.tools.tree.ThisExpression;

public class UserRealm extends AuthorizingRealm{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public  UserRealm() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Autowired
	private UserService userService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		UserToken userToken = (UserToken) token;
		logger.info(userToken.getUserName());
		logger.info(userToken.getPwd());
		User iUser = userService.userLogin(userToken.getUsername(), userToken.getPwd());
		
		if(null==iUser){
			throw new AccountException("password error");
		}else if(iUser.getLoginStatus()==0){
			throw new DisabledAccountException("account locked");
		}else{  
			iUser.setLastLoginTime(new Date());
			userService.updateLoginTime(iUser);
		}
		
		return new SimpleAuthenticationInfo(iUser,iUser.getUserPwd(),getName());
	}

}
