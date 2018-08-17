package cn.bin2.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.logging.Log;

import cn.bin2.shiro.manager.TokenManager;
import cn.bin2.web.entity.User;
import sun.tools.tree.ThisExpression;

@Controller
public class IndexController {
	private Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
	private Logger log =LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(User user, HttpServletRequest request) {
		try {
			
			Boolean remeberMe = false;
			if(null!=request.getAttribute("remeberMe")&&request.getAttribute("remeberMe")!=""){
				remeberMe = true;
			}
			
			User user2 = TokenManager.userLogin(user, remeberMe);
			hashMap.put("status", 200);
			hashMap.put("message", "登录成功");
			SavedRequest savedRequest = WebUtils.getSavedRequest(request);
			String url = null;
			if (null != savedRequest) {
				url = savedRequest.getRequestUrl();
			}
			if (url == "") {
				url = request.getContextPath() + "/index";
			}
		} catch (DisabledAccountException e) {
			hashMap.put("status", 500);
			hashMap.put("message", "帐号已经禁用。");
		}
		return hashMap;
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	
	public ModelAndView index(){
		return new ModelAndView("index");
	}
}
