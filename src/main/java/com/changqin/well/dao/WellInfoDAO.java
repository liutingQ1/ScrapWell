package com.changqin.well.dao;

import java.util.List;

import com.changqin.well.common.config.Department;
import com.changqin.well.common.config.InfoState;
import com.changqin.well.entry.WellInfo;

/**
 * @author LiuTing
 * @version 2017年8月9日 下午8:12:42
 * 
 */
public interface WellInfoDAO extends BaseDAO<WellInfo>{
	List<WellInfo> selectLike(WellInfo wellInfo);
}
