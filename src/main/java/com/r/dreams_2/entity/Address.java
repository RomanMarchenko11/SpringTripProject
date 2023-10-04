package com.r.dreams_2.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "address")
@Component
@Scope("prototype")
public class Address {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String street;
}
