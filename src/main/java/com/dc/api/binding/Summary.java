package com.dc.api.binding;

import lombok.Data;

@Data
public class Summary {
	
	private Integer userId;
	
	private Integer caseNum;
	
	private String planName;
	
	private Education education;
	
	private Income income;
	
	private Kid kid;
	
	private Kids kids;
	
	private PlanSelection planSelection;
	

}
