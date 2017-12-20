package com.changqin.well.entry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 每口井的图片，每年三张
 */
@Entity
@Table(name="sys_image")
public class ImageYear {
	@Id
	@GeneratedValue(generator = "id")   
	@GenericGenerator(name = "id", strategy = "increment")
	private Integer id;
	private int year;
	private String image1;
	private String image2;
	private String image3;
	
	/**
	 * 
	 */
	public ImageYear() {
		super();
	}
	/**
	 * @param id
	 * @param year
	 * @param image1
	 * @param image2
	 * @param image3
	 */
	public ImageYear(Integer id, int year, String image1, String image2, String image3) {
		super();
		this.id = id;
		this.year = year;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
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
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the image1
	 */
	public String getImage1() {
		return image1;
	}
	/**
	 * @param image1 the image1 to set
	 */
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	/**
	 * @return the image2
	 */
	public String getImage2() {
		return image2;
	}
	/**
	 * @param image2 the image2 to set
	 */
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	/**
	 * @return the image3
	 */
	public String getImage3() {
		return image3;
	}
	/**
	 * @param image3 the image3 to set
	 */
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	
}