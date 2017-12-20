package com.changqin.well.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changqin.well.common.config.Department;
import com.changqin.well.common.utils.CookieUtils;
import com.changqin.well.entry.Category;

@Controller
@RequestMapping(value = "/cms")
public class CmsController {
	
	@RequestMapping(value = "")
	public String index(HttpServletRequest request, Model model) {
		String department = CookieUtils.getCookie(request, "department");
		if(department.equals(Department.ADMIN.name()))
			model.addAttribute("myPage", "accountList");
		else
			model.addAttribute("myPage", "infoQuery");
		return "cmsIndex";
	}
	
	@RequestMapping(value = "tree")
	public String tree(HttpServletRequest request, Model model) {
		String department = CookieUtils.getCookie(request, "department");
		String recordAuthority = CookieUtils.getCookie(request, "recordAuthority");
		List<Category> categoryList = new ArrayList<>();
		
		if(department.equals(Department.ADMIN.name())){
			Category c = new Category(1, "信息管理", "accountList", 1, null);
			categoryList.add(c);
			Category a = new Category(5, "账号管理", "accountList", 2, c);
			categoryList.add(a);
		}else if(department.equals(Department.GENERAL.name())){
			Category c = new Category(1, "信息管理", "infoQuery", 1, null);
			Category c1 = new Category(2, "信息查询", "infoQuery", 1, c);
			categoryList.add(c);
			categoryList.add(c1);
			Category s = new Category(3, "系统说明", "sysGuide ", 1, null);
			categoryList.add(s);
		}else{
			boolean b1 = department.equals(Department.TASK1.name());
			boolean b2 = department.equals(Department.TASK2.name());
			boolean b3 = department.equals(Department.TASK3.name());
			boolean b4 = department.equals(Department.MINING.name());
			Category c = new Category(1, "信息管理", "infoQuery", 1, null);
			if(b1||b2||b3||b4){//三个作业区和专采队具有录入权限的才能录入
				if(recordAuthority.equals("1")){
					Category c2 = new Category(3, "信息录入", "form", 2, c);
					categoryList.add(c2);
				}
			}
			Category c1 = new Category(2, "信息查询", "infoQuery", 1, c);
			Category c3 = new Category(4, "信息审核", "infoCheck", 3, c);
			categoryList.add(c);
			categoryList.add(c1);
			categoryList.add(c3);
			
			Category p = new Category(6, "密码修改", "modifyPassword", 1, null);
			categoryList.add(p);
			
			Category s = new Category(7, "系统说明", "sysGuide ", 1, null);
			categoryList.add(s);
			
		}
		
		model.addAttribute("categoryList", categoryList);
		return "cmsTree";
	}
	
}
