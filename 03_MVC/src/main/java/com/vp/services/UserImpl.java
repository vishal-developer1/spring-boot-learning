package com.vp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.entity.User;
import com.vp.repository.UserRep;

@Service
public class UserImpl implements UserServies{

	@Autowired
	private UserRep userRep;
	
	
	@Override
    public boolean registerUser(User user) {
        try {
            userRep.save(user);
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


	@Override
	public User loginUser(String email, String password) {
		
		User validUser = userRep.findByEmail(email);
		
		if (validUser !=null & validUser.getPassword().equals(password)) {
			return validUser;
		}
		
		
		return null;
	}
}
