package com.masai.service;

import java.util.List;

import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.model.FIR;
import com.masai.model.User;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	
	public String loginUser(String mobile,String password) throws UserException;
	
	public List<FIR> getAllFIR(Integer id) throws UserException,FIRException;
	
	public String deleteFIRById(Integer id,Integer firId)  throws UserException,FIRException;

	
    

}
