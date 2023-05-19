package com.palma.gestioneeasyvacanza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palma.gestioneeasyvacanza.model.Testimonianza;
import com.palma.gestioneeasyvacanza.service.TestimonianzaService;

@CrossOrigin(origins =  "*", maxAge = 360000)
@RestController
@RequestMapping("/api/testimonianze")
public class TestimonianzaController {

	@Autowired TestimonianzaService service;
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Testimonianza>>(service.getAllTestimonianza(), HttpStatus.OK);
	}

	@GetMapping("/pageable")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Page<Testimonianza>> getAllPage(Pageable pag) {
		return new ResponseEntity<Page<Testimonianza>>(service.getAllTestimonianzaPageable(pag), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.getTestimonianza(id), HttpStatus.OK);
	}
		
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createTestimonianza(@RequestBody Testimonianza testimonianza) {
		return new ResponseEntity<Testimonianza>(service.createTestimonianza(testimonianza), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteTestimonianza(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeTestimonianza(id), HttpStatus.OK);
	}
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateUser(@RequestBody Testimonianza testimonianza) {
		return new ResponseEntity<Testimonianza>(service.updateTestimonianza(testimonianza), HttpStatus.CREATED);
	}

	//SPECIALI
	@GetMapping("/rating/{rate}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getByDifficolta(@PathVariable Integer rate, Pageable pag) {
		return new ResponseEntity<Page<Testimonianza>>(service.getByRate(rate, pag), HttpStatus.OK);
	}

}
