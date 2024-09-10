package com.dc.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dc.api.entity.DcEducationEntity;
import com.dc.api.entity.DcIncomeEntity;

public interface DcEducationRepo extends JpaRepository<DcEducationEntity, Integer> {
	public DcEducationEntity findByCaseNum(Integer caseNum);

}
