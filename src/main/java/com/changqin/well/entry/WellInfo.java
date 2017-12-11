package com.changqin.well.entry;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.changqin.well.common.config.InfoState;
import com.changqin.well.common.config.Department;

/**
 * 
 * @author LiuTing
 * @version 2017年8月5日 下午2:05:05
 *	注意：部分字段没有见名知义，在原有字段名的基础上已经录入了数据，如果修改字段名会造成数据缺失
 */
@Entity
@Table(name="sys_wellInfo")
public class WellInfo {
	@Id
	@GeneratedValue(generator = "id")   
	@GenericGenerator(name = "id", strategy = "increment")
	@Column(name="WellInfo_Id")
	private Integer id;
	/* 基础资料  */
	private String code;//井号
	private String designType;//设计井别
	private String currentType;//目前井别
	@Enumerated(EnumType.STRING)
	private Department department;//单位代码(作业区或专采队)
	private String productState;//生产状态
	private String isScrap;//是否报废
	private String scrapType;//报废类型
	private String isAbandon;//是否在册
	private String isCount;//是否计井数
	
	/* 地质概况  */
	private String structure;//构造位置
	private String blockUnit;//区块单元代码
	private String isInWellNet;//是否井网内
	private String timeDrilling;//开钻日期
	private String timeCommission;//完井日期
	private String timeShutDown;//停产日期
	private String designDepth;//设计井深
	private String completeDepth;//完钻井深
	private String controlReserves;//单井控制储量
	private String positionEndProduct;//末期生产层位
	private String cumulativeOil;//累产油
	private String cumulativeGas;//累产气
	private String cumulativeWater;//累注水
	private String geoRisk;//地质风险
	
	/* 井筒状况  */
	private String tubular;//井内管柱
	private String shutWellState;//封井情况
	private String wellCompletion;//完井方式
	private String casingDeformationType;//套变类型
	private String isDownWellFL;//油层套管
	
	/* 地面状况  */
	private String location;//地理位置
	private String environment;//周边环境描述
	private String groundFacility;//井口状况
	private String coordinateX;//井口横坐标
	private String coordinateY;//井口纵坐标
	private String riskRank;//地面风险
	private String nextSchema;//下步方案
	private String remark;//备注
	
	@Enumerated(EnumType.STRING)
	private InfoState state;//信息状态：提交，退回，审核通过
	@Enumerated(EnumType.STRING)
	private Department operator;//信息当前流转部门
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="WellInfo_Id")
	@OrderBy("year DESC")
	private Set<ImageYear> images;
	
	@Transient
	private ImageYear imageCurrentYear;
	/**
	 * 
	 */
	public WellInfo() {
		super();
	}

	public String getGeoRisk() {
		return geoRisk;
	}

	public void setGeoRisk(String geoRisk) {
		this.geoRisk = geoRisk;
	}

	public String getIsDownWellFL() {
		return isDownWellFL;
	}

	public void setIsDownWellFL(String isDownWellFL) {
		this.isDownWellFL = isDownWellFL;
	}

	public String getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(String coordinateX) {
		this.coordinateX = coordinateX;
	}

	public String getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(String coordinateY) {
		this.coordinateY = coordinateY;
	}

	public String getDesignDepth() {
		return designDepth;
	}

	public void setDesignDepth(String designDepth) {
		this.designDepth = designDepth;
	}

	public String getCompleteDepth() {
		return completeDepth;
	}

	public void setCompleteDepth(String completeDepth) {
		this.completeDepth = completeDepth;
	}

	public String getDesignType() {
		return designType;
	}

	public void setDesignType(String designType) {
		this.designType = designType;
	}

	public String getScrapType() {
		return scrapType;
	}

	public void setScrapType(String scrapType) {
		this.scrapType = scrapType;
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
	 * @return the currentType
	 */
	public String getCurrentType() {
		return currentType;
	}

	/**
	 * @param currentType the currentType to set
	 */
	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the productState
	 */
	public String getProductState() {
		return productState;
	}

	/**
	 * @param productState the productState to set
	 */
	public void setProductState(String productState) {
		this.productState = productState;
	}

	/**
	 * @return the wellCompletion
	 */
	public String getWellCompletion() {
		return wellCompletion;
	}

	/**
	 * @param wellCompletion the wellCompletion to set
	 */
	public void setWellCompletion(String wellCompletion) {
		this.wellCompletion = wellCompletion;
	}

	/**
	 * @return the isAbandon
	 */
	public String getIsAbandon() {
		return isAbandon;
	}

	/**
	 * @param isAbandon the isAbandon to set
	 */
	public void setIsAbandon(String isAbandon) {
		this.isAbandon = isAbandon;
	}

	/**
	 * @return the isScrap
	 */
	public String getIsScrap() {
		return isScrap;
	}

	/**
	 * @param isScrap the isScrap to set
	 */
	public void setIsScrap(String isScrap) {
		this.isScrap = isScrap;
	}

	/**
	 * @return the isCount
	 */
	public String getIsCount() {
		return isCount;
	}

	/**
	 * @param isCount the isCount to set
	 */
	public void setIsCount(String isCount) {
		this.isCount = isCount;
	}

	/**
	 * @return the structure
	 */
	public String getStructure() {
		return structure;
	}

	/**
	 * @param structure the structure to set
	 */
	public void setStructure(String structure) {
		this.structure = structure;
	}

	/**
	 * @return the blockUnit
	 */
	public String getBlockUnit() {
		return blockUnit;
	}

	/**
	 * @param blockUnit the blockUnit to set
	 */
	public void setBlockUnit(String blockUnit) {
		this.blockUnit = blockUnit;
	}

	/**
	 * @return the isInWellNet
	 */
	public String getIsInWellNet() {
		return isInWellNet;
	}

	/**
	 * @param isInWellNet the isInWellNet to set
	 */
	public void setIsInWellNet(String isInWellNet) {
		this.isInWellNet = isInWellNet;
	}

	/**
	 * @return the controlReserves
	 */
	public String getControlReserves() {
		return controlReserves;
	}

	/**
	 * @param controlReserves the controlReserves to set
	 */
	public void setControlReserves(String controlReserves) {
		this.controlReserves = controlReserves;
	}

	/**
	 * @return the timeDrilling
	 */
	public String getTimeDrilling() {
		return timeDrilling;
	}

	/**
	 * @param timeDrilling the timeDrilling to set
	 */
	public void setTimeDrilling(String timeDrilling) {
		this.timeDrilling = timeDrilling;
	}

	/**
	 * @return the timeCommission
	 */
	public String getTimeCommission() {
		return timeCommission;
	}

	/**
	 * @param timeCommission the timeCommission to set
	 */
	public void setTimeCommission(String timeCommission) {
		this.timeCommission = timeCommission;
	}

	/**
	 * @return the timeShutDown
	 */
	public String getTimeShutDown() {
		return timeShutDown;
	}

	/**
	 * @param timeShutDown the timeShutDown to set
	 */
	public void setTimeShutDown(String timeShutDown) {
		this.timeShutDown = timeShutDown;
	}

	/**
	 * @return the positionEndProduct
	 */
	public String getPositionEndProduct() {
		return positionEndProduct;
	}

	/**
	 * @param positionEndProduct the positionEndProduct to set
	 */
	public void setPositionEndProduct(String positionEndProduct) {
		this.positionEndProduct = positionEndProduct;
	}

	/**
	 * @return the cumulativeOil
	 */
	public String getCumulativeOil() {
		return cumulativeOil;
	}

	/**
	 * @param cumulativeOil the cumulativeOil to set
	 */
	public void setCumulativeOil(String cumulativeOil) {
		this.cumulativeOil = cumulativeOil;
	}

	/**
	 * @return the cumulativeGas
	 */
	public String getCumulativeGas() {
		return cumulativeGas;
	}

	/**
	 * @param cumulativeGas the cumulativeGas to set
	 */
	public void setCumulativeGas(String cumulativeGas) {
		this.cumulativeGas = cumulativeGas;
	}

	/**
	 * @return the cumulativeWater
	 */
	public String getCumulativeWater() {
		return cumulativeWater;
	}

	/**
	 * @param cumulativeWater the cumulativeWater to set
	 */
	public void setCumulativeWater(String cumulativeWater) {
		this.cumulativeWater = cumulativeWater;
	}

	/**
	 * @return the tubular
	 */
	public String getTubular() {
		return tubular;
	}

	/**
	 * @param tubular the tubular to set
	 */
	public void setTubular(String tubular) {
		this.tubular = tubular;
	}

	/**
	 * @return the isShut
	 */
	public String getShutWellState() {
		return shutWellState;
	}

	/**
	 * @param isShut the isShut to set
	 */
	public void setShutWellState(String shutWellState) {
		this.shutWellState = shutWellState;
	}

	/**
	 * @return the isCasingDeformation
	 */
	public String getCasingDeformationType() {
		return casingDeformationType;
	}

	/**
	 * @param isCasingDeformation the isCasingDeformation to set
	 */
	public void setCasingDeformationType(String casingDeformationType) {
		this.casingDeformationType = casingDeformationType;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	/**
	 * @return the groundFacility
	 */
	public String getGroundFacility() {
		return groundFacility;
	}

	/**
	 * @param groundFacility the groundFacility to set
	 */
	public void setGroundFacility(String groundFacility) {
		this.groundFacility = groundFacility;
	}

	/**
	 * @return the riskRank
	 */
	public String getRiskRank() {
		return riskRank;
	}

	/**
	 * @param riskRank the riskRank to set
	 */
	public void setRiskRank(String riskRank) {
		this.riskRank = riskRank;
	}

	/**
	 * @return the nextSchema
	 */
	public String getNextSchema() {
		return nextSchema;
	}

	/**
	 * @param nextSchema the nextSchema to set
	 */
	public void setNextSchema(String nextSchema) {
		this.nextSchema = nextSchema;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public InfoState getState() {
		return state;
	}
	public void setState(InfoState state) {
		this.state = state;
	}
	/**
	 * 信息当前流转部门
	 */
	public Department getOperator() {
		return operator;
	}
	/**
	 * 信息当前流转部门
	 */
	public void setOperator(Department operator) {
		this.operator = operator;
	}
	/**
	 * @return the images
	 */
	public Set<ImageYear> getImages() {
		return images;
	}
	/**
	 * @param images the images to set
	 */
	public void setImages(Set<ImageYear> images) {
		this.images = images;
	}
	public ImageYear getImageCurrentYear() {
		return imageCurrentYear;
	}
	public void setImageCurrentYear(ImageYear imageCurrentYear) {
		this.imageCurrentYear = imageCurrentYear;
	}
	
}


