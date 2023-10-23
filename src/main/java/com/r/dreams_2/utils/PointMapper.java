package com.r.dreams_2.utils;

import com.r.dreams_2.dto.PointDTO;
import com.r.dreams_2.entity.Point;
import org.springframework.stereotype.Component;

@Component
public class PointMapper {
    public PointDTO toDTO(Point point) {
        PointDTO dtoPoint = new PointDTO();
        dtoPoint.setId (point.getId());
        dtoPoint.setName(point.getName());
        dtoPoint.setComment(point.getComment());
        dtoPoint.setTrip(point.getTrip());
        dtoPoint.setAddress(point.getAddress());
        dtoPoint.setRoute(point.getRoute());
        return dtoPoint;
    }

    public Point toEntity(PointDTO pointDTO) {
        Point point = new Point();
        point.setId(pointDTO.getId());
        point.setName(pointDTO.getName());
        point.setComment(pointDTO.getComment());
        point.setTrip(pointDTO.getTrip());
        point.setAddress(pointDTO.getAddress());
        point.setRoute(pointDTO.getRoute());
        return point;
    }
}
