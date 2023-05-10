package com.palma.gestioneeasyvacanza.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.palma.gestioneeasyvacanza.model.Preferenze;
import com.palma.gestioneeasyvacanza.model.TipoAlloggio;
import com.palma.gestioneeasyvacanza.model.TipologiaLuogo;
import com.palma.gestioneeasyvacanza.model.Vacanza;


@Repository
public interface VacanzaRepository extends JpaRepository<Vacanza, Long> {

	
	@Query(value="SELECT v FROM Vacanza v ORDER BY RANDOM() LIMIT 1")
	Vacanza findPerVacanzaRandom();
	
	boolean existsByTipoluogo(TipologiaLuogo tipoluogo);
	boolean existsByAlloggio(TipoAlloggio alloggio);
	boolean existsByPreferenza(Preferenze preferenza);
	
	 @Query("SELECT v FROM Vacanza v WHERE v.tipoluogo = :luogo")
	    Page<Vacanza> findByTipoluogo(@Param("luogo") TipologiaLuogo luogo, Pageable page);

	//filtro per TipoAlloggio
	 @Query("SELECT v FROM Vacanza v WHERE v.alloggio = :alloggio")
		public Page<Vacanza> FindByAlloggio(TipoAlloggio alloggio, Pageable page);	
		
	//filtro per Preferenze
	 @Query("SELECT v FROM Vacanza v WHERE v.preferenza = :preferenza")
		public Page<Vacanza> FindByPreferenza(Preferenze preferenza, Pageable page);

		
}
