package com.masai.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@Pattern(regexp = "^[a-zA-Z]{3,20}", message = "length must be >=3")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z]{3,20}", message = "length must be >=3")
	private String lastName;
	
	@Pattern(regexp = "^[a-zA-Z0-9@]{3,20}", message = "length must be >=6 and less 13")
	private String password;
	
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message ="Mobile number must be 10 digits")
	private String mobile;
	 
	@NotNull
	@Min(value = 8, message = "Age should not be less than 8")
	private Integer age;
	
	@NotNull
	private String gender;
	
	@NotNull
	private String address;

	private String role = "USER";
	
	@OneToMany(cascade =CascadeType.ALL,mappedBy = "user")
	List<FIR> firList;
	

	
}
