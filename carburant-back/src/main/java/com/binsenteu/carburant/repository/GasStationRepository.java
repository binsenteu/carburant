package com.binsenteu.carburant.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binsenteu.carburant.model.gasstation.GasStation;

public interface GasStationRepository extends JpaRepository<GasStation, Integer>{
	
	@Transactional
	List<GasStation> findByLocalisationCodePostal(String codePostal);
	
	
	
	
	
}
