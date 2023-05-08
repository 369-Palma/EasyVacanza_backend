package com.palma.gestioneeasyvacanza.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@Table(name="clienti")
public class Cliente {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private Integer age;
	@ManyToMany(mappedBy = "clienti", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"cliente"})
	private List<Prenotazione> prenotazioni;
	
	@OneToMany(mappedBy = "cliente")
	private List<Testimonianza> testimonianze;
}
