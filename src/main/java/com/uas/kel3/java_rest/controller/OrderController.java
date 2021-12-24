package com.uas.kel3.java_rest.controller;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uas.kel3.java_rest.model.Order;
import com.uas.kel3.java_rest.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("")
	public List<Order> listAllOrder(){
		return orderService.listAllOrder();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order>  getBooking(@PathVariable Integer id){
		try {
			Order order= orderService.getOrder(id);
			return new ResponseEntity<Order>(order,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public Order saveBooking(@RequestBody Order order){
		Order newOrder = new Order(
				order.getId(),
				order.getCategory(),
				order.getId_product(),
				order.getId_user(),
				order.getEmail_user(),
				new Date(),
				order.getUpdated_at()
				);
		return orderService.saveOrder(newOrder);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateBooking(@RequestBody Order order, @PathVariable Integer id){
		try {
			order.setId(id);
			return new ResponseEntity<Order>(order,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<Order>(order, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBooking(@PathVariable Integer id){
		try {
			orderService.deleteOrder(id);
			return new ResponseEntity<Boolean>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
	}
}
