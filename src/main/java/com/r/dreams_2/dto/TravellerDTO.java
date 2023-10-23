package com.r.dreams_2.dto;

import com.r.dreams_2.entity.Address;
import com.r.dreams_2.entity.Trip;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravellerDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Address address;
    private Trip trip;
}
