package com.wjs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjs.dao.IUserDao;
import com.wjs.model.User;
import com.wjs.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	@Override
	public boolean register(User user) {
		return userDao.register(user);
	}

	@Override
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

}
