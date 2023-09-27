package com.r.dreams_2.dto;

import jdk.jshell.Snippet;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class TravellerDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;


}
