package com.binsenteu.carburant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binsenteu.carburant.model.gasstation.GasStation;
import com.binsenteu.carburant.repository.GasStationRepository;

@Service
public class GasStationServiceImpl implements GasStationService {

	@Autowired
	private GasStationRepository gasStationRepository;
	
	@Override 
	public GasStation insert(GasStation t) {
		return (GasStation) gasStationRepository.save(t);
	}

	@Override
	public GasStation update(GasStation gasStation) {
		Optional<GasStation> opt = gasStationRepository.findById(gasStation.getId());
		if (opt.isPresent()) {
			GasStation stationEnBase = opt.get();
			stationEnBase.setFuel(gasStation.getFuel());
			stationEnBase.setHours(gasStation.getHours());
			stationEnBase.setLocalisation(gasStation.getLocalisation());
			stationEnBase.setAutomate247(gasStation.getAutomate247());
			return gasStationRepository.save(stationEnBase);
		} else {
			return null;
		}
	}

	@Override
	public List<GasStation> findAll() {
		return gasStationRepository.findAll();
	}
	
	@Override
	public Optional<GasStation> findById(Integer id) {
		return gasStationRepository.findById(id);
	}
	
	@Override
	public List<GasStation> findByLocalisationCodePostal(String zip) {
		return gasStationRepository.findByLocalisationCodePostal(zip);
	}
	
	@Override
	public List<GasStation> findByLocalisationAndDistance(Double latitude, Double longitude, Double distance) {
		return gasStationRepository.findByLocalisationAndDistance(latitude, longitude, distance);
	}

	@Override
	public void delete(GasStation t) {
		gasStationRepository.delete(t);
		
	}

	@Override
	public void deleteById(Integer id) {
		Optional<GasStation> opt = gasStationRepository.findById(id);
		if (opt.isPresent()) {
			gasStationRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException();
		}
	}

	


}
