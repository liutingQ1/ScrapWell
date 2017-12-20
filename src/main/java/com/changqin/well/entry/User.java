package com.changqin.well.entry;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.changqin.well.common.config.Authority;
import com.changqin.well.common.config.Department;

@Entity
@Table(name="sys_user")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String username;//用户名
	private String password;//用户密码
	@Enumerated(EnumType.STRING)
	private Department department;//所属部门 
	@Enumerated(EnumType.STRING)
	private Authority viewAuthority;//查询权限
	@Enumerated(EnumType.STRING)
	private Authority recordAuthority;//录入权限
	@Enumerated(EnumType.STRING)
	private Authority modifyAuthority;//修改权限
	@Enumerated(EnumType.STRING)
	private Authority deleteAuthority;//删除权限
	@Enumerated(EnumType.STRING)
	private Authority checkAuthority;//审核权限
	
	public User() {
	}
	
	public User(Integer id, String username, String password, Department department, Authority view, Authority record,
			Authority modify, Authority delete, Authority check) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.department = department;
		this.viewAuthority = view;
		this.recordAuthority = record;
		this.modifyAuthority = modify;
		this.deleteAuthority = delete;
		this.checkAuthority = check;
	}
	/**
	 * 是否有查询权限
	 */
	public int hasViewAuthority(){
		if(this.viewAuthority==Authority.VIEW)
			return 1;
		else
			return 0;
	}
	/**
	 * 是否有录入权限
	 */
	public int hasRecordAuthority(){
		if(this.recordAuthority==Authority.RECORD)
			return 1;
		else
			return 0;
	}
	/**
	 * 是否有修改权限
	 */
	public int hasModifyAuthority(){
		if(this.modifyAuthority==Authority.MODIFY)
			return 1;
		else
			return 0;
	}
	/**
	 * 是否有删除权限
	 */
	public int hasDeleteAuthority(){
		if(this.deleteAuthority==Authority.DELETE)
			return 1;
		else
			return 0;
	}
	/**
	 * 是否有审核权限
	 */
	public int hasCheckAuthority(){
		if(this.checkAuthority==Authority.CHECK)
			return 1;
		else
			return 0;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	public Authority getViewAuthority() {
		return viewAuthority;
	}

	public void setViewAuthority(Authority viewAuthority) {
		this.viewAuthority = viewAuthority;
	}

	public Authority getRecordAuthority() {
		return recordAuthority;
	}

	public void setRecordAuthority(Authority recordAuthority) {
		this.recordAuthority = recordAuthority;
	}

	public Authority getModifyAuthority() {
		return modifyAuthority;
	}

	public void setModifyAuthority(Authority modifyAuthority) {
		this.modifyAuthority = modifyAuthority;
	}

	public Authority getDeleteAuthority() {
		return deleteAuthority;
	}

	public void setDeleteAuthority(Authority deleteAuthority) {
		this.deleteAuthority = deleteAuthority;
	}

	public Authority getCheckAuthority() {
		return checkAuthority;
	}

	public void setCheckAuthority(Authority checkAuthority) {
		this.checkAuthority = checkAuthority;
	}
	
}
