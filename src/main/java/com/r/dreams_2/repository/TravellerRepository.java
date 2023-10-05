package com.r.dreams_2.repository;

import com.r.dreams_2.entity.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller,Long> {

}
