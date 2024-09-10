package com.dc.api.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class CitizenAppEntity {

	private Integer caseNum;

	private String CitizenName;

	private String citizenEmail;

	private Long citizenPhno;

	private String citizenGender;

	private LocalDate citizenDob;

	private Long citizenSsn;

	@CreationTimestamp
	private LocalDate createdDate;

	@UpdateTimestamp
	private LocalDate updateDate;

	private String createdBy;

}
