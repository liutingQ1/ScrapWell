package com.changqin.well.common.config;
/**
 * 用户部门
 */
public enum Department {
	/**
	 *普通用户 
	 */
	GENERAL("普通用户"),
	/**
	 *管理员用户 
	 */
	ADMIN("管理员用户"),
	/**
	 * 作业一区
	 */
	TASK1("作业一区"),
	/**
	 * 作业二区
	 */
	TASK2("作业二区"),
	/**
	 * 作业三区
	 */
	TASK3("作业三区"),
	/**
	 * 专采队
	 */
	MINING("专采队"),
	/**
	 * 地质研究所
	 */
	GEOGRAPHY("地质研究所"),
	/**
	 * 工艺研究所及修井管理站
	 */
	ENGINEERING("工艺研究所及修井管理站");
	private String name;
	private Department(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public static Department getDepartment(String department){
		if(department.equals(TASK1.name)){
			return TASK1;
		}else if(department.equals(TASK2.name)){
			return TASK2;
		}else if(department.equals(TASK3.name)){
			return TASK3;
		}else if(department.equals(MINING.name)){
			return MINING;
		}else if(department.equals(GEOGRAPHY.name)){
			return GEOGRAPHY;
		}else if(department.equals(ENGINEERING.name)){
			return ENGINEERING;
		}else if(department.equals(ADMIN.name)){
			return ADMIN;
		}else if(department.equals(GENERAL.name)){
			return GENERAL;
		}else
			return null;
	}
	@Override
	public String toString(){
		return this.name;
	}
}
