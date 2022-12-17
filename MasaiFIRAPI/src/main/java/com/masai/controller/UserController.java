package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.model.FIR;
import com.masai.model.User;
import com.masai.service.UserService;

@RestController
@RequestMapping("/masaifir/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUserHandler (@Valid @RequestBody User user) throws UserException{
		
			User u = userService.registerUser(user);
		
			return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUserHandler (@RequestBody String mobile,String password) throws UserException{
		
			String msg = userService.loginUser(mobile,password);
		
			return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/fir/{id}")
	public ResponseEntity<List<FIR>> getAllFIRrHandler(@PathVariable Integer id) throws UserException, FIRException{
		
		List<FIR> firList = userService.getAllFIR(id);
		
		return new ResponseEntity<List<FIR>>(firList,HttpStatus.OK);
	}
	
	@DeleteMapping("/fir/{id}/{firId}")
	public ResponseEntity<String> deleteFIRHandler(@PathVariable Integer id,@PathVariable Integer firId) throws UserException, FIRException{
		
		String msg = userService.deleteFIRById(id, firId);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	

}
