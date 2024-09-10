package com.dc.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dc.api.binding.Education;
import com.dc.api.binding.Income;
import com.dc.api.binding.Kid;
import com.dc.api.binding.Kids;
import com.dc.api.binding.PlanSelection;
import com.dc.api.binding.Summary;
import com.dc.api.entity.AppEntity;
import com.dc.api.entity.DcEducationEntity;
import com.dc.api.entity.DcIncomeEntity;
import com.dc.api.entity.DcKidEntity;
import com.dc.api.entity.PlanEntity;
import com.dc.api.entity.UserEntity;
import com.dc.api.repo.AppEntityRepo;
import com.dc.api.repo.CitizenAppRepo;
import com.dc.api.repo.DcEducationRepo;
import com.dc.api.repo.DcIncomeRepo;
import com.dc.api.repo.DcKidRepo;
import com.dc.api.repo.PlanEntityRepo;
import com.dc.api.repo.UserEntityRepo;

@Service
public class DcServiceImpl implements DcService {

//	@Autowired
//	private PlanMasterRepo planMaster;

	@Autowired
	private PlanEntityRepo planRepo;

	@Autowired
	private AppEntityRepo appRepo;

	@Autowired
	private CitizenAppRepo citizenAppRepo;

	@Autowired
	private DcEducationRepo edRepo;

	@Autowired
	private DcIncomeRepo incomeRepo;

	@Autowired
	private DcKidRepo kidRepo;

	@Autowired
	private UserEntityRepo userRepo;

	@Override
	public Map<Integer, String> getPlanNames() {

		List<PlanEntity> plans = planRepo.findAll();
		Map<Integer, String> plansMap = new HashMap<>();

		for (PlanEntity entity : plans) {
			plansMap.put(entity.getPlanId(), entity.getPlanName());
		}
		return plansMap;
	}

	@Override
	public boolean updatePlanSelection(PlanSelection planSel) {
		Integer caseNum = planSel.getCaseNum();
		Optional<AppEntity> findById = appRepo.findById(caseNum);

		UserEntity userEntity = userRepo.findById(planSel.getUserId()).get();

		if (findById.isPresent()) {
			AppEntity appEntity = findById.get();
			appEntity.setPlanId(planSel.getPlanId());
			appRepo.save(appEntity);
			return true;
		}

		return false;
	}

	@Override
	public boolean saveIncome(Income income) {
		DcIncomeEntity entity = new DcIncomeEntity();
		BeanUtils.copyProperties(income, entity);

		Integer caseNum = income.getCaseNum();
		Integer userId = income.getUserId();

		Optional<AppEntity> findById = appRepo.findById(caseNum);
		Optional<UserEntity> user = userRepo.findById(userId);

		AppEntity appEntity = findById.get();

		UserEntity userEntity = user.get();

		entity.setApp(appEntity);
		entity.setUser(userEntity);
		incomeRepo.save(entity);

		return true;
	}

	@Override
	public boolean saveEducation(Education edu) {
		Integer caseNum = edu.getCaseNum();
		Integer userId = edu.getUserId();

		Optional<AppEntity> findById = appRepo.findById(caseNum);
		Optional<UserEntity> user = userRepo.findById(userId);
		AppEntity appEntity = findById.get();
		UserEntity userEntity = user.get();

		DcEducationEntity entity = new DcEducationEntity();
		BeanUtils.copyProperties(edu, entity);

		entity.setUser(userEntity);
		entity.setApp(appEntity);
		return true;
	}

	@Override
	public boolean saveKids(Kids kids) {

		Integer caseNum = kids.getCaseNum();
		Integer userId = kids.getUserId();

		Optional<AppEntity> findById = appRepo.findById(caseNum);
		Optional<UserEntity> user = userRepo.findById(userId);
		AppEntity appEntity = findById.get();
		UserEntity userEntity = user.get();

		List<Kid> listOfKids = kids.getListOfKids();

		for (Kid kid : listOfKids) {
			DcKidEntity entity = new DcKidEntity();
			BeanUtils.copyProperties(kid, entity);

			entity.setUser(userEntity);
			entity.setApp(appEntity);

			kidRepo.save(entity);
		}
		return true;
	}

	@Override
	public Summary getSummaryInfo(Integer CaseNum) {
		Summary summary = new Summary();

		AppEntity appEntity = appRepo.findById(CaseNum).get();
		PlanEntity plan = appEntity.getPlanId();
		PlanEntity planEntity = planRepo.findById(plan.getPlanId()).get();

		DcIncomeEntity incomeEntity = incomeRepo.findByCaseNum(CaseNum);
		Income income = new Income();
		BeanUtils.copyProperties(incomeEntity, income);

		DcEducationEntity educationEntity = edRepo.findByCaseNum(CaseNum);
		Education education = new Education();
		BeanUtils.copyProperties(educationEntity, education);

		List<DcKidEntity> kidEntities = kidRepo.findByCaseNum(CaseNum);

		List<Kid> list = new ArrayList<>();
		for (DcKidEntity entity : kidEntities) {
			Kid kid = new Kid();
			BeanUtils.copyProperties(entity, kidEntities);
			list.add(kid);
		}
		Kids kids = new Kids();
		kids.setListOfKids(list);

		summary.setCaseNum(CaseNum);
		summary.setPlanName(planEntity.getPlanName());
		summary.setIncome(income);
		summary.setEducation(education);
		summary.setKids(kids);
		return summary;
	}

}
