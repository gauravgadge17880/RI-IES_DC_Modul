package com.dc.api.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.dc.api.binding.Education;
import com.dc.api.binding.Income;
import com.dc.api.binding.Kids;
import com.dc.api.binding.PlanSelection;
import com.dc.api.binding.Summary;

@Service
public interface DcService {
	
	public Map<Integer, String> getPlanNames();
	
	public boolean updatePlanSelection(PlanSelection planSel);
	
	public boolean saveIncome(Income income);
	
	public boolean saveEducation(Education edu);
	
	public boolean saveKids(Kids kids);
	
	public Summary getSummaryInfo(Integer CaseNum);
}
