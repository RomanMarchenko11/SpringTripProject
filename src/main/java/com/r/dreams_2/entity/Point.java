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
@Table(name = "points")
@Component
@Scope("prototype")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
