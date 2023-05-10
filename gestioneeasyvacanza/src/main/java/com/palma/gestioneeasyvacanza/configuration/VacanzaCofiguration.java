package com.palma.gestioneeasyvacanza.configuration;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.text.DecimalFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.palma.gestioneeasyvacanza.model.Preferenze;
import com.palma.gestioneeasyvacanza.model.TipoAlloggio;
import com.palma.gestioneeasyvacanza.model.TipologiaLuogo;
import com.palma.gestioneeasyvacanza.model.Vacanza;
import com.palma.gestioneeasyvacanza.service.AttivitaService;
import com.palma.gestioneeasyvacanza.service.PrenotazioneService;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

@Configuration
public class VacanzaCofiguration {

	@Autowired AttivitaService attivitaService;
	@Autowired PrenotazioneService prenotazioneService;
	@Bean("VacanzaRandom")
	@Scope("prototype")
	
	public Vacanza VacanzaRandom() throws IOException {
		Faker fake = new Faker(new Locale("it-IT"));
		//per generare prezzo casuale di tipo Double
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double price = fake.random().nextDouble() * 1000.0; // Genera un prezzo casuale tra 0 e 1000
        //creare immagine url di un immagine casuale partendo da una parola chiave
		 OkHttpClient client = new OkHttpClient();
	        String keyword = "landscape"; // Parola chiave per l'immagine casuale  
	            String url = "https://source.unsplash.com/800x600/?"+ keyword;
	            Request request = new Request.Builder()
	                    .url(url)
	                    .build();
	            Response response = client.newCall(request).execute();
	            String imageUrl = response.request().url().toString();
	    //per descrizione
	            String durata = fake.number().numberBetween(3, 10) + " giorni";
	            String nazione = fake.country().name();
		return Vacanza.builder()
				.citta(fake.country().capital())
				.nazione(fake.country().name())
				.indirizzo(fake.address().city())
				.descrizione(durata + " da sogno in " + nazione + "." )
				.immagineurl(imageUrl)
				.tipoluogo(TipologiaLuogo.TipoLuogoRandom())
				.duratagiorni(durata)
				.datainizio(LocalDate.of(fake.number().numberBetween(2021, 2022),fake.number().numberBetween(1, 12), fake.number().numberBetween(1, 28)))
				.datafine(LocalDate.of(fake.number().numberBetween(2021, 2022),fake.number().numberBetween(1, 12), fake.number().numberBetween(1, 28)))
				.alloggio(TipoAlloggio.AlloggioRandom())
				.preferenza(Preferenze.PreferenzaRandom())
				.prezzo(price)
				//.attivita((List<Attivita>) attivitaService.getAttivitaRandom())
				.attivita(null)
				.prenotazione(null)
				.build();
	}
}
