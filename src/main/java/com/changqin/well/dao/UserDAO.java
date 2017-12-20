package com.changqin.well.dao;

import com.changqin.well.entry.User;

public interface UserDAO extends BaseDAO<User>{
	User selectOne(String username);
	User selectOne(String username, String password);
	User selectOne(Integer userId);
}
