package com.r.dreams_2.service;

import com.r.dreams_2.dto.RouteToPointDTO;
import com.r.dreams_2.entity.RouteToPoint;
import com.r.dreams_2.exceptions.CustomException;
import com.r.dreams_2.repository.RouteRepository;
import com.r.dreams_2.utils.RouteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;

    public RouteServiceImpl(RouteRepository routeRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<RouteToPointDTO> getRouteToPoint(Long id) {
        return routeRepository.findById(id).map(routeMapper::toDTO);
    }

    @Transactional
    @Override
    public RouteToPointDTO createRouteToPoint(RouteToPointDTO routeToPointDTO) {
        RouteToPoint routeToPoint = routeMapper.toEntity(routeToPointDTO);
        routeToPoint = routeRepository.save(routeToPoint);
        return routeMapper.toDTO(routeToPoint);
    }

    @Transactional
    @Override
    public RouteToPointDTO updateRouteToPoint(Long id, RouteToPointDTO routeToPointDTO) {
        if (routeRepository.existsById(id)) {
            RouteToPoint routeToPoint = routeMapper.toEntity(routeToPointDTO);
            routeToPoint.setId(id);
            routeToPoint = routeRepository.save(routeToPoint);
            return routeMapper.toDTO(routeToPoint);
        }
        return null;
    }

    @Transactional(rollbackFor = CustomException.class, propagation = Propagation.REQUIRED)
    @Override
    public void deleteRouteToPoint(Long id) {
        routeRepository.deleteById(id);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<RouteToPointDTO> findAllRouteToPoints() {
        return routeRepository.findAll()
                .stream()
                .map(routeMapper::toDTO)
                .collect(Collectors.toList());
    }
}
