package com.fstg.service.facade;

import com.fstg.bean.User;

public interface UserService {
	User findByLogin(String login);

	int seConnecter(User user);

	int register(User user);
}
