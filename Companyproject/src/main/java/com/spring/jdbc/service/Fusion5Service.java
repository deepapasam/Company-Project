package com.spring.jdbc.service;

import java.util.List;
import java.util.Optional;

import com.spring.jdbc.dto.Fusion5DTO;
import com.spring.jdbc.entity.Fusion5;


public interface Fusion5Service {
    Fusion5DTO addEmployee(Fusion5DTO fusion5Dto);
    Fusion5DTO getEmployeetById(Long empId);
    Fusion5DTO updateEmployee(Long empId, Fusion5DTO fusion5Dto);
    void deleteEmployee(Long empId);
    List<Fusion5DTO> getAllEmployees();
    public List<Fusion5> findEmployeesByName(String name);
    public List<Fusion5DTO> findEmployeesBySalary(double salary);
   Fusion5DTO getEmployeestById(Long empId);
   Fusion5 findByEmilId(String emilId);
}
