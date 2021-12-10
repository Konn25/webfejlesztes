package com.example.employee.repositry;

import com.example.employee.entity.PositionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends JpaRepository<PositionDTO, Long> {

    PositionDTO findTitleByPosName(String posName);
}
