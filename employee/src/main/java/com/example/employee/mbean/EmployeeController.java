package com.example.employee.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import com.example.employee.service.EmployeeService;
import com.example.employee.service.PositionService;
import com.example.employee.uito.EmployeeUITO;
import com.example.employee.uito.PositionUITO;
import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;



@Controller("emplController")
@SessionScope
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    private String actionLabel;
    private EmployeeUITO empUiTO;
    private List<EmployeeUITO> empUiToList;

    private List<PositionUITO> positionUiToList;

    /**
     * add or update new Record in DB
     *
     * @return
     */
    public void doSaveInfoEmpl() {
        System.out.println(this.getEmpUiTO());
        employeeService.doSaveEmp(this.getEmpUiTO());
        getAllEmpl();
        this.setEmpUiTO(new EmployeeUITO());
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Employee Details", "Employee Details added/Updated Successfully."));

    }

    /**
     * Default load all the Employee info
     */
    @PostConstruct
    public void getAllEmpl() {
        if (!this.getEmpUiToList().isEmpty()) {
            this.getEmpUiToList().clear();
            this.getPositionUiToList().clear();
        }
        System.out.println(" >>>>>>>>>>>>> " + employeeService);
        this.getEmpUiToList().addAll(employeeService.doFetchAllEmp());
        this.getPositionUiToList().addAll(positionService.getAllPosition());
        this.setActionLabel("Add");
    }

    /**
     * Remove selected Employee info
     *
     * @return
     */

    public void deleteEmployee(EmployeeUITO employeeUiTO) {
        employeeService.doDeleteEmp(employeeUiTO);
        getAllEmpl();
    }

    public void editEmployee(EmployeeUITO employeeUiTO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(employeeUiTO, this.getEmpUiTO());
        System.out.println(this.getEmpUiTO());
    }

    public EmployeeUITO getEmpUiTO() {
        if (empUiTO == null) {
            empUiTO = new EmployeeUITO();
        }
        return empUiTO;
    }

    public void setEmpUiTO(EmployeeUITO empUiTO) {
        this.empUiTO = empUiTO;
    }

    public List<EmployeeUITO> getEmpUiToList() {
        if (null == empUiToList) {
            empUiToList = new ArrayList<>();
        }
        return empUiToList;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public List<PositionUITO> getPositionUiToList() {
        if (positionUiToList == null) {
            positionUiToList = new ArrayList<>();
        }
        return positionUiToList;
    }

    public void setPositionUiToList(List<PositionUITO> positionUiToList) {
        this.positionUiToList = positionUiToList;
    }


}
