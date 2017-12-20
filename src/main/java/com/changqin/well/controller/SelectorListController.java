package com.changqin.well.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changqin.well.entry.Category;

@Controller
@RequestMapping(value = "/cms")
public class SelectorListController {
	@RequestMapping(value = "selector/wellTypeList")
	public String wellTypes(Model model) {
		List<Category> categoryList = new ArrayList<>();
		Category c = new Category(1, "信息管理", "list", 1, null);
		Category c1 = new Category(2, "信息查询", "list", 1, c);
		Category c2 = new Category(3, "信息录入", "form", 2, c);
		Category c3 = new Category(4, "信息审核", "checkInfo", 3, c);
		categoryList.add(c);
		categoryList.add(c1);
		categoryList.add(c2);
		categoryList.add(c3);
		
		Category p = new Category(5, "密码修改", "modifyPassword", 1, null);
		categoryList.add(p);
		
		Category s = new Category(6, "系统说明", "sysGuide ", 1, null);
		categoryList.add(s);
		
		model.addAttribute("categoryList", categoryList);
		return "cmsTree";
	}
}
