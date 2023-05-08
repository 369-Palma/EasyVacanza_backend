package com.palma.gestioneeasyvacanza.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name="prenotazioni")
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataprenotazione;
	private Integer numerospiti;
	@Enumerated(EnumType.STRING)
	private StatoPrenotazione stato;
	
	private Vacanza vacanza;
	@ManyToMany(mappedBy = "prenotazione", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"prenotazione"})
	private List <Cliente> cliente;
}
