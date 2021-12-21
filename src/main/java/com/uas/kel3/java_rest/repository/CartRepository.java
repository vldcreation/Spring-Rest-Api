package com.uas.kel3.java_rest.repository;

import com.uas.kel3.java_rest.model.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	@Query("select c from Cart c where c.id_user = ?1")
	List<Cart> findAllById_user(Integer id_user);
	
	@Modifying
	@Query("delete from Cart c where c.id_user = ?1")
	void deleteAllCartByUserId(Integer id_user);
}
