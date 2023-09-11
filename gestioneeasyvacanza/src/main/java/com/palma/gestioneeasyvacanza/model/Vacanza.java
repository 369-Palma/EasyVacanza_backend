 package com.palma.gestioneeasyvacanza.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@Table(name="vacanze")
public class Vacanza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String citta;
	@Column(nullable = false)
	private String indirizzo;
	@Column(nullable = false)
	private String descrizione;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipologiaLuogo tipoluogo;
	@Column(nullable = false, columnDefinition = "TEXT")
	private String immagineurl;	
	@Column(nullable = false)
	private String duratagiorni;
	@Column(nullable = false)
	private LocalDate datainizio;
	@Column(nullable = false)
	private LocalDate datafine;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoAlloggio alloggio;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Preferenze preferenza;
	@Column(nullable = false)
	private Double prezzo;
	@Column(nullable = false)
    private int numeroMax;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "vacanze_attivita",
     joinColumns = @JoinColumn(name = "vacanze_id", referencedColumnName = "id"),
     inverseJoinColumns = @JoinColumn(name = "attivita_id", referencedColumnName = "id")
	)
	//@JsonIgnore
	private List<Attivita> attivita;
	
	@JsonIgnore
	@OneToMany(mappedBy = "vacanza")
	private List<Prenotazione> prenotazioni;
	
	
	//metodo per verifica disponibilità posti
	public String prenota(int numeroOspiti) {
	    if (numeroOspiti > 0 && numeroOspiti <= getNumeroPostiDisponibili()) {
	        Prenotazione prenotazione = new Prenotazione();
	        prenotazione.setNumerospiti(numeroOspiti);
	        prenotazione.setStato(StatoPrenotazione.IN_ELABORAZIONE); 

	        if (prenotazioni == null) {
	            prenotazioni = new ArrayList<Prenotazione>();
	        }

	        prenotazioni.add(prenotazione);
	        return "Sould out";
	    }
	    return "Prenotazione non valida";
	}
	
	public int getNumeroOspitiPrenotati() {
		if(prenotazioni == null) {
			return 0;
		}
		return prenotazioni.stream().mapToInt(Prenotazione::getNumerospiti).sum();
	}
	
	public int getNumeroPostiDisponibili() {
        return numeroMax - getNumeroOspitiPrenotati();
    }
}
