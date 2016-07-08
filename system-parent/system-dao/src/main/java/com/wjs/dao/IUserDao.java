package com.wjs.dao;

import java.util.List;

import com.wjs.model.User;

public interface IUserDao {
	public boolean register(User user);
	public User login(String username, String password);
	public List<User> queryAllUser();
}
