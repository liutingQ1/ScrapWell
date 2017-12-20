package com.changqin.well.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/cms")
public class SysGuideController {
	

	@RequestMapping(value = "sysGuide")
	public String guide() {
		return "sysGuide";
	}
}
