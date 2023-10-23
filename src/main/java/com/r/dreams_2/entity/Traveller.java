package com.r.dreams_2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table
@Component
@Scope("prototype")
public class Traveller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    @JsonIgnore
    private String password;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
//    private RoleUser roleUser;

    @OneToOne
    @JoinColumn(name = "trip")
    private Trip trip;
}