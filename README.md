# Gestionale di prenotazione di pacchetti vacanza - EasyVacanza

Questo progetto è un Backend sviluppato in Java Spring Boot per un gestionale di prenotazioni di pacchetti vaggio per l'agenzia EasyVacanza.
L'obiettivo è quello di gestire le entità come cliente, vacanza e prenotazione e le loro interazioni all'interno del sistema.

## API REST

L'API REST (Application Programming Interface Representational State Transfer) è un'interfaccia che permette al frontend di comunicare con il backend attraverso una serie di richieste HTTP.

In questo caso, l'API REST permette di effettuare operazioni di lettura e scrittura sulle entità gestite dal sistema di fatturazione.

L'utilizzo dell'API REST consente una maggiore flessibilità e scalabilità dell'applicazione, poiché permette la separazione tra la logica di business e la presentazione dei dati.

## Entità gestite tramite API REST

Il sistema di fatturazione gestisce le seguenti entità:

- Attivita: rappresenta un attività pianificata e contiene informazioni quali breve descrizione con il tipo di attivita(Escursione, Arrampicata, Esplorazione, Cannottaggio, Degustazione), livello di difficoltà (FACILE, MODERATO, AVANZATO) e una lista di testimonianze dei clienti precedenti.

- Testimonianza: rappresenta una recensione fornita da un cliente e contiene informazioni quali nome, cognone, email, feedback, rating, attività e cliente.

- Cliente: rappresenta un cliente e contiene informazioni anagrafiche.

- Vacanza: rappresenta il pacchetto vacanza e presenta informazioni geografice sulla meta data di inizio, data di fine, durata complessiva della vacanza, prezzo, una descrizione, l'url di un immagine associata alla tipologia di luogo(MARE, MONTAGNA, FORESTA, CAMPAGNA, METROPOLI), la tipologia di alloggio(HOTEL, BUNGALOW, TENDA, CAMPEGGIO_ATTREZZATO, APPARTAMENTO), preferenze speciali del cliente(ACCESSIBILITA_DISABILI, PET_FRIENDLY, FAMIGLIE) e un elenco di attività incluse nell'offerta.

- Prenotazione: rappresenta l'entita di prenotazione con relativo stato e anagrafica annessa.

I clienti possono avere più prenotazioni e un singolo cliente può fornire più testimonianze/recensioni.

Le vacanze possono offrire più attività. Ogni vacanza può essere associata ad una sola prenotazione e viceversa.

Una prenotazione può avere più clienti.

## Documentazione API

La documentazione dell'API può essere visionata nell'apposita collection di Postman file "EasyVacanza.postman_collection.json".

Per accedervi si segua il presente percorso: src > main > resources > static > EasyVacanza.postman_collection.json.

## LOGIN/REGISTER

Endpoint Login: POST /api/auth/signin

Accetta un body in formato JSON con username e password.

Endpoing Register: POST /api/auth/register

Accetta un body in formato JSON con username, password, name, surname, email, roles.

Tutti i campi sono in formato String, ad eccezione dei ROLES che sono un array di stringhe.

I ruoli disponibili sono "ROLE_ADMIN" e "ROLE_USER".

## Clonazione e installazione 

Eseguire in ordine i seguenti passaggi:
- Aprire il terminale sul tuo computer.

- Navigare nella directory in cui desideri clonare il progetto.

- Eseguire il comando git clone https://github.com/369-Palma/Capstone-project.git
   per clonare il repository del progetto. 
   
- Navigare nella directory del progetto appena clonato usando il comando cd [nomeprogetto].

- Creare un DB su Postgres o MySql

- Settare il file application.properties in base alle necessità, a partire da application.properties.template

- Avviare il programma SpringBoot (che creerà le entità di default sul DB)

- Eseguire una sola volta la funzione 'setRoleDefault();' dal Runner (scommentare e riavviare e successivamente ricommentare)

- Eseguire la registrazione come ADMIN tramite l'endpoint (vedi login/register)

- Eseguire una sola volta la funzione 'startedDB();' dal Runner (scommentare e riavviare e successivamente ricommentare).

## TESTS

In caso di utilizzo di Eclipse, la suite di test utilizzata è JUnit 5, quindi Jupiter, da importare.

Importare, attraverso le impostazioni di BuildPath, le librerie di Junit5 in ClassPath Modules.

## FRONTEND 

Sei curios@ di vedere l'utilizzo del db e gli endpoint all'opera? Clicca qui: https://github.com/369-Palma/easyvacanzareact.git
