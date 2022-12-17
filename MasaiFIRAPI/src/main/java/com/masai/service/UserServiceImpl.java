package com.masai.service;




import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.model.FIR;
import com.masai.model.User;
import com.masai.repository.FIRRepo;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao uDao;
	
	@Autowired
	private FIRRepo fDao;
	

	@Override
	public User registerUser(User user) throws UserException {

		if(user==null) throw new UserException("Provide Proper Details of User");
		
		return uDao.save(user);
	}

	@Override
	public String loginUser(String mobile,String password) throws UserException {
		
		Optional<User> opt = uDao.findByMobile(mobile);
		
		if(opt.isEmpty()) throw  new UserException("Wrong Mobile Number...!");
		
		if(opt.get().getPassword().equals(password)==false) throw  new UserException("Wrong Password...!");
		
		return "Login Sucessfully by User "+opt.get().getUserId();
	}

	@Override
	public List<FIR> getAllFIR(Integer id) throws UserException, FIRException {
		
		Optional<User> opt = uDao.findById(id);
		
		if(opt.isEmpty()) throw  new UserException("Wrong User ID ...!");
		
		if(opt.get().getFirList().size()==0) throw new FIRException("Not Any Fir is registered with this id ....! ");
		
		return opt.get().getFirList();
	}

	@Override
	public String deleteFIRById(Integer id, Integer firId) throws UserException, FIRException {
		
		Optional<User> opt = uDao.findById(id);
		
		if(opt.isEmpty()) throw  new UserException("Wrong User ID ...!");
		
		if(opt.get().getFirList().size()==0) throw new FIRException("Not Any Fir is registered with this id ....! ");
		
		boolean flag = false;
		
		for(FIR f:opt.get().getFirList()) {
			
			if(f.getFirId()==firId) {
				
				flag = true;
				
				LocalDateTime now = LocalDateTime.now();
				
				LocalDateTime firTime = f.getTimeStamp();
				
				Duration duration = Duration.between(now, firTime);
				
				long diff = Math.abs(duration.toHours());
				
				if(diff<=24) {
					
					fDao.deleteById(firId);
					
					opt.get().getFirList().remove(f);

				}else {
					
					throw new FIRException("FIR Time is More than 24 hours...!");
				}
			}
		}
		
		if(flag==false) throw new FIRException("Not Any FIR with this FIR ID "+firId);
		
		return "Deleted FIR Sucessfully with FIR ID "+firId;
	}




	
	
}























