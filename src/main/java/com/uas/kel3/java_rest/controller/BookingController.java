package com.uas.kel3.java_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uas.kel3.java_rest.model.Booking;
import java.util.List;
import java.util.Date;
import java.util.NoSuchElementException;

import com.uas.kel3.java_rest.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	@GetMapping("")
	public List<Booking> listAllBooking(){
		return bookingService.listAllBooking();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Booking>  getBooking(@PathVariable Integer id){
		try {
			Booking booking = bookingService.getBooking(id);
			return new ResponseEntity<Booking>(booking,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public Booking saveBooking(@RequestBody Booking booking){
		Booking newBooking = new Booking(
				booking.getId(),
				booking.getId_user(),
				booking.getId_room(),
				booking.getStart_at(),
				booking.getEnd_at(),
				booking.getKeperluan(),
				booking.getDeskripsi(),
				new Date(),
				booking.getUpdated_at()
				);
		return bookingService.saveBooking(newBooking);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking, @PathVariable Integer id){
		try {
			booking.setId(id);
			return new ResponseEntity<Booking>(booking,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<Booking>(booking, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBooking(@PathVariable Integer id){
		try {
			bookingService.deleteBooking(id);
			return new ResponseEntity<Boolean>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
	}
	
}
