package com.uas.kel3.java_rest.controller;

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
import com.uas.kel3.java_rest.model.Paket;

import com.uas.kel3.java_rest.service.PaketService;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pakets")
public class PaketController {
	@Autowired
	PaketService paketService;
	
	@GetMapping("")
	public List<Paket> listPaket(){
		return paketService.listAllPaket();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paket> getPaket(@PathVariable Integer id) {
		try {
			Paket paket = paketService.getPaket(id);
			return new ResponseEntity<Paket>(paket,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Paket>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public Paket addPaket(@RequestBody Paket paket) {
		Paket newPaket = new Paket(
					paket.getId(),
					paket.getId_user(),
					paket.getId_product(),
					paket.getAlamat_pengirim(),
					paket.getAlamat_tujuan(),
					paket.getNohp_tujuan(),
					paket.getKurir(),
					paket.getHarga(),
					new Date(),
					paket.getUpdated_at()
				);
		
		return paketService.savePaket(newPaket);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paket> updatePaket(@RequestBody Paket paket,@PathVariable Integer id){
		try {
			paket.setId(id);
			paketService.savePaket(paket);
			return new ResponseEntity<Paket>(paket,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Paket>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletePaket(@PathVariable Integer id){
		try {
			paketService.deletePaket(id);
			return new ResponseEntity<Boolean>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
