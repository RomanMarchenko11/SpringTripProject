package com.r.dreams_2.dto;

import com.r.dreams_2.entity.Address;
import com.r.dreams_2.entity.RouteToPoint;
import com.r.dreams_2.entity.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PointDTO {
    private Long id;
    private String name;
    private String comment;
    private Trip trip;
    private Address address;
    private RouteToPoint route;
}
