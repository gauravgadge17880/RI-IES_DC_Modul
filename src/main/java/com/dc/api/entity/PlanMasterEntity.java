//package com.dc.api.entity;
//
//import java.util.List;
//
//import org.hibernate.annotations.ManyToAny;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name = "IES_PLANMASTER")
//public class PlanMasterEntity {
//	
//	@Id
//	@GeneratedValue(strategy =GenerationType.IDENTITY)
//	private Integer planMasterId;
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="user_id")
//	private UserEntity userId;
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="case_num")
//	private AppEntity caseNum;
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@Column(name="plan_name")
//	private List<PlanEntity> planName;
//}
