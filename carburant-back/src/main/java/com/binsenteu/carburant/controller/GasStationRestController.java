package com.binsenteu.carburant.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binsenteu.carburant.model.gasstation.GasStation;
import com.binsenteu.carburant.service.GasStationService;
import com.binsenteu.carburant.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/gas_station")
@CrossOrigin(origins = "*")
public class GasStationRestController {
	
	@Autowired
	GasStationService gasStationService;
	
	@JsonView(Views.GasStationView.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<GasStation> findById(@PathVariable("id") Integer id) {
		Optional<GasStation> opt = gasStationService.findById(id);
		return opt.map(gasStation -> {
			return new ResponseEntity<GasStation>(gasStation, HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<GasStation>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping(value = "/hello")
	public ResponseEntity<String> hello(){
		String hello = "hello";
		return new ResponseEntity<String>(hello, HttpStatus.OK);
	}
	
	
	
	

}
