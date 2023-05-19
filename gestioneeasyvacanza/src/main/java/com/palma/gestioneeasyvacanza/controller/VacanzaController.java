package com.palma.gestioneeasyvacanza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.palma.gestioneeasyvacanza.model.Preferenze;
import com.palma.gestioneeasyvacanza.model.TipoAlloggio;
import com.palma.gestioneeasyvacanza.model.TipologiaLuogo;
import com.palma.gestioneeasyvacanza.model.Vacanza;
import com.palma.gestioneeasyvacanza.service.VacanzaService;

@CrossOrigin(origins =  "*", maxAge = 360000)
@Controller
@RequestMapping("/api/vacanze")
public class VacanzaController {

	@Autowired VacanzaService service;
	
	@GetMapping
	
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Vacanza>>(service.getAllVacanza(), HttpStatus.OK);
	}

	@GetMapping("/pageable")
	
	public ResponseEntity<Page<Vacanza>> getAllPage(Pageable pag) {
		return new ResponseEntity<Page<Vacanza>>(service.getAllVacanzaPageable(pag), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.getVacanza(id), HttpStatus.OK);
	}
		
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createVacanza(@RequestBody Vacanza vacanza) {
		return new ResponseEntity<Vacanza>(service.createVacanza(vacanza), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteVacanza(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeVacanza(id), HttpStatus.OK);
	}
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateUser(@RequestBody Vacanza vacanza) {
		return new ResponseEntity<Vacanza>(service.updateVacanza(vacanza), HttpStatus.CREATED);
	}

	//SPECIALI
	@GetMapping("/tipoluogo/{luogo}")
	
	public ResponseEntity<?> getByTipoLuogo(@PathVariable TipologiaLuogo luogo, Pageable pag) {
		return new ResponseEntity<Page<Vacanza>>(service.getByLuogo(luogo, pag), HttpStatus.OK);
	}
	
	@GetMapping("/alloggio/{alloggio}")
	
	public ResponseEntity<?> getByTipoLuogo(@PathVariable TipoAlloggio alloggio, Pageable pag) {
		return new ResponseEntity<Page<Vacanza>>(service.getByAlloggio(alloggio, pag), HttpStatus.OK);
	}
	
	@GetMapping("/preferenza/{preferenza}")
	
	public ResponseEntity<?> getByTipoPreferenza(@PathVariable Preferenze preferenza, Pageable pag) {
		return new ResponseEntity<Page<Vacanza>>(service.getByPreferenza(preferenza, pag), HttpStatus.OK);
	}
}
