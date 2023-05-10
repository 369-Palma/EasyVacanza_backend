package com.palma.gestioneeasyvacanza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.palma.gestioneeasyvacanza.model.Prenotazione;
import com.palma.gestioneeasyvacanza.service.PrenotazioneService;

@Controller
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

	 @Autowired PrenotazioneService service;
	 
	 @GetMapping
		@PreAuthorize("isAuthenticated()")
		public ResponseEntity<?> getAll() {
			return new ResponseEntity<List<Prenotazione>>(service.getAllPrenotazione(), HttpStatus.OK);
		}

		@GetMapping("/pageable")
		@PreAuthorize("isAuthenticated()")
		public ResponseEntity<Page<Prenotazione>> getAllPage(Pageable pag) {
			return new ResponseEntity<Page<Prenotazione>>(service.getAllPrenotazionePageable(pag), HttpStatus.OK);
		}

		@GetMapping("/id/{id}")
		@PreAuthorize("isAuthenticated()")
		public ResponseEntity<?> getById(@PathVariable("id") Long id) {
			return new ResponseEntity<>(service.getPrenotazione(id), HttpStatus.OK);
		}
			
		@PostMapping
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<?> createPrentazione(@RequestBody Prenotazione prenotazione) {
			return new ResponseEntity<Prenotazione>(service.createPrenotazione(prenotazione), HttpStatus.CREATED);
		}
		@DeleteMapping("/{id}")
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<String> deleteVacanza(@PathVariable Long id){
			return new ResponseEntity<String>(service.removePrenotazione(id), HttpStatus.OK);
		}
		@PutMapping
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<?> updateUser(@RequestBody Prenotazione prenotazione) {
			return new ResponseEntity<Prenotazione>(service.updatePrenotazione(prenotazione), HttpStatus.CREATED);
		}

	 //SPECIALI
		@GetMapping("/numero_prenotazione/{numeroprenotazione}")
		@PreAuthorize("isAuthenticated()")
		public ResponseEntity<?> getByPrenotazione(@PathVariable("numeroprenotazione") Long numeroprenotazione) {
			return new ResponseEntity<>(service.getByNumeroprenotazione(numeroprenotazione), HttpStatus.OK);
		}
}
