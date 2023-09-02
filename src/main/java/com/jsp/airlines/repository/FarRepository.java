package com.jsp.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airlines.entity.FarTable;

public interface FarRepository extends JpaRepository<FarTable, Integer>{

}
