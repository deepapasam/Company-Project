package com.spring.jdbc.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Entity
@Table(name = "Fusion6")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fusion5 {

    @Id
    @Column(name = "empId")
    private long empId;

    @Column(name = "FirstName")
    private String firstEmpName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "salary")
    private double salary;

    @Column(name = "bloodGroup")
    private String bloodGroup; // Corrected field name

    @Column(name = "empPhNo")
      
   // @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    private long empPhNo;

    @Column(name = "emailId") // Corrected field name
    private String emilId;

    
}
