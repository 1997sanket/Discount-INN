package com.discountinn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.discountinn.demo.models.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
