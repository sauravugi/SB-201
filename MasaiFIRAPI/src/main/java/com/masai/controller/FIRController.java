package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.UserException;
import com.masai.model.FIR;
import com.masai.service.FIRService;


@RestController
@RequestMapping("/masaifir/user")
public class FIRController {

		@Autowired
		private FIRService firService;
		
		@PostMapping("/fir/{id}")
		public ResponseEntity<FIR> reportFIRHandler(@Valid @PathVariable Integer id , @RequestBody FIR fir) throws UserException{
			
				FIR Fir = firService.reportFIRByUser(id, fir);
			
				return new ResponseEntity<FIR>(Fir, HttpStatus.CREATED);
		}
		
		
}
