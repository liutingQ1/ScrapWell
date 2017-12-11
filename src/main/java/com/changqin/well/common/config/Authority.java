package com.changqin.well.common.config;

public enum Authority {
	/**
	 * 无权限
	 */
	NULL("无权限"),
	/**
	 * 录入 
	 */
	RECORD("录入"),
	/**
	 * 修改
	 */
	MODIFY("修改"),
	/**
	 * 删除
	 */
	DELETE("删除"),
	/**
	 * 查询
	 */
	VIEW("查询"),
	/**
	 * 审核
	 */
	CHECK("审核");
	private String name;
	private Authority(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString(){
		return this.name;
	}
}
