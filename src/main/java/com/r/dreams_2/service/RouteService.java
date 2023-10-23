package com.r.dreams_2.service;

import com.r.dreams_2.dto.RouteToPointDTO;

import java.util.List;
import java.util.Optional;

public interface RouteService {
    Optional<RouteToPointDTO> getRouteToPoint(Long id);

    RouteToPointDTO createRouteToPoint(RouteToPointDTO routeToPointDTO);

    RouteToPointDTO updateRouteToPoint(Long id, RouteToPointDTO routeToPointDTO);

    void deleteRouteToPoint(Long id);

    List<RouteToPointDTO> findAllRouteToPoints();
}
