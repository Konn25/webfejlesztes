package com.example.employee.service.impl;

import com.example.employee.entity.PositionDTO;
import com.example.employee.repositry.PositionRepo;
import com.example.employee.service.PositionService;
import com.example.employee.uito.PositionUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepo positionRepo;


    @Override
    public List<PositionUITO> getAllPosition() {
        List<PositionUITO> positionUITOLst = new ArrayList<>();
        List<PositionDTO> positionDTOLst = positionRepo.findAll();

        positionDTOLst.forEach(dto -> {
            PositionUITO tmpUiTO = new PositionUITO();

            BeanUtils.copyProperties(dto, tmpUiTO);
            positionUITOLst.add(tmpUiTO);
        });

        return positionUITOLst;
    }

    @Override
    public PositionUITO getPosition(PositionUITO positionUITO) {
        System.out.println(">>>>> " + positionUITO.getPosName());
        PositionDTO dto = positionRepo.findTitleByPosName(positionUITO.getPosName());
        PositionUITO uito = new PositionUITO();

        BeanUtils.copyProperties(dto, uito);
        return uito;
    }
}
