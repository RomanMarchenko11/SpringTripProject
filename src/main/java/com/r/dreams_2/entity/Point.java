package com.r.dreams_2.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
@Component
@Scope("prototype")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String comment;
    @JoinColumn(name = "trip_id")
    private Trip trip;
    @JoinColumn(name = "address_id")
    private Address address;
    @JoinColumn(name = "route_id")
    private RouteToPoint route;
}
