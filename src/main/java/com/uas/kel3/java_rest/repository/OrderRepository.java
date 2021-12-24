package com.uas.kel3.java_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uas.kel3.java_rest.model.*;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
}
