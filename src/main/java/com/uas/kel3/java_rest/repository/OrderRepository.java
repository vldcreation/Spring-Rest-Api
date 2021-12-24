package com.uas.kel3.java_rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.uas.kel3.java_rest.model.*;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Query("select o from Order o where o.category = ?1")
	List<Order> findAllByCategory(String category);
	
	@Query("select o from Order o where o.category = ?1 and o.id_user = ?2")
	Order findByCategoryandIdUser(String category,Integer id_user);
	
	@Modifying
	@Query("delete from Order o where o.category = ?1 and o.id_user = ?2")
	void deleteAllOrderByCategoryandIdUser(String category,Integer id_user);
}
