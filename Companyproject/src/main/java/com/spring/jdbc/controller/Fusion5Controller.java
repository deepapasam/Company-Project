package com.spring.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.jdbc.dto.Fusion5DTO;
import com.spring.jdbc.entity.Fusion5;
import com.spring.jdbc.service.Fusion5Service;

import jakarta.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/employees")
public class Fusion5Controller {

    private final Fusion5Service fusion5Service;

    @Autowired
    public Fusion5Controller(Fusion5Service fusion5Service) {
        this.fusion5Service = fusion5Service;
    }
    @GetMapping("/homepage")
    public String homePage() {
    	return "employees/home";
    	
    }
    @GetMapping("/main")
    public String mainHomePage() {
    	return "employees/mainHome";
    	
    }
    

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Fusion5DTO());
        return "employees/add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Fusion5DTO fusion5Dto, RedirectAttributes redirectAttributes) {
        try {
            fusion5Service.addEmployee(fusion5Dto);
            redirectAttributes.addFlashAttribute("successMessage", "Employee successfully added!");
            return "/employees/success"; // Redirect to list page after successful addition
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while adding the employee.");
            return "redirect:/employees/add"; // Redirect back to the form with error message
        }
    }

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", fusion5Service.getAllEmployees());
        return "employees/list";
    }

    @GetMapping("/{empId}")
    public String getEmployee(@PathVariable Long empId, Model model) {
        Fusion5DTO employee = fusion5Service.getEmployeetById(empId);
        model.addAttribute("employee", employee);
        return "employees/view";
    }

   

    @PostMapping
    public String createEmployee(@ModelAttribute Fusion5DTO employee) {
        fusion5Service.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{empId}/edit")
    public String editEmployeeForm(@PathVariable Long empId, Model model) {
        Fusion5DTO employee = fusion5Service.getEmployeetById(empId);
        model.addAttribute("employee", employee);
        return "employees/edit";
    }

    // Method to handle form submission
    @PostMapping("/{empId}")
    public String updateEmployee(@PathVariable Long empId, @ModelAttribute Fusion5DTO employee) {
        fusion5Service.updateEmployee(empId, employee);
        return "/employees/updateSuccess";
    }

    @PostMapping("/{empId}/delete")
    public String deleteEmployee(@PathVariable Long empId) {
        fusion5Service.deleteEmployee(empId);
        return "/employees/delete";
    }
    @GetMapping("/byname")
    public String getEmployeesByName(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("employees", fusion5Service.findEmployeesByName(name));
        return "employees/byName";
    }
    @GetMapping("/bysalary")
    public String getEmployeesBySalary(@RequestParam(name = "salary", required = false, defaultValue = "0") double salary, Model model) {
        model.addAttribute("employees", fusion5Service.findEmployeesBySalary(salary));
        return "employees/bySalary";
    }
    
    @GetMapping("/byid")
    public String getEmployeeById(@RequestParam(name = "empId", required = false) Long empId, Model model) {
        if (empId != null) {
            try {
                Fusion5DTO employee = fusion5Service.getEmployeetById(empId);
                model.addAttribute("employee", employee);
            } catch (EntityNotFoundException e) {
                model.addAttribute("employee", null); // Employee not found
            }
        }
        return "employees/byId";
    }
    @GetMapping("/byemilid")
    public String getEmployeesByEmailId(@RequestParam(name = "emilId", required = false) String emilId, Model model) {
        if (emilId == null || emilId.isEmpty()) {
            model.addAttribute("employee", null);
            return "employees/byEmilId";
        }
        Fusion5 employee = fusion5Service.findByEmilId(emilId);
        model.addAttribute("employee", employee);
        return "employees/byEmilId";
    }

}
