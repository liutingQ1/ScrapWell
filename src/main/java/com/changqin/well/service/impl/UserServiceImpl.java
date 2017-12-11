/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.changqin.well.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changqin.well.common.persistence.Page;
import com.changqin.well.dao.UserDAO;
import com.changqin.well.entry.User;
import com.changqin.well.service.UserService;

/**
 * 
 * @author LiuTing
 * @version 2017年8月5日 下午3:04:01
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	/* (non-Javadoc)
	 * @see com.changqin.well.service.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String username, String password) {
		User user = userDAO.selectOne(username, password);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.changqin.well.service.UserService#updatePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public User updatePassword(Integer userId, String newPsw) {
		User user = userDAO.selectOne(userId);
		user.setPassword(newPsw);
		userDAO.update(user);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.changqin.well.service.UserService#getByName(java.lang.String)
	 */
	@Override
	public User getByUserId(Integer userId) {
		User user = userDAO.selectOne(userId);
		return user;
	}

	@Override
	public Page<User> findPage(Page<User> page) {
		List<User> selectAll = userDAO.selectAll();
		page.setCount(selectAll.size());
		page.setList(selectAll);
		return page;
	}

	@Override
	public boolean hasUser(String username) {
		User selectOne = userDAO.selectOne(username);
		if(selectOne!=null)
			return true;
		else
			return false;
	}

	@Override
	public void saveUser(User user) {
		userDAO.save(user);
	}

	@Override
	public void updateUser(User user) {
		userDAO.update(user);
	}

	@Override
	public void deleteUser(User user) {
		userDAO.delete(user);
	}
}
