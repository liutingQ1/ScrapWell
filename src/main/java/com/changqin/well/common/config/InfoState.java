package com.changqin.well.common.config;

public enum InfoState {
	/**
	 * 提交
	 */
	COMMIT("提交"),
	/**
	 * 退回
	 */
	BACK("退回"),
	/**
	 * 通过
	 */
	PASS("通过");
	private String name;
	private InfoState(String name){
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
