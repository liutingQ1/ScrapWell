/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.changqin.well.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changqin.well.common.persistence.Page;
import com.changqin.well.dao.WellInfoDAO;
import com.changqin.well.entry.ImageYear;
import com.changqin.well.entry.WellInfo;
import com.changqin.well.service.WellService;

/**
 * 
 * @author LiuTing
 * @version 2017年8月5日 下午3:04:01
 *
 */
@Service
@Transactional
public class WellServiceImpl implements WellService {
	@Autowired
	private WellInfoDAO wellInfoDAO;
	
	@Override
	public Page<WellInfo> findPage(Page<WellInfo> page, WellInfo WellInfo) {
		List<WellInfo> selectAll = wellInfoDAO.selectLike(WellInfo);
		page.setCount(selectAll.size());
		page.setList(selectAll);
		return page;
	}

	@Override
	public void save(WellInfo wellInfo) {
		wellInfoDAO.save(wellInfo);
	}

	@Override
	public void update(WellInfo wellInfo) {
		wellInfoDAO.update(wellInfo);
	}

	@Override
	public void delete(WellInfo wellInfo) {
		wellInfoDAO.delete(wellInfo);
	}

	@Override
	public WellInfo findById(int id) {
		WellInfo wellInfo = wellInfoDAO.selectOneById(id);
		this.setCurrentYearImage(wellInfo);
		return wellInfo;
	}
	
	private void setCurrentYearImage(WellInfo wellInfo){
		Set<ImageYear> images = wellInfo.getImages();
		@SuppressWarnings("deprecation")
		int curentYear = new Date().getYear()+1900;
		for(ImageYear iy : images){
			if(iy.getYear()==curentYear){
				wellInfo.setImageCurrentYear(iy);
				break;
			}
		}
	}
}
