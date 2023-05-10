package com.palma.gestioneeasyvacanza.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.palma.gestioneeasyvacanza.model.Prenotazione;
import com.palma.gestioneeasyvacanza.repository.PrenotazioneRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PrenotazioneService {

	@Autowired PrenotazioneRepository repo;
	@Autowired @Qualifier("PrenotazioneRandom") private ObjectProvider<Prenotazione> prenotazioneService;
	
	// Per creare una nuova Prenotazione
	
	public void createPrenotazioneRandom() {		
	 createPrenotazione(prenotazioneService.getObject());
	}
	
	//METODI STANDARD PER API
	
	public List<Prenotazione> getAllPrenotazione() {
		return (List<Prenotazione>) repo.findAll();
	}
	
	public Page<Prenotazione> getAllPrenotazionePageable(Pageable pageable) {
		return (Page<Prenotazione>) repo.findAll(pageable);
	}
	
	
	public Prenotazione getPrenotazione(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("La Prenotazione con id " + id + " non è presente del database!!!");
		}
		return repo.findById(id).get();
	}
	
	public Prenotazione getPrenotazioneRandom() {
		return repo.findByPrenotazioneRandom();
	}
	
	public Prenotazione createPrenotazione(Prenotazione prenotazione) {
		if(prenotazione.getId() != null && repo.existsByNumeroprenotazione(prenotazione.getNumeroprenotazione())) {
			throw new EntityExistsException(" " );
		} else {
			repo.save(prenotazione);
		}		
		return prenotazione;
	}
	
	public String removePrenotazione(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("La Prenotazione con id " + id + " non è presente del database!");
		}
		repo.deleteById(id);
		return "Prenotazione Deleted!!!";
	}
	
	public Prenotazione updatePrenotazione(Prenotazione prenotazione) {
		if(!repo.existsById(prenotazione.getId())) {
			throw new EntityExistsException("La Prenotazione non è presente del database!");
		}
		repo.save(prenotazione);
		return prenotazione;
	}
	
	//Metodi speciali
	
	public Prenotazione getByNumeroprenotazione(Long numeroprenotazione) {
		if(!repo.existsByNumeroprenotazione(numeroprenotazione)) {
			throw new EntityExistsException("Non ci sono prenotazioni con numero di prenotazione  " + numeroprenotazione);
		} 
		return repo.FindByNumeroprenotazione(numeroprenotazione);
	}
}
