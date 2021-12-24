package com.uas.kel3.java_rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uas.kel3.java_rest.model.Order;
import com.uas.kel3.java_rest.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	@Autowired
	public OrderRepository orderRepository;
	
	public List<Order> listAllOrder(){
		return orderRepository.findAll();
	}
	
	public Order getOrder(Integer id) {
		return orderRepository.findById(id).get();
	}
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public void deleteOrder(Integer id) {
		orderRepository.deleteById(id);
	}
}
