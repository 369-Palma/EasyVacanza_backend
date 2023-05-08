package com.palma.gestioneeasyvacanza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.palma.gestioneeasyvacanza.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	public boolean existsByEmail(String email);
	//public boolean existsByNumeroprenotazione(Long numeroPrenotazione);
	
	@Query(value="SELECT c FROM Cliente c ORDER BY RANDOM() LIMIT 1")
	Cliente findByClienteRandom();
	
	@Query(value = "SELECT c FROM Cliente c JOIN c.prenotazioni p WHERE p.numeroprenotazione = :numeroPrenotazione")
	Cliente filtraPerNumeroPrenotazione(@Param("numeroPrenotazione") Long numeroPrenotazione);

	
}
