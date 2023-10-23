package com.r.dreams_2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
@Component
@Scope("prototype")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "trip")
//    @JoinColumn(name = "point")
//    @PrimaryKeyJoinColumn
    private List<Point> points = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "traveller_id")
    private Traveller traveller;
}
