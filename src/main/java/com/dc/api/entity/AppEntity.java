package com.dc.api.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="IES_APPS")
public class AppEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="case_num")
	private Integer caseNum;
	
	private String fullname;
	
	private String email;
	
	private String gender;
	
	private LocalDate dob;
	
	private Long Ssn;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="plan_id")
	private PlanEntity planId;
	
	
	

	
	
	

}
