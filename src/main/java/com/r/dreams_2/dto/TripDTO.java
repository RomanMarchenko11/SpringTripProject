package com.r.dreams_2.dto;
import com.r.dreams_2.entity.Point;
import com.r.dreams_2.entity.Traveller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripDTO {
    private Long id;
    private String name;
    private String description;
    private List<Point> points;
    private Traveller traveller;
}
