package com.dc.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dc.api.entity.DcEducationEntity;
import com.dc.api.entity.UserEntity;

public interface UserEntityRepo extends JpaRepository<UserEntity , Integer> {
	public UserEntity findByCaseNum(Integer caseNum);

}
