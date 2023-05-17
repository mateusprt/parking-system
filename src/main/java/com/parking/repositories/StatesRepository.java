package com.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.models.State;

@Repository
public interface StatesRepository extends JpaRepository<State, Long> {

}
