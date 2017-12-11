package com.changqin.well.common.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuTing
 * @version 2017年8月27日 下午2:59:57
 * 
 */
public class SelectOption {
	public static List<String> getDesignType(){
		ArrayList<String> list = new ArrayList<>();
		list.add("开发井");
		list.add("探井");
		list.add("预探井");
		list.add("详探井");
		list.add("评价井");
		list.add("其他");
		return list;
	}
	public static List<String> getCurrentType(){
		ArrayList<String> list = new ArrayList<>();
		list.add("油井");
		list.add("水井");
		list.add("气井");
		list.add("其他");
		return list;
	}
	public static List<String> getDepartmentList(){
		ArrayList<String> list = new ArrayList<>();
		list.add("作业一区");
		list.add("作业二区");
		list.add("作业三区");
		list.add("专采队");
		return list;
	}
	public static List<String> getScrapTypeList(){
		ArrayList<String> list = new ArrayList<>();
		list.add("钻井地质报废");
		list.add("钻井工程报废");
		list.add("正常报废");
		list.add("其他");
		return list;
	}
	public static List<String> getWellCompletion(){
		ArrayList<String> list = new ArrayList<>();
		list.add("射孔完井");
		list.add("裸眼完井");
		list.add("衬管完井");
		list.add("砾石充填完井");
		list.add("复合完井");
		list.add("其他");
		return list;
	}
	public static List<String> getShutWellState(){
		ArrayList<String> list = new ArrayList<>();
		list.add("未封井");
		list.add("永久封井");
		list.add("简易封井");
		list.add("机械封井");
		list.add("注灰封井");
		list.add("其他");
		return list;
	}
	public static List<String> getCasingDeformationType(){
		ArrayList<String> list = new ArrayList<>();
		list.add("无套变");
		list.add("套管弯曲");
		list.add("套管缩径");
		list.add("套漏");
		list.add("套管错断");
		list.add("其他");
		return list;
	}
	public static List<String> getRiskRankList(){
		ArrayList<String> list = new ArrayList<>();
		list.add("一级");
		list.add("二级");
		list.add("三级");
		return list;
	}
	public static List<String> getGeoRiskList(){
		ArrayList<String> list = new ArrayList<>();
		list.add("一级");
		list.add("二级");
		list.add("三级");
		return list;
	}
	public static List<String> getNextSchemaList(){
		ArrayList<String> list = new ArrayList<>();
		list.add("恢复");
		list.add("保持");
		list.add("暂闭");
		list.add("永久封井");
		return list;
	}
}
