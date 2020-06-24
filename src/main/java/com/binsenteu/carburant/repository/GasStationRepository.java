package com.binsenteu.carburant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binsenteu.carburant.model.gasstation.GasStation;

public interface GasStationRepository extends JpaRepository<GasStation, Integer>{
	
}
