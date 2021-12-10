package com.example.employee.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "POSITIONS_WORK")
public class PositionDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POS_ID")
    private Long posID;
    @Column(name = "pos_Name")
    private String posName;

    @OneToMany(mappedBy = "positionDTO")
    private List<EmployeeDTO> employeedtolst;

    public Long getPosID() {
        return posID;
    }

    public void setPosID(Long deptId) {
        this.posID = deptId;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String deptName) {
        this.posName = deptName;
    }

    public List<EmployeeDTO> getEmployeedtolst() {
        if (null == employeedtolst) {
            employeedtolst = new ArrayList<>();
        }
        return employeedtolst;
    }

    public void setEmployeedtolst(List<EmployeeDTO> employeedtolst) {
        this.employeedtolst = employeedtolst;
    }
}
