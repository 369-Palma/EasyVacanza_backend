package com.palma.gestioneeasyvacanza.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.palma.gestioneeasyvacanza.model.Attivita;
import com.palma.gestioneeasyvacanza.model.Difficolta;
import com.palma.gestioneeasyvacanza.model.TipoAttivita;
import com.palma.gestioneeasyvacanza.repository.AttivitaRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AttivitaService {

	@Autowired AttivitaRepository repo;
	@Autowired @Qualifier("AttivitaRandom") private ObjectProvider <Attivita> randomAttivitaProvider;
	
	public Attivita createAttivitaRandom() {
		return createAttivita(randomAttivitaProvider.getObject());
	}
	
	//METODI STANDARD PER API
	
			public List<Attivita> getAllAttivita() {
				return (List<Attivita>) repo.findAll();
			}
			
			public Page<Attivita> getAllAttivitaPageable(Pageable pageable) {
				return (Page<Attivita>) repo.findAll(pageable);
			}
			
			public Attivita getAttivita(Long id) {
				if(!repo.existsById(id)) {
					throw new EntityNotFoundException("Attivita not exists!!!");
				}
				return repo.findById(id).get();
			}
			
			public Attivita getAttivitaRandom() {
				return repo.findByAttivitaRandom();
			}
			
			public Attivita createAttivita(Attivita attivita) {
				if(attivita.getId()!= null && repo.existsById(attivita.getId())) {
					throw new EntityExistsException("Partita iva exists!!!");
				} else {
					repo.save(attivita);
				}		
				return attivita;
			}
			
			public String removeAttivita(Long id) {
				if(!repo.existsById(id)) {
					throw new EntityExistsException("Attivita not exists!!!");
				}
				repo.deleteById(id);
				return "Attivita Deleted!!!";
			}
			
			public Attivita updateAttivita(Attivita attivita) {
				if(!repo.existsById(attivita.getId())) {
					throw new EntityExistsException("Attivita not exists!!!");
				}
				repo.save(attivita);
				return attivita;
			}
			
			// METODI SPECIALI (FILTRA PER: ATTIVITA', DIFFICOLTA' E PAROLA CHIAVE) 
			
			public Page<Attivita> filtaPerAttivita (TipoAttivita attivita, Pageable page) {
				if(!repo.existsByAttivita(attivita)) {
					throw new EntityExistsException("Non sono disponibili attività di tipo:  " + attivita);
				}
				return repo.searchByAttivita(attivita, page);
			}
			
			public Page<Attivita> filtaPerDifficolta (Difficolta difficolta, Pageable pag) {
				if(repo.existsByDifficolta(difficolta)){
					throw new EntityExistsException("Non sono disponibili attività con livello di difficoltà " + difficolta);
				}
				return repo.findByDifficolta(difficolta, pag);				
			}
			
			public Page<Attivita> getAllAttivitaByDescrizione(String descrizione, Pageable page){			
				if(repo.existsByDescrizione(descrizione)) {
					throw new EntityExistsException("Non sono disponibili attività di tipo " + descrizione);
				}
				return (Page<Attivita>) repo.searchByDescrizione(descrizione, page);
			}
			
}
