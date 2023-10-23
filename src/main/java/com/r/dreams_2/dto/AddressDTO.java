package com.r.dreams_2.dto;

import com.r.dreams_2.entity.Point;
import com.r.dreams_2.entity.Traveller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {
    private Long id;
    private String country;
    private String city;
    private String street;
    private Point point;
    private Traveller traveller;
}
