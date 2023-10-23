package com.r.dreams_2.service;
import com.r.dreams_2.dto.PointDTO;
import java.util.List;
import java.util.Optional;

public interface PointService {
    Optional<PointDTO> getPoint(Long id);
    PointDTO createPoint (PointDTO pointDTO);
    PointDTO updatePoint(Long id, PointDTO pointDTO);
    void deletePoint(Long id);
    List<PointDTO> findAllPoints();
}
