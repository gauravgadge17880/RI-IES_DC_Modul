package com.dc.api.binding;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class Kids {

	private Integer caseNum;
	
	private Integer userId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Kid> listOfKids;

}
