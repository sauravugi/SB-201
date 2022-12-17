package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.model.FIR;
import com.masai.model.User;
import com.masai.repository.FIRRepo;
import com.masai.repository.UserDao;

@Service
public class FIRServiceImpl implements FIRService {
	
	@Autowired
	private UserDao uDao;
	
	@Autowired
	private FIRRepo fDao;

	@Override
	public FIR reportFIRByUser(Integer id, FIR fir) throws UserException{
		
		Optional<User> opt = uDao.findById(id);
		
		if(opt.isEmpty()) throw  new UserException("Wrong User ID ...!");
		
		opt.get().getFirList().add(fir);
		
		fir.setUser(opt.get());
		
		return fDao.save(fir);
	}

}
