
package com.spring.jdbc.mapper;



import com.spring.jdbc.dto.Fusion5DTO;

import com.spring.jdbc.entity.Fusion5;

public class Fusion5Mapper {

	public static Fusion5 mapToFusion5(Fusion5DTO fusion5Dto) {
	    if (fusion5Dto == null) {
	        return null;
	    }

	    Fusion5 fusion5 = new Fusion5();
	    fusion5.setEmpId(fusion5Dto.getEmpId());
	    fusion5.setFirstEmpName(fusion5Dto.getFirstEmpName());
	    fusion5.setLastName(fusion5Dto.getLastName());
	    fusion5.setSalary(fusion5Dto.getSalary());
	    fusion5.setBloodGroup(fusion5Dto.getBloodGroup());
	    fusion5.setEmpPhNo(fusion5Dto.getEmpPhNo());
        fusion5.setEmilId(fusion5Dto.getEmilId());
	    

	    return fusion5;
	}

	public static Fusion5DTO mapToFusion5Dto(Fusion5 fusion5) {
	    if (fusion5 == null) {
	        return null;
	    }

	    Fusion5DTO fusion5Dto = new Fusion5DTO();
	    fusion5Dto.setEmpId(fusion5.getEmpId());
	    fusion5Dto.setFirstEmpName(fusion5.getFirstEmpName());
	    fusion5Dto.setLastName(fusion5.getLastName());
	    fusion5Dto.setSalary(fusion5.getSalary());
	    fusion5Dto.setBloodGroup(fusion5.getBloodGroup());
	    fusion5Dto.setEmpPhNo(fusion5.getEmpPhNo());
	    fusion5Dto.setEmilId(fusion5.getEmilId());

	  

	    return fusion5Dto;
	}

}

