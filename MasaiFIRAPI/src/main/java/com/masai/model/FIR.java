package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FIR {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer firId;
	
	@NotNull
	private String crimeDetails;
	
	private LocalDateTime timeStamp = LocalDateTime.now();
	
	@NotNull
	private String policeStation;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	User user;

}
