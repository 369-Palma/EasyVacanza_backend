package com.palma.gestioneeasyvacanza.model;

import java.util.Locale;
import com.github.javafaker.Faker;

public enum StatoPrenotazione {
	CONFERMATO,
	IN_ELABORAZIONE,
	ANNULLATA;
	
	public static StatoPrenotazione StatoRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		int size = StatoPrenotazione.values().length;
		int position = fake.number().numberBetween(0, size);
		return StatoPrenotazione.values()[position];
	}
	
}
