package com.jsp.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airlines.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
