package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.MobileApp;
import org.generation.italy.model.Recensione;

public class MainMobApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MobileApp m = null;
		boolean appCreata = false;
		String scelta;
		do {
			System.out.println("Inserisci il nome dell'app:");
			String nome = sc.nextLine();
			System.out.println("Inserisci il sistema operativo dell'app:");
			String sistemaOperativo = sc.nextLine();

			float prezzo = -1;
			do {
				System.out.println("Inserisci il prezzo dell'app:");
				try {
					prezzo = Float.parseFloat(sc.nextLine());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println("Prezzo non valido");
				}
			} while (prezzo < 0);
			try {
				m = new MobileApp(nome, sistemaOperativo, prezzo);
				appCreata = true;
			} catch (Exception e) {
				System.out.println("Errore nella creazione dell'app: " + e.getMessage() + " Riprova di nuovo");
				appCreata = false;
			}
		} while (!appCreata);

		do {
			// Stampa del menu
			
			System.out.println("\n\nRicavo totale: " + m.getRicavoTotale());
			System.out.println("Numero totale download: " + m.getNrTotaleDownload());
			if (m.getElencoRecensioni().size() > 0) {
				System.out.println("Valutazione media: " + m.valutazioneMedia());
			}
			System.out.println("\nMenu:");
			System.out.println("1. Download singolo");
			System.out.println("2. Download multiplo");
			System.out.println("3. Ricevi recensione");
			System.out.println("4. Visualizza recensioni");
			System.out.println("00. Esci");
			System.out.print("Inserisci la tua scelta: ");
			scelta = sc.nextLine();

			// Switch-case vuoto pronto per essere riempito
			switch (scelta) {
			case "1":
				m.download(); // Azione per download singolo

				break;
			case "2":// Azione per download multiplo
				System.out.println("Quante volte vuoi effettuare il download?");
				try {
					int nrDownload = Integer.parseInt(sc.nextLine());
					m.download(nrDownload);
//                	if(nrDownload>=0)
//                		m.download(nrDownload);
//                	else
//                		System.out.println("Numero inserito non valido");
				} catch (Exception e) {
					System.out.println("Numero inserito non valido... Riprova ");
				}
				break;
			case "3":
				// Azione per ricevere recensione
				boolean recensioneValida;
				Recensione r = null;
				do {
					recensioneValida = true;
					// Chiedi all'utente di inserire il nome

					System.out.println("Inserisci il nome: ");
					String nomeUtente = sc.nextLine();
					// Chiedi all'utente di inserire il numero di stelle da assegnare
					System.out.println("Inserisci il numero di stelle da 1 a 5: ");
					int numeroStelle = 0;
					try {
						numeroStelle = Integer.parseInt(sc.nextLine());
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						System.err.println("Non valido " +e.getMessage());
					}
					// Chiedi all'utente di inserire il testo della recensione
					System.out.println("Inserisci il testo della recensione:(minomo 20 caratteri) ");
					String testoRecensione = sc.nextLine();
					try {
						r = new Recensione(nomeUtente, numeroStelle, testoRecensione);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.err.println("Riprova.. " +e.getMessage());
						recensioneValida = false;
					}
				} while (!recensioneValida);
				m.riceviRecensione(r);
				break;
			case "4":
				// Azione per visualizzare recensioni
				if (m.getElencoRecensioni().size() > 0) {
					for (Recensione rev : m.getElencoRecensioni()) {
						System.out.println(rev.toString());
					}
					System.out.println("Valutazione media: " + m.valutazioneMedia());
				} else {
					System.out.println("Non hai nessuna recensione");
				}

				break;
			case "00":
				System.out.println("Uscita dal programma...");
				break;
			default:
				System.out.println("Scelta non valida, riprova.");
				break;
			}
			
		} while (!scelta.equals("00"));

		sc.close();

	}

}
