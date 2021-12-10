package com.example.employee.mbean;


import com.example.employee.service.PositionService;
import com.example.employee.uito.PositionUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller("positionController")
@SessionScope
public class PositionController {

    @Autowired
    private PositionService positionService;

    private List<PositionUITO> positionUiToList;

    private PositionUITO posUiTO;
    @PostConstruct
    public void getAllPos() {
        if (!this.getPosUiToList().isEmpty()) {
            this.getPosUiToList().clear();
            this.getPositionUiToList().clear();
        }
        this.getPositionUiToList().addAll(positionService.getAllPosition());
    }


    public List<PositionUITO> getPosUiToList() {
        if (null == positionUiToList) {
            positionUiToList = new ArrayList<>();
        }
        return positionUiToList;
    }

    public List<PositionUITO> getPositionUiToList() {
        if (positionUiToList == null) {
            positionUiToList = new ArrayList<>();
        }
        return positionUiToList;
    }

    public PositionUITO getPosUiTO() {
        if (posUiTO == null) {
            posUiTO = new PositionUITO();
        }
        return posUiTO;
    }

    public void setEmpUiTO(PositionUITO posUiTO) {
        this.posUiTO = posUiTO;
    }



}
