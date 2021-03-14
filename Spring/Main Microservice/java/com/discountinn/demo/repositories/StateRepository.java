package com.discountinn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.discountinn.demo.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
