package com.dc.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dc.api.entity.AppEntity;
import com.dc.api.entity.DcIncomeEntity;

public interface AppEntityRepo extends JpaRepository<AppEntity, Integer> {

		public DcIncomeEntity findByCaseNum(Integer caseNum);
}
