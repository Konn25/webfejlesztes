package com.example.employee.service;

import java.util.List;

import com.example.employee.uito.EmployeeUITO;


public interface EmployeeService {
    EmployeeUITO doSaveEmp(EmployeeUITO employeeUiTO);

    List<EmployeeUITO> doFetchAllEmp();

    EmployeeUITO doGetEmp(EmployeeUITO employeeUiTO);

    void doDeleteEmp(EmployeeUITO employeeUiTO);
}
