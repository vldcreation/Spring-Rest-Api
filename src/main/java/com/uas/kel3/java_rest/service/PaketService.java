package com.uas.kel3.java_rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uas.kel3.java_rest.model.Paket;
import com.uas.kel3.java_rest.repository.PaketRepository;

@Service
@Transactional
public class PaketService {
	
	@Autowired
	PaketRepository paketRepository;
	
	public List<Paket> listAllPaket(){
		return paketRepository.findAll();
	}
	
	public Paket savePaket(Paket paket) {
		return paketRepository.save(paket);
	}
	
	public Paket getPaket(Integer id) {
		return paketRepository.findById(id).get();
	}
	
	public void deletePaket(Integer id) {
		paketRepository.deleteById(id); // handling using try catch in Controller
	}
	
	
	

}
