package com.dc.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="IES_USERS")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	private String fullname;
	
	private String email;
	
	private String pwd;
	
	private Long mobileNo;

}
