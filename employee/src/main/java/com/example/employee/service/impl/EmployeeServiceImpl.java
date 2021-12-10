package com.example.employee.service.impl;

import com.example.employee.entity.EmployeeDTO;
import com.example.employee.entity.PositionDTO;
import com.example.employee.repositry.EmployeeRepo;
import com.example.employee.service.EmployeeService;
import com.example.employee.uito.EmployeeUITO;
import com.example.employee.uito.PositionUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    @Transactional(readOnly = false)
    public EmployeeUITO doSaveEmp(EmployeeUITO employeeUiTO) {
        EmployeeDTO dto = UiToToDto(employeeUiTO);
        dto = employeeRepo.save(dto);
        BeanUtils.copyProperties(dto, employeeUiTO);

        dtoToUito(employeeUiTO, dto);
        return employeeUiTO;
    }

    private void dtoToUito(EmployeeUITO employeeUiTO, EmployeeDTO dto) {
        PositionUITO uitTO = new PositionUITO();
        BeanUtils.copyProperties(dto.getDepartmentDTO(), uitTO);
        employeeUiTO.setPositionUITO(uitTO);
    }

    private EmployeeDTO UiToToDto(EmployeeUITO employeeUiTO) {
        EmployeeDTO dto = new EmployeeDTO();
        PositionDTO deptDto = new PositionDTO();
        BeanUtils.copyProperties(employeeUiTO, dto);
        BeanUtils.copyProperties(employeeUiTO.getPositionUITO(), deptDto);
        dto.setDepartmentDTO(deptDto);
        List<EmployeeDTO> lst = new ArrayList<>();
        lst.add(dto);
        deptDto.getEmployeedtolst().addAll(lst);
        return dto;
    }

    @Override
    public List<EmployeeUITO> doFetchAllEmp() {
        List<EmployeeDTO> dtoLst = employeeRepo.findAll();
        List<EmployeeUITO> uiTOLst = new ArrayList<>();
        dtoLst.forEach(dto -> {
            EmployeeUITO tmpUiTO = new EmployeeUITO();
            System.out.println(dto.getDepartmentDTO());
            BeanUtils.copyProperties(dto, tmpUiTO);

            dtoToUito(tmpUiTO, dto);
            uiTOLst.add(tmpUiTO);
        });
        return uiTOLst;
    }

    @Override
    public EmployeeUITO doGetEmp(EmployeeUITO employeeUiTO) {
        if (null != employeeUiTO.getEmailId()) {
            EmployeeDTO dto = new EmployeeDTO();

            BeanUtils.copyProperties(employeeUiTO, dto);
            dto = employeeRepo.getOne(dto.getEmpId());

            BeanUtils.copyProperties(dto, employeeUiTO);
        }
        return employeeUiTO;
    }

    @Override
    @Transactional
    public void doDeleteEmp(EmployeeUITO employeeUiTO) {

        employeeRepo.deleteById(employeeUiTO.getEmpId());
    }
}
