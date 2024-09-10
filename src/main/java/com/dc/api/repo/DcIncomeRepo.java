package com.dc.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dc.api.entity.DcEducationEntity;
import com.dc.api.entity.DcIncomeEntity;

public interface DcIncomeRepo extends JpaRepository<DcIncomeEntity, Integer> {
	public DcIncomeEntity findByCaseNum(Integer caseNum);

}
