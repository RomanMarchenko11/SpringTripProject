package com.r.dreams_2.utils;

import com.r.dreams_2.dto.RouteToPointDTO;
import com.r.dreams_2.entity.RouteToPoint;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {
    public RouteToPointDTO toDTO(RouteToPoint routeToPoint) {
        RouteToPointDTO routeToPointDTO = new RouteToPointDTO();
        routeToPointDTO.setId(routeToPoint.getId());
        routeToPointDTO.setPoint(routeToPoint.getPoint());
        routeToPointDTO.setTypeOfTransport(routeToPoint.getTypeOfTransport());
        routeToPointDTO.setStartRoute(routeToPoint.getStartRoute());
        routeToPointDTO.setFinishRoute(routeToPoint.getFinishRoute());
        return routeToPointDTO;
    }

    public RouteToPoint toEntity(RouteToPointDTO routeToPointDTO) {
        RouteToPoint routeToPoint = new RouteToPoint();
        routeToPoint.setId(routeToPointDTO.getId());
        routeToPoint.setPoint(routeToPointDTO.getPoint());
        routeToPoint.setTypeOfTransport(routeToPointDTO.getTypeOfTransport());
        routeToPoint.setStartRoute(routeToPointDTO.getStartRoute());
        routeToPoint.setFinishRoute(routeToPointDTO.getFinishRoute());
        return routeToPoint;
    }
}
