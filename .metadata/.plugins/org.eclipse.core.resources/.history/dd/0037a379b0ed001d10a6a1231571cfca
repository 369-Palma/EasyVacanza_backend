package com.palma.gestioneeasyvacanza.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.palma.gestioneeasyvacanza.auth.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="testimonianze")
public class Testimonianza {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private User user;
	@Column(nullable = false)
	private String feedback;
	
	@ManyToOne
	@JsonIgnoreProperties({"testimonianze"})
	private Attivita attivita;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
}
