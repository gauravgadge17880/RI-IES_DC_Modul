package com.dc.api.binding;

import java.time.LocalDate;

import com.dc.api.entity.PlanEntity;
import com.dc.api.entity.UserEntity;
import lombok.Data;

@Data
public class PlanSelection {
	
	private Integer userId;
	
	private String planName;
	
	private Integer caseNum;
	
	private PlanEntity planId;

}
