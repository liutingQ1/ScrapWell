/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.changqin.well.common.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.DefaultResourceLoader;

import com.changqin.well.common.utils.PropertiesLoader;
import com.changqin.well.common.utils.StringUtils;
import com.ckfinder.connector.ServletContextFactory;
import com.google.common.collect.Maps;


public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();
	/**
	 * 井的属性名称
	 */
	private static Map<String, String> mapFieldsName = Maps.newLinkedHashMap();
	/**
	 * 井的属性索引
	 */
	private static Map<String, Integer> mapFieldsIndex = Maps.newLinkedHashMap();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("well.properties");

	/**
	 * 显示/隐藏
	 */
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	/**
	 * 是/否
	 */
	public static final String YES = "1";
	public static final String NO = "0";
	
	/**
	 * 对/错
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	/**
	 * 上传文件基础虚拟路径
	 */
	public static final String USERFILES_BASE_URL = "/userfiles/";
	
	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置
	 * @see ${fns:getConfig('adminPath')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}
	
	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	
	/**
	 * 获取前端根路径
	 */
	public static String getFrontPath() {
		return getConfig("frontPath");
	}
	
	/**
	 * 获取URL后缀
	 */
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}
	
	/**
	 * 是否是演示模式，演示模式下不能修改用户、角色、密码、菜单、授权
	 */
	public static Boolean isDemoMode() {
		String dm = getConfig("demoMode");
		return "true".equals(dm) || "1".equals(dm);
	}
	
	/**
	 * 在修改系统用户和角色时是否同步到Activiti
	 */
	public static Boolean isSynActivitiIndetity() {
		String dm = getConfig("activiti.isSynActivitiIndetity");
		return "true".equals(dm) || "1".equals(dm);
	}
    
	/**
	 * 页面获取常量
	 * @see ${fns:getConst('YES')}
	 */
	public static Object getConst(String field) {
		try {
			return Global.class.getField(field).get(null);
		} catch (Exception e) {
			// 异常代表无配置，这里什么也不做
		}
		return null;
	}

    /**
     * 获取工程路径
     * @return
     */
    public static String getProjectPath(){
    	// 如果配置了工程路径，则直接返回，否则自动获取。
		String projectPath = Global.getConfig("projectPath");
		if (StringUtils.isNotBlank(projectPath)){
			return projectPath;
		}
		try {
			File file = new DefaultResourceLoader().getResource("").getFile();
			if (file != null){
				while(true){
					File f = new File(file.getPath() + File.separator + "src" + File.separator + "main");
					if (f == null || f.exists()){
						break;
					}
					if (file.getParentFile() != null){
						file = file.getParentFile();
					}else{
						break;
					}
				}
				projectPath = file.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projectPath;
    }
    /**
	 * 获取上传文件的根目录
	 * @return
	 */
	public static String getUserfilesBaseDir() {
		String dir = getConfig("userfiles.basedir");
		if (StringUtils.isBlank(dir)){
			try {
				dir = ServletContextFactory.getServletContext().getRealPath("/");
			} catch (Exception e) {
				return "";
			}
		}
		if(!dir.endsWith("/")) {
			dir += "/";
		}
//		System.out.println("userfiles.basedir: " + dir);
		return dir;
	}
	public static Map<String, String> getMapFiledName(){
		if(mapFieldsName.isEmpty()){
			/* 基础资料  */
			mapFieldsName.put("code", "井号");
			mapFieldsName.put("designType", "设计井别");
			mapFieldsName.put("currentType", "目前井别");
			mapFieldsName.put("department", "单位代码");
			mapFieldsName.put("productState", "生产状态");
			mapFieldsName.put("isAbandon", "是否在册");
			mapFieldsName.put("isScrap", "是否报废");
			mapFieldsName.put("scrapType", "报废类型");
			mapFieldsName.put("isCount", "是否计井数");
			
			/* 地质概况  */
			mapFieldsName.put("structure", "构造位置");
			mapFieldsName.put("blockUnit", "区块单元代码");
			mapFieldsName.put("isInWellNet", "是否井网内");
			mapFieldsName.put("timeDrilling", "开钻日期");
			mapFieldsName.put("timeCommission", "完井日期");
			mapFieldsName.put("timeShutDown", "停产日期");
			mapFieldsName.put("designDepth", "设计井深");
			mapFieldsName.put("completeDepth", "完钻井深");
			mapFieldsName.put("controlReserves", "单井控制储量");
			mapFieldsName.put("positionEndProduct", "末期生产层位");
			mapFieldsName.put("cumulativeOil", "累产油");
			mapFieldsName.put("cumulativeGas", "累产气");
			mapFieldsName.put("cumulativeWater", "累注水");
			mapFieldsName.put("geoRisk", "地质风险");
			
			/* 井筒状况  */
			mapFieldsName.put("tubular", "井内管柱");
			mapFieldsName.put("shutWellState", "封井情况");
			mapFieldsName.put("wellCompletion", "完井方式");
			mapFieldsName.put("casingDeformationType", "套变类型");
			mapFieldsName.put("isDownWellFL", "油层套管");
			
			/* 地面状况  */
			mapFieldsName.put("location", "地理位置");
			mapFieldsName.put("environment", "周边环境描述");
			mapFieldsName.put("groundFacility", "井口状况");
			mapFieldsName.put("coordinateX", "井口横坐标");
			mapFieldsName.put("coordinateY", "井口纵坐标");
			mapFieldsName.put("riskRank", "地面风险");
			mapFieldsName.put("nextSchema", "下步方案");
			mapFieldsName.put("remark", "备注");
		}
		return mapFieldsName;
	}
	public static Map<String, Integer> getMapFiledIndex(){
		if(mapFieldsIndex.isEmpty()){
			/* 基础资料  */
			mapFieldsIndex.put("code", 1);
			mapFieldsIndex.put("designType", 2);
			mapFieldsIndex.put("currentType", 3);
			mapFieldsIndex.put("department", 4);
			mapFieldsIndex.put("productState", 5);
			mapFieldsIndex.put("isAbandon", 6);
			mapFieldsIndex.put("isScrap", 7);
			mapFieldsIndex.put("scrapType", 8);
			mapFieldsIndex.put("isCount", 9);
			
			/* 地质概况  */
			mapFieldsIndex.put("structure", 10);
			mapFieldsIndex.put("blockUnit", 11);
			mapFieldsIndex.put("isInWellNet", 12);
			mapFieldsIndex.put("timeDrilling", 13);
			mapFieldsIndex.put("timeCommission", 14);
			mapFieldsIndex.put("timeShutDown", 15);
			mapFieldsIndex.put("designDepth", 16);
			mapFieldsIndex.put("completeDepth", 17);
			mapFieldsIndex.put("controlReserves", 18);
			mapFieldsIndex.put("positionEndProduct", 19);
			mapFieldsIndex.put("cumulativeOil", 20);
			mapFieldsIndex.put("cumulativeGas", 21);
			mapFieldsIndex.put("cumulativeWater", 22);
			mapFieldsIndex.put("geoRisk", 23);
			
			/* 井筒状况  */
			mapFieldsIndex.put("tubular", 24);
			mapFieldsIndex.put("shutWellState", 25);
			mapFieldsIndex.put("wellCompletion", 26);
			mapFieldsIndex.put("casingDeformationType", 27);
			mapFieldsIndex.put("isDownWellFL", 28);
			
			/* 地面状况  */
			mapFieldsIndex.put("location", 29);
			mapFieldsIndex.put("environment", 30);
			mapFieldsIndex.put("groundFacility", 31);
			mapFieldsIndex.put("coordinateX", 32);
			mapFieldsIndex.put("coordinateY", 33);
			mapFieldsIndex.put("riskRank", 34);
			mapFieldsIndex.put("nextSchema", 35);
			mapFieldsIndex.put("remark", 36);
		}
		return mapFieldsIndex;
	}
	public static List<String> getYearsList(){
		ArrayList<String> list = new ArrayList<>();
		int year = 1970;
		while(year<2099){
			list.add((year++)+"");
		}
		return list;
	}
}
