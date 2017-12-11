package com.changqin.well.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LiuTing
 * @version 2017年8月5日 上午10:28:45
 * 
 */
@Controller
public class HomeController {
	@RequestMapping(value="/",method=RequestMethod.GET)
    public String home(){
       return "sysLogin";
    }
}
