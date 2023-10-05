package com.r.dreams_2.repository;

import com.r.dreams_2.entity.RouteToPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<RouteToPoint, Long> {

}
