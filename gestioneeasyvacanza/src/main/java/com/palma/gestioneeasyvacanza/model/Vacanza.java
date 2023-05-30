 package com.palma.gestioneeasyvacanza.model;

import java.time.LocalDate;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "vacanze_attivita",
     joinColumns = @JoinColumn(name = "vacanze_id", referencedColumnName = "id"),
     inverseJoinColumns = @JoinColumn(name = "attivita_id", referencedColumnName = "id")
	)
	//@JsonIgnore
	private List<Attivita> attivita;
	
	@JsonIgnore
	@OneToOne(mappedBy = "vacanza")
	private Prenotazione prenotazione;
}
