/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.changqin.well.controller;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.changqin.well.common.config.Department;
import com.changqin.well.common.config.Global;
import com.changqin.well.common.config.InfoState;
import com.changqin.well.common.config.SelectOption;
import com.changqin.well.common.persistence.Page;
import com.changqin.well.common.utils.CookieUtils;
import com.changqin.well.common.utils.DateUtils;
import com.changqin.well.common.utils.Encodes;
import com.changqin.well.entry.ImageYear;
import com.changqin.well.entry.WellInfo;
import com.changqin.well.service.WellService;


/**
 * 油气井相关控制
 * @author LiuTing
 * @version 2017年8月27日 下午2:48:52
 *
 */
@Controller
@RequestMapping(value = "/cms")
public class WellController {
	@Autowired
	WellService ws;
	
	@ModelAttribute
	public WellInfo get(@RequestParam(required=false) String id) {
		if (id!=null&&!id.equals("")){
			return ws.findById(Integer.valueOf(id));
		}else{
			return new WellInfo();
		}
	}
	
	@RequestMapping(value = "infoQuery")
	public String query(WellInfo wellInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		String modifyAuthority = CookieUtils.getCookie(request, "modifyAuthority");
		String deleteAuthority = CookieUtils.getCookie(request, "deleteAuthority");
		wellInfo.setState(InfoState.PASS);
        Page<WellInfo> page = ws.findPage(new Page<WellInfo>(request, response), wellInfo); 
        model.addAttribute("page", page);
        model.addAttribute("modifyAuthority", modifyAuthority);
        model.addAttribute("deleteAuthority", deleteAuthority);
		return "wellInfoQuery";
	}
	
	@RequestMapping(value = "infoQuerySelect")
	public String querySelect(WellInfo wellInfo, String dep, HttpServletRequest request, HttpServletResponse response, Model model) {
		String modifyAuthority = CookieUtils.getCookie(request, "modifyAuthority");
		String deleteAuthority = CookieUtils.getCookie(request, "deleteAuthority");
		Department dp1 = Department.getDepartment(dep);//查询条件中的部门参数
		wellInfo.setDepartment(dp1);
		wellInfo.setState(InfoState.PASS);
		Page<WellInfo> page = ws.findPage(new Page<WellInfo>(request, response), wellInfo); 
        model.addAttribute("page", page);
        model.addAttribute("modifyAuthority", modifyAuthority);
        model.addAttribute("deleteAuthority", deleteAuthority);
		return "wellInfoQuery";
	}
	
	@RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(WellInfo wellInfo,  String dep, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			Department dp1 = Department.getDepartment(dep);//查询条件中的部门参数
			wellInfo.setDepartment(dp1);
			wellInfo.setState(InfoState.PASS);
            String fileName = "WellData"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
    		Page<WellInfo> page = ws.findPage(new Page<WellInfo>(request, response), wellInfo);
    		List<WellInfo> list = page.getList();
    		response.reset();
            response.setContentType("application/vnd.ms-excel; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename="+Encodes.urlEncode(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("WellInfo");
            Map<String, String> mapFiledName = Global.getMapFiledName();
            Map<String, Integer> mapFiledIndex = Global.getMapFiledIndex();
            Row firstRow = sheet.createRow(0);
            Cell cell = firstRow.createCell(0);
            cell.setCellValue("序号");
            int i=0;
            for(Map.Entry<String, String> entry : mapFiledName.entrySet()){
            	String name = entry.getValue();
            	cell = firstRow.createCell(mapFiledIndex.get(entry.getKey()));
            	cell.setCellValue(name);
            }
            for(WellInfo wf : list){
            	Row row = sheet.createRow(++i);
            	cell = row.createCell(0);
            	cell.setCellValue(i);
            	Field[] fields = WellInfo.class.getDeclaredFields();
                for(int j=0;j<fields.length;j++){
                	String field = fields[j].getName();
                	if(mapFiledIndex.containsKey(field)){
                		PropertyDescriptor pd = new PropertyDescriptor(field, WellInfo.class);
                		Method method = pd.getReadMethod();
                		Object value = method.invoke(wf);
                		cell = row.createCell(mapFiledIndex.get(field));
                		if(value!=null)
                			cell.setCellValue(value.toString());
                		else
                			cell.setCellValue("");
                	}
                }
            }
            workbook.write(response.getOutputStream());
            workbook.close();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "导出用户失败！失败信息："+e.getMessage());
		}
		return "wellInfoQuery";
    }
	
	@RequestMapping(value = "infoCheck")
	public String check(WellInfo wellInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		String modifyAuthority = CookieUtils.getCookie(request, "modifyAuthority");
		String deleteAuthority = CookieUtils.getCookie(request, "deleteAuthority");
		String checkAuthority = CookieUtils.getCookie(request, "checkAuthority");
		String department = CookieUtils.getCookie(request, "department");
		Department dp = Department.valueOf(department);
		wellInfo.setOperator(dp);
		Page<WellInfo> page;
		page = ws.findPage(new Page<WellInfo>(request, response), wellInfo); 
        model.addAttribute("page", page);
        model.addAttribute("modifyAuthority", modifyAuthority);
        model.addAttribute("deleteAuthority", deleteAuthority);
        model.addAttribute("checkAuthority", checkAuthority);
        model.addAttribute("department", department);
        switch (dp) {
		case TASK1:
		case TASK2:
		case TASK3:
		case MINING:
			return "wellInfoCheck1";	
		case GEOGRAPHY:
			return "wellInfoCheck2";
		case ENGINEERING:
			return "wellInfoCheck3";
		default:
			break;
		}
		return "wellInfoCheck1";
	}
	@RequestMapping(value = "infoCheckSelect")
	public String checkSelect(WellInfo wellInfo, String dep, HttpServletRequest request, HttpServletResponse response, Model model) {
		String modifyAuthority = CookieUtils.getCookie(request, "modifyAuthority");
		String deleteAuthority = CookieUtils.getCookie(request, "deleteAuthority");
		String checkAuthority = CookieUtils.getCookie(request, "checkAuthority");
		Department dp1 = Department.getDepartment(dep);//查询条件中的部门参数
		wellInfo.setDepartment(dp1);
		wellInfo.setState(null);//状态通过参数来控制，避免对象上的非NULL干扰
		String dp2 = CookieUtils.getCookie(request, "department");//用户的部门信息
		Department department = Department.valueOf(dp2);
		wellInfo.setOperator(department);
        Page<WellInfo> page = ws.findPage(new Page<WellInfo>(request, response), wellInfo);
        model.addAttribute("page", page);
        model.addAttribute("modifyAuthority", modifyAuthority);
        model.addAttribute("deleteAuthority", deleteAuthority);
        model.addAttribute("checkAuthority", checkAuthority);
        model.addAttribute("department", department);
        switch (department) {
		case TASK1:
		case TASK2:
		case TASK3:
		case MINING:
			return "wellInfoCheck1";	
		case GEOGRAPHY:
			return "wellInfoCheck2";
		case ENGINEERING:
			return "wellInfoCheck3";
		default:
			break;
		}
		return "wellInfoCheck1";
	}
	@RequestMapping(value = "save")
	public String save(WellInfo wellInfo, HttpServletRequest request, String dep,
			String year, MultipartFile iamge1, MultipartFile iamge2, MultipartFile iamge3, Model model) {
		wellInfo.setState(InfoState.COMMIT);
		Department department = Department.getDepartment(dep);
		wellInfo.setDepartment(department);
		String ope = CookieUtils.getCookie(request, "department");
		Department operator = Department.valueOf(ope);
		wellInfo.setOperator(operator);//信息当前处理部门
		String filePath = request.getSession().getServletContext().getRealPath("");
		String name1="";
		String name2="";
		String name3="";
		Date date = new Date();
		String yy = String.valueOf(date.getYear()+1900);
		String month=String.valueOf(date.getMonth()+1);
		String day = String.valueOf(date.getDate());
		String hour = String.valueOf(date.getHours());
		String min = String.valueOf(date.getMinutes());
		String sec = String.valueOf(date.getSeconds());
		StringBuffer sb = new StringBuffer();
		StringBuffer append = sb.append(yy).append(month).append(day).append(hour).append(min).append(sec);
		try {
			File file = new File(filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			if(!iamge1.isEmpty()){  
				String contentType=iamge1.getContentType();  
				String suffix=contentType.substring(contentType.indexOf("/")+1);
				name1 = "\\static\\wellImages\\iamgeOne"+append+"."+suffix;
				iamge1.transferTo(new File(filePath+ name1));  
			}  
			if(!iamge2.isEmpty()){  
				String contentType=iamge2.getContentType();  
				String suffix=contentType.substring(contentType.indexOf("/")+1);  
				name2 = "\\static\\wellImages\\iamgeTwo"+append+"."+suffix;
				iamge2.transferTo(new File(filePath+ name2));   
			}  
			if(!iamge3.isEmpty()){  
				String contentType=iamge3.getContentType();  
				String suffix=contentType.substring(contentType.indexOf("/")+1);  
				name3 = "\\static\\wellImages\\iamgeThree"+append+"."+suffix;
				iamge3.transferTo(new File(filePath+ name3));   
			}  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Set<ImageYear> images = wellInfo.getImages();
		ImageYear imageYear=null;
		if(images!=null){
			for(ImageYear iy : images){
				if(iy.getYear()==Integer.valueOf(year)){
					imageYear = iy;
					break;
				}
			}
			if(imageYear==null){//没有该年图片
				if(!iamge1.isEmpty()||!iamge2.isEmpty()||!iamge3.isEmpty()){
					imageYear = new ImageYear();//需要上传该年图片
					imageYear.setYear(Integer.valueOf(year));
					images.add(imageYear);
				}
			}
			if(!iamge1.isEmpty()){
				imageYear.setImage1(name1);
			}
			if(!iamge2.isEmpty()){
				imageYear.setImage2(name2);
			}
			if(!iamge3.isEmpty()){
				imageYear.setImage3(name3);
			}
		}else{
			imageYear = new ImageYear();
			imageYear.setYear(Integer.valueOf(year));
			boolean flag = false;
			if(!iamge1.isEmpty()){
				imageYear.setImage1(name1);
				flag = true;
			}
			if(!iamge2.isEmpty()){
				imageYear.setImage2(name2);
				flag = true;
			}
			if(!iamge3.isEmpty()){
				imageYear.setImage3(name3);
				flag = true;
			}
			if(flag){//提交信息中有照片信息
				images = new HashSet<>();
				images.add(imageYear);
				wellInfo.setImages(images);
			}
		}
		if (wellInfo.getId() == null) {
			ws.save(wellInfo);
		} else {
			ws.update(wellInfo);
		}
		return "redirect:" + "/cms/infoCheck";
	}
	@RequestMapping(value = "sendBack")
	public String sendBack(WellInfo wellInfo, Model model) {
		WellInfo wellInfo2 = ws.findById(wellInfo.getId());
		wellInfo2.setState(InfoState.BACK);
		ws.update(wellInfo2);
		return "redirect:" + "/cms/infoCheck";
	}
	@RequestMapping(value = "agree")
	public String agree(WellInfo wellInfo, Model model) {
		WellInfo wellInfo2 = ws.findById(wellInfo.getId());
		wellInfo2.setState(InfoState.PASS);
		wellInfo2.setOperator(null);//信息当前处理部门
		ws.update(wellInfo2);
		return "redirect:" + "/cms/infoQuery";
	}
	@RequestMapping(value = "delete")
	public String delete(WellInfo wellInfo, String myPage, Model model) {
		ws.delete(wellInfo);
		if(myPage.equals("query"))
			return "redirect:" + "/cms/infoQuery";
		else
			return "redirect:" + "/cms/infoCheck";
	}
	@RequestMapping(value = "modify")
	public String modify(WellInfo wellInfo, Model model) {
		model.addAttribute("wellInfo", wellInfo);
		model.addAttribute("dep", wellInfo.getDepartment().getName());
		return "wellForm";
	}
	@RequestMapping(value = "detail")
	public String detail(WellInfo wellInfo, Model model) {
		model.addAttribute("wellInfo", wellInfo);
		return "wellDetail";
	}
	@RequestMapping(value = "images")
	public String images(WellInfo wellInfo, Model model) {
		Set<ImageYear> images = wellInfo.getImages();
		model.addAttribute("imageList", images);
		return "imageList";
	}
	@ModelAttribute("designTypeList")
	public List<String> getdesignType(){
		return SelectOption.getDesignType();
	}
	@ModelAttribute("currentTypeList")
	public List<String> getCurrentType(){
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
	@ModelAttribute("casingDeformationTypeList")
	public List<String> getCasingDeformationTypeList(){
		return SelectOption.getCasingDeformationType();
	}
	@ModelAttribute("nextSchemaList")
	public List<String> getNextSchemaList(){
		return SelectOption.getNextSchemaList();
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
