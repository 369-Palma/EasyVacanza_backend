package com.palma.gestioneeasyvacanza.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.palma.gestioneeasyvacanza.model.Preferenze;
import com.palma.gestioneeasyvacanza.model.TipoAlloggio;
import com.palma.gestioneeasyvacanza.model.TipologiaLuogo;
import com.palma.gestioneeasyvacanza.model.Vacanza;
import com.palma.gestioneeasyvacanza.repository.VacanzaRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class VacanzaService {

	@Autowired VacanzaRepository repo;
	@Autowired @Qualifier("VacanzaRandom") private ObjectProvider <Vacanza> vacanzaProvider;
	// Per creare una nuova Vacanza
	
				public void createVacanzaRandom() {		
				 createVacanza(vacanzaProvider.getObject());
				}
				
				//METODI STANDARD PER API
				
				public List<Vacanza> getAllVacanza() {
					return (List<Vacanza>) repo.findAll();
				}
				
				public Page<Vacanza> getAllVacanzaPageable(Pageable pageable) {
					return (Page<Vacanza>) repo.findAll(pageable);
				}
				
				
				public Vacanza getVacanza(Long id) {
					if(!repo.existsById(id)) {
						throw new EntityNotFoundException("La Vacanza con id " + id + " non è presente del database!!!");
					}
					return repo.findById(id).get();
				}
				
				public Vacanza getVacanzaRandom() {
					return repo.findPerVacanzaRandom();
				}
				
				public Vacanza getVacanzaById(Long id) {
					return repo.findById(id).get();
				}
				
				public Vacanza createVacanza(Vacanza vacanza) {
					if(vacanza.getId()!=null && repo.existsById(vacanza.getId())) {
						throw new EntityExistsException(" " );
					} else {
						repo.save(vacanza);
					}		
					return vacanza;
				}
				
				public String removeVacanza(Long id) {
					if(!repo.existsById(id)) {
						throw new EntityExistsException("La Vacanza con id " + id + " non è presente del database!");
					}
					repo.deleteById(id);
					return "Vacanza Deleted!!!";
				}
				
				public Vacanza updateVacanza(Vacanza vacanza) {
					if(!repo.existsById(vacanza.getId())) {
						throw new EntityExistsException("La Vacanza non è presente del database!");
					}
					repo.save(vacanza);
					return vacanza;
				}
				
				//Metodi speciali
				
				public Page<Vacanza> getByLuogo(TipologiaLuogo luogo, Pageable pag){
					if(!repo.existsByTipoluogo(luogo)) {
						throw new EntityExistsException("Non ci sono vacanze per la tipologia " + luogo);
					}
					return repo.findByTipoluogo(luogo, pag);
				}
				
				public Page<Vacanza> getByAlloggio(TipoAlloggio alloggio, Pageable pag){
					if(!repo.existsByAlloggio(alloggio)) {
						throw new EntityExistsException("Non ci sono vacanze per la tipologia di alloggio  " + alloggio);
					}
					return repo.FindByAlloggio(alloggio, pag);
				}
				
				public Page<Vacanza> getByPreferenza(Preferenze preferenza, Pageable pag){
					if(!repo.existsByPreferenza(preferenza)) {
						throw new EntityExistsException("Non ci sono vacanze per " + preferenza);
					}
					return repo.FindByPreferenza(preferenza, pag);
				}
}
