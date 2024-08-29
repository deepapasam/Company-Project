package com.spring.jdbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jdbc.dto.Fusion5DTO;
import com.spring.jdbc.entity.Fusion5;
@Repository

public interface Fusin5Repository extends JpaRepository<Fusion5, Long> {
	List<Fusion5> findByFirstEmpNameContainingIgnoreCase(String name);
	List<Fusion5> findBySalary(double salary);
	Fusion5 findByEmilId(String emilId);
}
