package com.palma.gestioneeasyvacanza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palma.gestioneeasyvacanza.model.Attivita;
import com.palma.gestioneeasyvacanza.model.Difficolta;
import com.palma.gestioneeasyvacanza.model.TipoAttivita;
import com.palma.gestioneeasyvacanza.service.AttivitaService;

@RestController
@RequestMapping("/api/attivita")
public class AttivitaController {

@Autowired AttivitaService service;

@GetMapping
@PreAuthorize("isAuthenticated()")
public ResponseEntity<?> getAll() {
	return new ResponseEntity<List<Attivita>>(service.getAllAttivita(), HttpStatus.OK);
}

@GetMapping("/pageable")
@PreAuthorize("isAuthenticated()")
public ResponseEntity<Page<Attivita>> getAllPage(Pageable pag) {
	return new ResponseEntity<Page<Attivita>>(service.getAllAttivitaPageable(pag), HttpStatus.OK);
}

@GetMapping("/id/{id}")
@PreAuthorize("isAuthenticated()")
public ResponseEntity<?> getById(@PathVariable("id") Long id) {
	return new ResponseEntity<>(service.getAttivita(id), HttpStatus.OK);
}
	
@PostMapping
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<?> createAttivita(@RequestBody Attivita attivita) {
	return new ResponseEntity<Attivita>(service.createAttivita(attivita), HttpStatus.CREATED);
}

@DeleteMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<String> deleteAttivita(@PathVariable Long id){
	return new ResponseEntity<String>(service.removeAttivita(id), HttpStatus.OK);
}

@PutMapping
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<?> updateUser(@RequestBody Attivita attivita) {
	return new ResponseEntity<Attivita>(service.updateAttivita(attivita), HttpStatus.CREATED);
}

//SPECIALI
@GetMapping("/attivita/{attivita}")
@PreAuthorize("isAuthenticated()")
public ResponseEntity<?> getBy(@PathVariable TipoAttivita attivita, Pageable pag) {
	return new ResponseEntity<Page<Attivita>>(service.filtaPerAttivita(attivita, pag), HttpStatus.OK);
}

@GetMapping("/difficolta/{difficolta}")
@PreAuthorize("isAuthenticated()")
public ResponseEntity<?> getByDifficolta(@PathVariable Difficolta difficolta, Pageable pag) {
	return new ResponseEntity<Page<Attivita>>(service.filtaPerDifficolta(difficolta, pag), HttpStatus.OK);
}

@GetMapping("/partedescrizione/{descrizione}")
@PreAuthorize("isAuthenticated()")
public ResponseEntity<?> getByDescrizione(@PathVariable("descrizione") String descrizione, Pageable page) {
	return new ResponseEntity<Page<Attivita>>(service.getAllAttivitaByDescrizione(descrizione, page), HttpStatus.OK);
}

}