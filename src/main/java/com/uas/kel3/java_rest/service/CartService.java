package com.uas.kel3.java_rest.service;

import com.uas.kel3.java_rest.model.Cart;
import com.uas.kel3.java_rest.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CartService {
@Autowired
 private CartRepository cartRepository;

public List<Cart> listAllCart() {
	return cartRepository.findAll();
 }

 public Cart saveCart(Cart cart) {
	 return cartRepository.save(cart);
 }
 
 public Cart getCart(Integer id) {
	 return cartRepository.findById(id).get();
 }
 
 public void deleteCart(Integer id) {
	 cartRepository.deleteById(id);
 }
}
