package com.projetoteste.service;

import com.projetoteste.modelo.User;


public interface UserService {

	User findById(int id);
	
	User findBySso(String sso);
	
}