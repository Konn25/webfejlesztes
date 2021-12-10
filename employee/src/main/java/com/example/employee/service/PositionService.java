package com.example.employee.service;

import java.util.List;

import com.example.employee.uito.PositionUITO;


public interface PositionService {

    List<PositionUITO> getAllPosition();

    PositionUITO getPosition(PositionUITO positionUITO);

}