package com.binsenteu.carburant.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.binsenteu.carburant.model.gasstation.GasStation;

public interface GasStationRepository extends JpaRepository<GasStation, Integer>{
	
	@Transactional
	List<GasStation> findByLocalisationCodePostal(String codePostal);
	

	
	
//	@Query("SELECT g FROM GasStation g " + 
//			"WHERE "
//			+ "g.localisation.latitude/100000.0 BETWEEN ((:latitude - :distance/6371.0)*180/pi()) AND ((:latitude + :distance/6371)*180/pi()) "
//			+ "AND g.localisation.longitude/100000.0 BETWEEN ((:longitude - (asin(:distance/6371.0))*180/pi())/cos((:latitude)*180/pi())) AND ((:longitude + (asin(:distance/6371.0))*180/pi())/cos((:latitude)*180/pi())) "
//			+ "HAVING (((acos(sin((:latitude*pi()/180)) * sin((g.localisation.latitude/100000*pi()/180)) + cos((:latitude*pi()/180)) *" + 
//			"cos((g.localisation.latitude/100000*pi()/180)) * cos(((:longitude - g.localisation.longitude/100000)*pi()/180))))*180/pi())*60*1.1515*1.609344) <= :distance")
//	List<GasStation> findByLocalisationAndDistance(Double latitude, Double longitude, Double distance);
	
	@Query("SELECT g FROM GasStation g " + 
			"WHERE "
			+ "(((acos(sin((:latitude*pi()/180)) * sin((g.localisation.latitude/100000*pi()/180)) + cos((:latitude*pi()/180)) *" + 
			"cos((g.localisation.latitude/100000*pi()/180)) * cos(((:longitude - g.localisation.longitude/100000)*pi()/180))))*180/pi())*60*1.1515*1.609344) <= :distance")
	List<GasStation> findByLocalisationAndDistance(Double latitude, Double longitude, Double distance);
	
	
	//use bounding box only
//	@Query("SELECT g FROM GasStation g " + 
//			"WHERE "
//			+ "g.localisation.latitude/100000 BETWEEN (:latitude-:distance/6371) AND (:latitude+:distance/6371) AND "
//			+ "g.localisation.longitude/100000 BETWEEN (:longitude-asin(:distance/6371)/cos(:latitude/100000)) AND (:longitude+asin(:distance/6371)/cos(:latitude/100000))")
//	List<GasStation> findByLocalisationAndDistance(Double latitude, Double longitude, Double distance);
	
}
