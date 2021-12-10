package com.example.employee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;


@Entity
@Table(name = "EMP_INFO")
@NamedQuery(name = "EmployeeDTO.findAll", query = "SELECT a FROM EmployeeDTO a")
public class EmployeeDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    @Column(name = "EMP_NAME", nullable = false)
    private String empName;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    private String address1;
    @Column(name = "EMAIL_ID")
    private String emailId;
    @Column(name = "SALARY")
    private Long salary;
    @Column(name = "AGE")
    private Long age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POS_ID")
    private PositionDTO positionDTO;

    public Long getSalary(){
        return  salary;
    }

    public void setSalary(Long salary){
        this.salary = salary;
    }

    public Long getAge(){
        return age;
    }

    public void setAge(Long age){
        this.age = age;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public PositionDTO getDepartmentDTO() {

        return positionDTO;
    }

    public void setDepartmentDTO(PositionDTO positionDTO) {
        this.positionDTO = positionDTO;
    }


}
