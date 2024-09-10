package com.dc.api.entity;

import com.dc.api.binding.Education;
import com.dc.api.binding.Income;
import com.dc.api.binding.Kid;
import com.dc.api.binding.Kids;
import com.dc.api.binding.PlanSelection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "IES_SUMMARY")
public class DcSummary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sumId;

	
	private Integer userId;

	private Integer caseNum;

	private String planName;

	private Education education;

	private Income income;

	private Kid kid;

	private Kids kids;

	private PlanSelection planSelection;

}
