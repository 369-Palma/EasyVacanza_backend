package com.palma.gestioneeasyvacanza.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.palma.gestioneeasyvacanza.model.Testimonianza;

@Repository
public interface TestimonianzaRepository extends JpaRepository<Testimonianza, Long> {
	
	@Query(value="SELECT t FROM Testimonianza t ORDER BY RANDOM() LIMIT 1")
	Testimonianza findByTestimonianzaRandom();
	
	public boolean existsByEmail(String email);
	public boolean existsByRating(Integer rating);
	
	public Page<Testimonianza> findByRating(Integer rating, Pageable pag);
}
