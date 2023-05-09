package com.palma.gestioneeasyvacanza.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.palma.gestioneeasyvacanza.model.Attivita;
import com.palma.gestioneeasyvacanza.model.Preferenze;
import com.palma.gestioneeasyvacanza.model.TipoAlloggio;
import com.palma.gestioneeasyvacanza.model.TipologiaLuogo;
import com.palma.gestioneeasyvacanza.model.Vacanza;


@Repository
public interface VacanzaRepository extends JpaRepository<Vacanza, Long> {

	@Query(value="SELECT v FROM Vacanza v ORDER BY RANDOM() LIMIT 1")
	Vacanza findByVacanzaRandom();
	
	boolean existsByTipologia(TipologiaLuogo luogo);
	boolean existsByAlloggio(TipoAlloggio alloggio);
	boolean existsByPreferenza(Preferenze preferenza);
		
	//filtro per tipologiaLuogo
		public Page<Vacanza> FindByTipologia(TipologiaLuogo luogo, Pageable page);	

	//filtro per TipoAlloggio
		public Page<Vacanza> FindByAlloggio(TipoAlloggio alloggio, Pageable page);	
		
	//filtro per Preferenze
		public Page<Vacanza> FindByPreferenza(Preferenze preferenza, Pageable page);

		
}
