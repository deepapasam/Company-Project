package com.spring.jdbc.service;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jdbc.dto.Fusion5DTO;
import com.spring.jdbc.entity.Fusion5;
import com.spring.jdbc.mapper.Fusion5Mapper;
import com.spring.jdbc.repository.Fusin5Repository;

import jakarta.persistence.EntityNotFoundException;



@Service
public class Fusion5ServiceImp implements Fusion5Service {

    private final Fusin5Repository fusin5Repository;

    @Autowired
    public Fusion5ServiceImp(Fusin5Repository fusin5Repository) {
        this.fusin5Repository = fusin5Repository;
    }

    @Override
    @Transactional
    public Fusion5DTO addEmployee(Fusion5DTO fusion5Dto) {
        Fusion5 fusion5 = Fusion5Mapper.mapToFusion5(fusion5Dto);
        Fusion5 savedFusion5 = fusin5Repository.save(fusion5);
        return Fusion5Mapper.mapToFusion5Dto(savedFusion5);
    }

    

    @Override
    @Transactional
    public Fusion5DTO updateEmployee(Long empId, Fusion5DTO fusion5Dto) {
    	Fusion5 existingFusion5 = fusin5Repository.findById(empId)
                .orElseThrow(() -> new EntityNotFoundException("Employee Not found"));

        // Map the updated details from DTO to the existing entity
        existingFusion5.setFirstEmpName(fusion5Dto.getFirstEmpName());
        existingFusion5.setLastName(fusion5Dto.getLastName());
        existingFusion5.setSalary(fusion5Dto.getSalary());
        existingFusion5.setBloodGroup(fusion5Dto.getBloodGroup());
        existingFusion5.setEmpPhNo(fusion5Dto.getEmpPhNo());
        existingFusion5.setEmilId(fusion5Dto.getEmilId());

        // Save the updated entity back to the repository
        Fusion5 updatedFusion5 = fusin5Repository.save(existingFusion5);

        // Convert the updated entity back to DTO and return
        return Fusion5Mapper.mapToFusion5Dto(updatedFusion5);
    }


    @Override
    @Transactional
    public void deleteEmployee(Long empId) {
        Fusion5 fusion5 = fusin5Repository.findById(empId)
                .orElseThrow(() -> new EntityNotFoundException("Employee Not found"));
        fusin5Repository.delete(fusion5);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Fusion5DTO> getAllEmployees() {
        List<Fusion5> employees = fusin5Repository.findAll();
        return employees.stream()
                        .map(Fusion5Mapper::mapToFusion5Dto)
                        .collect(Collectors.toList());
    }
    @Override
    public Fusion5DTO getEmployeetById(Long empId) {
        return fusin5Repository.findById(empId)
                .map(Fusion5Mapper::mapToFusion5Dto)
                .orElseThrow(() -> new EntityNotFoundException("Employee Not found"));
    }

	@Override
	public List<Fusion5> findEmployeesByName(String name) {
		return fusin5Repository.findByFirstEmpNameContainingIgnoreCase(name);
    }

	@Override
	@Transactional(readOnly = true )
	
	public List<Fusion5DTO> findEmployeesBySalary(double salary) {
	    List<Fusion5> employees = fusin5Repository.findBySalary(salary);
	    return employees.stream()
	                    .map(Fusion5Mapper::mapToFusion5Dto)
	                    .collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Fusion5DTO getEmployeestById(Long empId) {
	    return fusin5Repository.findById(empId)
	            .map(Fusion5Mapper::mapToFusion5Dto)
	            .orElseThrow(() -> new EntityNotFoundException("Employee Not found"));
	}

	

	@Override
	public Fusion5 findByEmilId(String emilId) {
		 return fusin5Repository.findByEmilId(emilId);
	}

	}
