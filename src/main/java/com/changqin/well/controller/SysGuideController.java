/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.changqin.well.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户Controller
 * @author LiuTing
 * @version 2017年8月6日 下午4:00:20
 *
 */
@Controller
@RequestMapping(value = "/cms")
public class SysGuideController {
	

	@RequestMapping(value = "sysGuide")
	public String guide() {
		return "sysGuide";
	}
}
