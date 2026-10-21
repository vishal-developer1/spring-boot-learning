package com.vp.services;

import com.vp.entity.User;


public interface UserServies 
{
	
	public boolean registerUser(User user);
	 User loginUser(String email, String password);

}
