package com.r.dreams_2.dto;

import com.r.dreams_2.entity.Point;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteToPointDTO {
    private Long id;
    private String typeOfTransport;
    private LocalDateTime startRoute;
    private LocalDateTime finishRoute;
    private Point point;
}
