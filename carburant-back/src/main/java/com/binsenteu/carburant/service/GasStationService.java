package com.binsenteu.carburant.service;

import java.util.List;

import com.binsenteu.carburant.model.gasstation.GasStation;

public interface GasStationService extends GenericInterfaceService<GasStation, Integer> {

	List<GasStation> findByLocalisationCodePostal(String zip);
	
	List<GasStation> findByLocalisationAndDistance(Double latitude, Double longitude, Double distance);

}
