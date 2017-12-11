package com.changqin.well.entry;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 
 * @author LiuTing
 * @version 2017年8月5日 上午1:11:24
 *
 */
@Entity
@Table(name = "sys_category")  
public class Category {
	@Id
	private Integer id;
	private String name;
	private String code;
	private Integer corder;//同一级菜单的排序
	@ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name = "pid")  
	private Category parent;
	@OneToMany(targetEntity = Category.class, cascade = { CascadeType.ALL }, mappedBy = "parent")  
    @Fetch(FetchMode.SUBSELECT)  
    @OrderBy("morder")  
	private List<Category> childMenu = new ArrayList<Category>();
	/**
	 * @param id
	 * @param name
	 * @param code
	 * @param corder
	 * @param parent
	 * @param childMenu
	 */
	public Category(Integer id, String name, String code, Integer corder, Category parent) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.corder = corder;
		this.parent = parent;
	}
	/**
	 * @param id
	 * @param name
	 * @param code
	 * @param corder
	 * @param parent
	 * @param childMenu
	 */
	public Category(Integer id, String name, String code, Integer corder, Category parent, List<Category> childMenu) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.corder = corder;
		this.parent = parent;
		this.childMenu = childMenu;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the corder
	 */
	public Integer getCorder() {
		return corder;
	}
	/**
	 * @param corder the corder to set
	 */
	public void setCorder(Integer corder) {
		this.corder = corder;
	}
	/**
	 * @return the parent
	 */
	public Category getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Category parent) {
		this.parent = parent;
	}
	/**
	 * @return the childMenu
	 */
	public List<Category> getChildMenu() {
		return childMenu;
	}
	/**
	 * @param childMenu the childMenu to set
	 */
	public void setChildMenu(List<Category> childMenu) {
		this.childMenu = childMenu;
	} 
	
}
