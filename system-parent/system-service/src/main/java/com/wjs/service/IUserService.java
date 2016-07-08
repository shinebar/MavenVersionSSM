package com.wjs.service;

import com.wjs.model.User;

public interface IUserService {

	boolean register(User user);

	User login(String username, String password);

}
