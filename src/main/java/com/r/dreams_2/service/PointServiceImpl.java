package com.r.dreams_2.service;
import com.r.dreams_2.dto.PointDTO;
import com.r.dreams_2.entity.Point;
import com.r.dreams_2.exceptions.CustomException;
import com.r.dreams_2.repository.PointRepository;
import com.r.dreams_2.utils.PointMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PointServiceImpl implements PointService{
    private final PointRepository pointRepository;
    private final PointMapper pointMapper;

    public PointServiceImpl(PointRepository pointRepository, PointMapper pointMapper) {
        this.pointRepository = pointRepository;
        this.pointMapper = pointMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PointDTO> getPoint(Long id) {
        return pointRepository.findById(id).map(pointMapper::toDTO);
    }

    @Transactional
    @Override
    public PointDTO createPoint(PointDTO pointDTO) {
        Point point = pointMapper.toEntity(pointDTO);
        point = pointRepository.save(point);
        return pointMapper.toDTO(point);
    }

    @Transactional
    @Override
    public PointDTO updatePoint(Long id, PointDTO pointDTO) {
        if (pointRepository.existsById(id)) {
            Point point = pointMapper.toEntity(pointDTO);
            point.setId(id);
            point = pointRepository.save(point);
            return pointMapper.toDTO(point);
        }
        return null;
    }

    @Transactional(rollbackFor = CustomException.class, propagation = Propagation.REQUIRED)
    @Override
    public void deletePoint(Long id) {
        pointRepository.deleteById(id);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<PointDTO> findAllPoints() {
        return pointRepository.findAll()
                .stream()
                .map(pointMapper::toDTO)
                .collect(Collectors.toList());
    }
}
