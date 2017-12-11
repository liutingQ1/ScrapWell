package com.changqin.well.service;

import com.changqin.well.common.persistence.Page;
import com.changqin.well.entry.User;

public interface UserService {
	public User getByUserId(Integer userId);
	public User login(String username, String password);
	public User updatePassword(Integer userId, String newPsw);
	public Page<User> findPage(Page<User> page);
	public boolean hasUser(String username);
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
}
