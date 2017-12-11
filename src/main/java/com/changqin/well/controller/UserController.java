/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.changqin.well.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.changqin.well.common.config.Authority;
import com.changqin.well.common.config.Department;
import com.changqin.well.common.persistence.Page;
import com.changqin.well.common.utils.CookieUtils;
import com.changqin.well.entry.User;
import com.changqin.well.service.UserService;

/**
 * 用户Controller
 * @author LiuTing
 * @version 2017年8月6日 下午4:00:20
 *
 */
@Controller
@RequestMapping(value = "/cms")
public class UserController {
	
	@Autowired
	private UserService userServer;
	@ModelAttribute
	public User get(@RequestParam(required=false) String id) {
		if (id!=null&&!id.equals("")){
			return userServer.getByUserId(Integer.valueOf(id));
		}else{
			return new User();
		}
	}
	@RequestMapping(value = "/modifyPassword")
	public String modifyPwd(HttpServletRequest request, Model model) {
		String userId = CookieUtils.getCookie(request, "userId");
		User user = userServer.getByUserId(Integer.valueOf(userId));
		model.addAttribute("user", user);
		return "modifyPassword";
	}
	
	@RequestMapping(value = "modifyPsw")
	public String modify(User user, String oldPassword, String newPassword, Model model) {
		User userN = userServer.updatePassword(user.getId(), newPassword);
		if (userN!=null){
			model.addAttribute("message", "修改密码成功");
		}else{
			model.addAttribute("message", "修改密码失败，旧密码错误");
		}
		model.addAttribute("user", userN);
		return "modifyPassword";
	}
	@RequestMapping(value = "accountList")
	public String accountList(HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<User> page = userServer.findPage(new Page<User>(request, response));
        model.addAttribute("page", page);
		return "userList";
	}
	@RequestMapping(value = "/accountAdd")
	public String accountAdd(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("user", user);
		return "userAdd";
	}
	@RequestMapping(value = "accountDelete")
	public String accountDelete(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
		userServer.deleteUser(user);
		return "redirect:" + "/cms/accountList";
	}
	@RequestMapping(value = "accountSave")
	public String accountSave(User user, HttpServletRequest request, String dep, String viewAuthority, 
			String recordAuthority,String modifyAuthority, String deleteAuthority, String checkAuthority,  
			RedirectAttributes redirectAttributes) {
		Department department = Department.getDepartment(dep);
		user.setDepartment(department);
		if(viewAuthority!=null)
			user.setViewAuthority(Authority.VIEW);
		else
			user.setViewAuthority(null);
		if(recordAuthority!=null)
			user.setRecordAuthority(Authority.RECORD);
		else
			user.setRecordAuthority(null);
		if(modifyAuthority!=null)
			user.setModifyAuthority(Authority.MODIFY);
		else
			user.setModifyAuthority(null);
		if(deleteAuthority!=null)
			user.setDeleteAuthority(Authority.DELETE);
		else
			user.setDeleteAuthority(null);
		if(checkAuthority!=null)
			user.setCheckAuthority(Authority.CHECK);
		else
			user.setCheckAuthority(null);
		if(user.getId()==null){
			boolean hasUser = userServer.hasUser(user.getUsername());
			if(hasUser){
				this.addMessage(redirectAttributes, "用户已存在！");
				return "redirect:" + "/cms/accountAdd";
			}else{
				userServer.saveUser(user);
			}
		}else{
			userServer.updateUser(user);
		}
		return "redirect:" + "/cms/accountList";
	}
	@ModelAttribute("departmentList")
	public List<String> getDepartmentList(){
		Department[] values = Department.values();
		List<String> list = new ArrayList<>();
		for(int i=0;i<values.length;i++){
			list.add(values[i].getName());
		}
		return list;
	}
	/**
	 * 添加Flash消息
	 * @param message
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		redirectAttributes.addFlashAttribute("message", sb.toString());
	}
}
