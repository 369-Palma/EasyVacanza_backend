package com.palma.gestioneeasyvacanza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.palma.gestioneeasyvacanza.model.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	public boolean existsByNumeroprenotazione(Long numeroprenotazione);
	
	@Query(value="SELECT p FROM Prenotazione p ORDER BY RANDOM() LIMIT 1")
	Prenotazione findByPrenotazioneRandom();
	
	@Query("SELECT p FROM Prenotazione p WHERE p.numeroprenotazione = :numeroprenotazione")
	public Prenotazione FindByNumeroprenotazione(Long numeroprenotazione);
	
	
}
