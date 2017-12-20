package com.changqin.well.dao;

import java.util.List;

import com.changqin.well.entry.WellInfo;

public interface WellInfoDAO extends BaseDAO<WellInfo>{
	List<WellInfo> selectLike(WellInfo wellInfo);
}
