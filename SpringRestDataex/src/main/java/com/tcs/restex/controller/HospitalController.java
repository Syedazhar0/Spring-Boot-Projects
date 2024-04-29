package com.tcs.restex.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;


import com.tcs.restex.entity.Hospital;
import com.tcs.restex.model.HospitalDetails;
import com.tcs.restex.service.HospitalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	// save
	@PostMapping("/save")
	//@valid is validation dependency if the name mobile are not intered it will display
	// user defined error message
	// with request entity
//	public Hospital creHospital(@Valid @RequestBody HospitalDetails hospitalDetails) {
//		return hospitalService.save(hospitalDetails); 
//	}
	
	// with request entity which shows the header body and status code in postman
	public ResponseEntity< Hospital> creHospital(@Valid @RequestBody HospitalDetails hospitalDetails) {
		Hospital hospital= hospitalService.save(hospitalDetails); 
		return ResponseEntity.status(HttpStatus.CREATED)
				.header("Status","data created")
				.body(hospital);
	}
	
	// find by id
	
	@GetMapping("/{id}")
	public Hospital findByIdHospital(@PathVariable Long id) {
		return hospitalService.findById(id);
	}
	
	// delete by id
	
	@DeleteMapping("/{id}")
	public void getMethodName(@PathVariable Long id) {
		 hospitalService.deleteById(id);
	}
	
	//findall
	
	@GetMapping("/getall")
	public List<Hospital> findallHospitals(Hospital hospital) {
		List<Hospital>list=hospitalService.findAll();
		return list;
	}
	
	// SaveAll 
	@PostMapping("saveall")
	public List<Hospital> saveAll( @Valid  @RequestBody List<HospitalDetails> hospital){
		List<Hospital> saveAllHospitals=hospitalService.saveAll(hospital);
		return saveAllHospitals;
	}
	
	// update
	@PutMapping("/{id}")
	public Hospital updateHospitalName(@PathVariable Long id, @RequestBody HospitalDetails hospitalDetails) {
	    return hospitalService.updateHospitalName(id, hospitalDetails.getName());
	}

//update using patch
	// update
	@PatchMapping("/{id}")
	public Hospital updateHospitalName(@PathVariable Long id, @RequestParam String name) {
	    return hospitalService.updateHospitalName(id, name);
	}

	
	// find by name custom methods
	
	@GetMapping("/name/{name}")
	public Hospital findByHospitalName(@PathVariable String name) {
		return hospitalService.findByName(name);
	}
	
	// find by name and location
	 @GetMapping("/namelocation/{name}/{location}")
	    public Optional<Hospital> findByNameAndLocation(@PathVariable String name, @PathVariable String location) {
	        return hospitalService.findByNameAndLocation(name, location);
	    }
	 
	 // find by ratings
	 @GetMapping("/hospitals")
	    public List<Hospital> findHospitalsBetween(@RequestParam(defaultValue = "4.0") double minRating,
	            @RequestParam(defaultValue = "4.5") double maxRating) {
	     
	        return hospitalService.findHospitalsBetween(minRating, maxRating);
	    }
	 
	 @GetMapping("/hospitalslistss")
	 public List<Hospital> findHospitalsByNames(@RequestBody List<String> names) {
	     return hospitalService.findHospitalsByName(names);
	 }
	 
	 //sorting ascending and descending
	 @GetMapping("/getSorted")
	    public List<Hospital> findHospitalsBySorted() {
	        Sort sort = Sort.by(Direction.DESC, "name");
	        return hospitalService.findHospitalsBySorted(sort);
	    }

	    @GetMapping("/{pageNum}/{pageSize}")
	    public org.springframework.data.domain.Page<Hospital> findHospitalsByPaging(@PathVariable int pageNum, @PathVariable int pageSize) {
	        return hospitalService.findHospitalsByPaging(pageNum, pageSize);
	    }

	
}





//urls patch url http://localhost:8080/api/1?name=Yashodha // for update

	// get:http://localhost:8080/api/3 id or url for ex /test
	//getall:http://localhost:8080/api/getall

	//put: http://localhost:8080/api/1  for update

	//save:http://localhost:8080/api/save save 1 object
	// saveall:http://localhost:8080/api/saveall save group of array json object

	//post:http://localhost:8080/api/saveall // create the data into data base or post the data
	//post :http://localhost:8080/api/save


	//delete:http://localhost:8080/api/1 to delete the data

// custom method urls
// get: find by name:http://localhost:8080/api/name/medicover Hospital
//http://localhost:8080/api/name/yashoda Hospital


// find by name and location
//get:http://localhost:8080/api/namelocation/Lions Eye Hospital/kamareddy

//find the hospitals whose rating between 4.0 and 4.5
//get:http://localhost:8080/api/hospitals?minRating=4.0&maxRating=4.5


// find the hospitals details by giving the lists of hospitals names
//get:http://localhost:8080/api/hospitalslistss?
// give this list of name in side the raw body of post man
// ex:["medicover Hospital","yashoda Hospital","Gandhi Hospital"]
// sorting by name in ascending order use ASC
//get:http://localhost:8080/api/getSorted

//sorting by name in descending order Use DESC
//http://localhost:8080/api/getSorted

//pagination displaying data by page no ex:0 page size 2 it will display records 2 cux page num
// starts from  0 displaying data as per the size of page if page is small we display small amt of data
// get :http://localhost:8080/api/1/2

//response entity check photo to see the out put of this url
// post:http://localhost:8080/api/save
