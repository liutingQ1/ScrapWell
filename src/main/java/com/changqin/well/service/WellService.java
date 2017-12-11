package com.changqin.well.service;

import com.changqin.well.common.persistence.Page;
import com.changqin.well.entry.WellInfo;

/**
 * @author LiuTing
 * @version 2017年8月5日 下午2:48:10
 * 
 */
public interface WellService {
	/**
	 * 查找指定部门正在审核的信息
	 * @param page
	 * @param operator
	 * @return
	 */
	Page<WellInfo> findPage(Page<WellInfo> page, WellInfo WellInfo);
	void save(WellInfo wellInfo);
	void update(WellInfo wellInfo);
	void delete(WellInfo wellInfo);
	WellInfo findById(int id);
}
