package com.palma.gestioneeasyvacanza.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.palma.gestioneeasyvacanza.model.Attivita;
import com.palma.gestioneeasyvacanza.model.Difficolta;
import com.palma.gestioneeasyvacanza.model.TipoAttivita;

@Repository
public interface AttivitaRepository extends JpaRepository<Attivita, Long> {

	@Query(value="SELECT a FROM Attivita a ORDER BY RANDOM() LIMIT 1")
	Attivita findByAttivitaRandom();
	
	public boolean existsByDifficolta(Difficolta difficolta);
	public boolean existsByDescrizione(String descrizione);
	public boolean existsByAttivita(TipoAttivita attivita);
	
	//FILTRO PER TIPO DI ATTIVITA'
	@Query("SELECT a FROM Attivita a WHERE a.attivita = :attivita")
	public Page<Attivita> searchByAttivita(TipoAttivita attivita, Pageable page);
	
	//FILTRO PER LIVELLO DI FIFFICOLTA'
	public Page<Attivita> findByDifficolta(Difficolta difficolta, Pageable pag);
	
	//FILTRO PER PAROLE CHIAVE NELLA DESCRIZIONE
	@Query("SELECT a FROM Attivita a WHERE LOWER(a.descrizione) LIKE LOWER('%' || :descrizione || '%')")
	public Page<Attivita> searchByDescrizione(String descrizione, Pageable page);
	
}
