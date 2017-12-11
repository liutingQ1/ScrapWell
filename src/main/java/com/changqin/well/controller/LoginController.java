/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.changqin.well.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.changqin.well.common.config.Department;
import com.changqin.well.common.utils.CookieUtils;
import com.changqin.well.entry.User;
import com.changqin.well.service.UserService;

/**
 * 
 * @author LiuTing
 * @version 2017年8月22日 下午8:47:32
 *
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userServer;
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login() {
//		return "sysLogin";
//	}
	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userServer.login(username, password);
		if(user!=null){
			CookieUtils.setCookie(response, "userId", user.getId().toString());
			CookieUtils.setCookie(response, "viewAuthority", user.hasViewAuthority()+"");
			CookieUtils.setCookie(response, "recordAuthority", user.hasRecordAuthority()+"");
			CookieUtils.setCookie(response, "modifyAuthority", user.hasModifyAuthority()+"");
			CookieUtils.setCookie(response, "deleteAuthority", user.hasDeleteAuthority()+"");
			CookieUtils.setCookie(response, "checkAuthority", user.hasCheckAuthority()+"");
			CookieUtils.setCookie(response, "department", user.getDepartment().name());
			if(user.getDepartment().name().equals(Department.ADMIN.name()))
				model.addAttribute("myPage", "${ctx}/cms/accountList");
			else
				model.addAttribute("myPage", "${ctx}/cms/infoQuery");
			return "sysIndex";
		}else{
			model.addAttribute("message", "用户或密码错误, 请重试.");
			return "sysLogin";
		}
	}
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
		CookieUtils.setCookie(response, "userId", "", -1);
		CookieUtils.setCookie(response, "viewAuthority", "", -1);
		CookieUtils.setCookie(response, "recordAuthority", "", -1); 
		CookieUtils.setCookie(response, "modifyAuthority", "", -1); 
		CookieUtils.setCookie(response, "deleteAuthority", "", -1); 
		CookieUtils.setCookie(response, "checkAuthority", "", -1); 
		CookieUtils.setCookie(response, "department", "", -1); 
		return "sysLogin";
	}
}
