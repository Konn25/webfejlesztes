package com.example.employee.uito;

import java.io.Serializable;
import java.util.List;

public class PositionUITO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long posID;
    private String posName;

    private List<EmployeeUITO> employeeUITOLst;

    public Long getPosID() {
        return posID;
    }

    public void setPosID(Long posID) {
        this.posID = posID;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public List<EmployeeUITO> getEmployeeUITOLst() {
        return employeeUITOLst;
    }

    public void setEmployeeUITOLst(List<EmployeeUITO> employeeUITOLst) {
        this.employeeUITOLst = employeeUITOLst;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((posID == null) ? 0 : posID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PositionUITO other = (PositionUITO) obj;
        if (posID == null) {
            if (other.posID != null)
                return false;
        } else if (!posID.equals(other.posID))
            return false;
        return true;
    }


}
