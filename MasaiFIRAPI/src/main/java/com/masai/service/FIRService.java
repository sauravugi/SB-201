package com.masai.service;

import com.masai.exception.UserException;
import com.masai.model.FIR;

public interface FIRService {
	
	FIR reportFIRByUser(Integer id,FIR fir) throws UserException;

}
