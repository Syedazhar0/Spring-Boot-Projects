package com.tcs.restex.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.stereotype.Service;

import com.tcs.restex.entity.Hospital;
import com.tcs.restex.model.HospitalDetails;
import com.tcs.restex.repository.HospitalRepository;

@Service
public class HospitalService {
@Autowired
HospitalRepository hospitalRepository;

public Hospital save(HospitalDetails hospitalDetails) {
	          // reading the data from model class and set the data to entity class
	Hospital hospital = new Hospital();
	hospital.setName(hospitalDetails.getName());
	hospital.setLocation(hospitalDetails.getLocation());
	hospital.setRating(hospitalDetails.getRating());
	hospital.setCreateAt(LocalDateTime.now());
	hospital.setCreateBy(System.getProperty("user.name"));
	hospital.setEmail(hospitalDetails.getEmail());
	hospital.setMobile(hospitalDetails.getMobile());
	// save method create save the hospital in database and return the hospital
	
	// step :  sending data from  service class to repository to h2 data base
	Hospital savHospital =hospitalRepository.save(hospital);
	return savHospital;
}

public Hospital findById(Long id) {
	Optional<Hospital> idHospital =hospitalRepository.findById(  id);
	if (idHospital.isPresent()) {
		return  idHospital.get();
	}else {
		return null;
	}
}

public void deleteById(Long id) {
	hospitalRepository.deleteById(id);
}

public List<Hospital> findAll() {
	
	return hospitalRepository.findAll();
}

public List<Hospital> saveAll(List<HospitalDetails>details) {
	List<Hospital>allHospitals= new ArrayList<>();
	for (HospitalDetails details2:details) {
		Hospital hospital = new Hospital();
		hospital.setName(details2.getName());
		hospital.setLocation(details2.getLocation());
		hospital.setRating(details2.getRating());
		hospital.setCreateAt(LocalDateTime.now());
		hospital.setCreateBy(System.getProperty("user.name"));
		hospital.setEmail(details2.getEmail());
		hospital.setMobile(details2.getMobile());
		allHospitals.add(hospital);
		
	}
	return hospitalRepository.saveAll(allHospitals);
}

public Hospital updateHospitalName(Long id, String newName) {
    Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
    
    if (optionalHospital.isPresent()) {
        Hospital hospital = optionalHospital.get();
        hospital.setName(newName);
        return hospitalRepository.save(hospital);
    } else {
        return null; // or handle the case where the hospital with the given id is not found
    }
}

public Hospital updateHospitalName1(Long id, String newName) {
    Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
    
    if (optionalHospital.isPresent()) {
        Hospital hospital = optionalHospital.get();
        hospital.setName(newName);
        return hospitalRepository.save(hospital);
    } else {   
        throw new RuntimeException("Hospital not found with id: " + id);
    }
}

public Hospital findByName(String name) {
	
	return hospitalRepository.findByName(name);
}

public Optional<Hospital> findByNameAndLocation(String name, String location) {
    return hospitalRepository.findByNameAndLocation(name, location);
}

public List<Hospital> findHospitalsBetween(double minRating, double maxRating) {
    return hospitalRepository.findByRatingBetween(minRating, maxRating);
}

public List<Hospital> findHospitalsByName(List<String> names) {
    List<Hospital> nameHospitals = hospitalRepository.findByNameIn(names);
    return nameHospitals;
}

public List<Hospital> findHospitalsBySorted(org.springframework.data.domain.Sort sort) {
    return hospitalRepository.findAll(sort);
}

public org.springframework.data.domain.Page<Hospital> findHospitalsByPaging(int pageNum, int pageSize) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    return hospitalRepository.findAll(pageable);
}

}
   
   

