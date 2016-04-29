package com.projetoteste.service;

import com.projetoteste.modelo.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

        User user;
    
	public User findById(int id) {
		return user;
	}

	public User findBySso(String sso) {
		return user;
	}

}
