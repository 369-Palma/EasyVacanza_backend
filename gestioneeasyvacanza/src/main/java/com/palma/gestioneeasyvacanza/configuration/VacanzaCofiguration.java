package com.palma.gestioneeasyvacanza.configuration;

import java.io.IOException;

import java.util.Locale;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.palma.gestioneeasyvacanza.model.Attivita;
import com.palma.gestioneeasyvacanza.model.Preferenze;
import com.palma.gestioneeasyvacanza.model.TipoAlloggio;
import com.palma.gestioneeasyvacanza.model.TipologiaLuogo;
import com.palma.gestioneeasyvacanza.model.Vacanza;
import com.palma.gestioneeasyvacanza.service.AttivitaService;
import com.palma.gestioneeasyvacanza.service.PrenotazioneService;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//import org.json.JSONArray;
//import org.json.JSONObject;

@Configuration
public class VacanzaCofiguration {
private TipologiaLuogo luogo;
//private String keyword = luogo.toString();

	@Autowired AttivitaService attivitaService;
	@Autowired PrenotazioneService prenotazioneService;
	@Bean("VacanzaRandom")
	@Scope("prototype")
	
	public Vacanza VacanzaRandom() throws IOException {
		
		Faker fake = new Faker(new Locale("it-IT"));
		luogo = TipologiaLuogo.TipoLuogoRandom();
		//per generare prezzo casuale di tipo Double
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
       // double price = fake.random().nextDouble() * 270.0; // Genera un prezzo casuale tra 0 e 1000
        double price = fake.number().randomDouble(2, 200, 900);
	    //per descrizione
        Integer durataGiorni = fake.number().numberBetween(3, 15);
        String durata = durataGiorni + " giorni";
        String citta = fake.country().capital();
	            
	    //per data fine e durata vacanza
        LocalDate dataInizio = LocalDate.of(fake.number().numberBetween(2023, 2025),fake.number().numberBetween(1, 12), fake.number().numberBetween(1, 28));
        LocalDate dataFine = dataInizio.plusDays(durataGiorni);
        
        List<Attivita> list = new ArrayList<>();
        list.add(attivitaService.getAttivitaRandom());
		return Vacanza.builder()
				.citta(citta)
				.indirizzo(fake.address().city())
				.descrizione(durata + " da sogno in " + citta + "." )
				.tipoluogo(luogo)
				.immagineurl(urlVacanza())
				.duratagiorni(durata)
				.datainizio(dataInizio)
				.datafine(dataFine)
				.alloggio(TipoAlloggio.AlloggioRandom())
				.preferenza(Preferenze.PreferenzaRandom())
				.prezzo(price)
				.attivita(list)
				.prenotazione(prenotazioneService.getPrenotazioneRandom())
				.build();
	}
	
	public String urlVacanza() {
		//creare immagine url di un immagine casuale partendo da una parola chiave
        OkHttpClient client = new OkHttpClient();
        String keyword = luogo.toString(); // Parola chiave per l'immagine casuale
        
        try {
            String url = "https://source.unsplash.com/800x600/?"+ keyword;
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            String imageUrl = response.request().url().toString();

            //System.out.println("URL immagine casuale: " + imageUrl);
            return imageUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return "";
       
	}
	
}


