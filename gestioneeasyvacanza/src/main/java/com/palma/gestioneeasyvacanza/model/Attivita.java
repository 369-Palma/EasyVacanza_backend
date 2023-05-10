package com.palma.gestioneeasyvacanza.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
@Table(name="attivita")
public class Attivita {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String descrizione;
	@Column(nullable = false)
	private Difficolta difficolta;
	
	@ManyToMany
	private List<Vacanza> vacanze;
	
	@OneToMany(mappedBy = "attivita", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"attivita"})
	private List<Testimonianza> testimonianze;
}
