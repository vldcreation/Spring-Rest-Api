package com.uas.kel3.java_rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uas.kel3.java_rest.model.Booking;
import com.uas.kel3.java_rest.repository.BookingRepository;

@Service
@Transactional
public class BookingService {
	@Autowired
	BookingRepository bookingRepository;
	
	public List<Booking> listAllBooking(){
		return bookingRepository.findAll();
	}
	
	public Booking getBooking(Integer id) {
		return bookingRepository.findById(id).get();
	}
	
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	public void deleteBooking(Integer id) {
		bookingRepository.deleteById(id);
	}
}
