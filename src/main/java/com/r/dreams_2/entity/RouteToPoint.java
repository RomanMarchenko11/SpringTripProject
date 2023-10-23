package com.r.dreams_2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
@Component
@Scope("prototype")
public class RouteToPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeOfTransport;
    private LocalDateTime startRoute;
    private LocalDateTime finishRoute;

    @OneToOne
    @JoinColumn(name = "point")
    private Point point;
}
