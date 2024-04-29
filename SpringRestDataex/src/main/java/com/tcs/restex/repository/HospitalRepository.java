package com.tcs.restex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.restex.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	Hospital findByName(String name);

	Optional<Hospital> findByNameAndLocation(String name, String location);

	 List<Hospital> findByRatingBetween(double minRating, double maxRating);

	List<Hospital> findByNameIn(List<String> names);

	
	

	


}
  