package com.uas.kel3.java_rest.controller;

import com.uas.kel3.java_rest.model.*;

import com.uas.kel3.java_rest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	CartService cartService;
	@GetMapping("")
	public List<Cart> list() {
		return cartService.listAllCart();
 }

 @GetMapping("/{id}")
 public ResponseEntity<Cart> get(@PathVariable Integer id) {
	 try {
		 Cart cart = cartService.getCart(id);
		 return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	 } catch (NoSuchElementException e) {
		 return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
	 }
 }

 @PostMapping("")
 public Cart add(@RequestBody Cart cart) {
	 Cart newCategory = new Cart(
			 cart.getId(),
			 cart.getId_user(),
			 cart.getId_product(),
			 cart.getJlh(),
			 cart.getHarga(),
			 new Date(),
			 cart.getUpdated_at()
			 );
	 return cartService.saveCart(newCategory);
 }

 @PutMapping("/{id}")
 public ResponseEntity<?> update(@RequestBody Cart cart, @PathVariable
Integer id) {
	 try {
		// User existUser = userService.getUser(id);
		 cart.setId(id);
		 cartService.saveCart(cart);
	 	return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	 } catch (NoSuchElementException e) {
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
 }

 @DeleteMapping("/{id}")
 public void delete(@PathVariable Integer id) {
	 cartService.deleteCart(id);
 }

}
