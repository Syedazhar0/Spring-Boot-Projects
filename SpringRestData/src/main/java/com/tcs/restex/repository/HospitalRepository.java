package com.tcs.restex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.restex.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
