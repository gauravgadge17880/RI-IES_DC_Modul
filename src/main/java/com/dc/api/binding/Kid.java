package com.dc.api.binding;

import java.time.LocalDate;



import lombok.Data;


@Data
public class Kid {

	
	private String kidName;
	
	private LocalDate kidDob;
	
	private Long kidSsn;
	
	private Integer caseNum;
	
	private Integer userId;

}
