package com.palma.gestioneeasyvacanza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palma.gestioneeasyvacanza.model.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long>{

}
