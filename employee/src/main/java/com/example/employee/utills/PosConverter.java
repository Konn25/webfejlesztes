package com.example.employee.utills;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.example.employee.service.PositionService;
import com.example.employee.uito.PositionUITO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PosConverter implements Converter{

    @Autowired
    private PositionService positionService;

    private static final Logger LOG = LoggerFactory.getLogger(PosConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        LOG.info("getAsObject: " + positionService);

        PositionUITO departmentUITO = new PositionUITO();
        departmentUITO.setPosName(string);
        departmentUITO = positionService.getPosition(departmentUITO);
        System.out.println(departmentUITO.toString());
        return departmentUITO;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        LOG.info("getAsString obj class: " + obj.getClass().getName());
        if (obj instanceof PositionUITO) {
            PositionUITO dept = (PositionUITO) obj;
            LOG.info("getAsString def name: " + dept.getPosName());
            return dept.getPosName();
        } else {
            StringBuilder sbError = new StringBuilder("The object of class ");
            sbError.append(obj.getClass().getName()).append(" is not of DepartmentUITO");
            throw new ClassCastException(sbError.toString());
        }
    }

}
