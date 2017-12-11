package com.changqin.well.dao;

import com.changqin.well.entry.User;

/**
 * @author LiuTing
 * @version 2017年8月9日 下午8:12:42
 * 
 */
public interface UserDAO extends BaseDAO<User>{
	User selectOne(String username);
	User selectOne(String username, String password);
	User selectOne(Integer userId);
}
