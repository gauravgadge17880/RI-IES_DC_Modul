package com.dc.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dc.api.entity.DcEducationEntity;
import com.dc.api.entity.PlanEntity;

public interface PlanEntityRepo extends JpaRepository<PlanEntity, Integer>{
	public PlanEntity findByCaseNum(Integer caseNum);

}
