package com.changqin.well.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.changqin.well.common.config.Department;
import com.changqin.well.common.config.SelectOption;
import com.changqin.well.common.utils.CookieUtils;
import com.changqin.well.entry.WellInfo;

/**
 * @author LiuTing
 * @version 2017年8月12日 上午11:38:24
 * 
 */
@Controller
@RequestMapping(value = "/cms")
public class WellFormController {
	@RequestMapping(value = "form")
	public String enteringInfo(HttpServletRequest request,Model model) {
		String department = CookieUtils.getCookie(request, "department");
		Department dep = Department.valueOf(department);
		WellInfo wellInfo = new WellInfo();
		model.addAttribute("wellInfo", wellInfo);
		model.addAttribute("dep", dep.getName());
		return "wellForm";
	}
	@ModelAttribute("designTypeList")
	public List<String> getdesignType(){
		return SelectOption.getDesignType();
	}
	@ModelAttribute("currentTypeList")
	public List<String> getCurrentTypeList(){
		return SelectOption.getCurrentType();
	}
	@ModelAttribute("departmentList")
	public List<String> getDepartmentList(){
		return SelectOption.getDepartmentList();
	}
	@ModelAttribute("scrapTypeList")
	public List<String> getScrapTypeList(){
		return SelectOption.getScrapTypeList();
	}
	@ModelAttribute("wellCompletionList")
	public List<String> getWellCompletionList(){
		return SelectOption.getWellCompletion();
	}
	@ModelAttribute("casingDeformationTypeList")
	public List<String> getCasingDeformationTypeList(){
		return SelectOption.getCasingDeformationType();
	}
	@ModelAttribute("shutWellStateList")
	public List<String> getShutWellStateList(){
		return SelectOption.getShutWellState();
	}
	@ModelAttribute("riskRankList")
	public List<String> getRiskRankList(){
		return SelectOption.getRiskRankList();
	}
	@ModelAttribute("geoRiskList")
	public List<String> getGeoRiskList(){
		return SelectOption.getGeoRiskList();
	}
	@ModelAttribute("nextSchemaList")
	public List<String> getNextSchemaList(){
		return SelectOption.getNextSchemaList();
	}
}
