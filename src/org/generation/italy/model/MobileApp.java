package org.generation.italy.model;

import java.util.ArrayList;

public class MobileApp {

	protected String nome;
	protected String sistemaOperativo;
	protected float prezzo;
	ArrayList<Recensione> elencoRecensioni = new ArrayList<Recensione>();
	protected float ricavoTotale;
	protected int nrTotaleDownload;
	
	
	public MobileApp(String nome, String sistemaOperativo, float prezzo) throws Exception {
		super();
		if (!nome.isBlank()) {
			this.nome = nome;
		}else 
			throw new Exception("Non hai inserito il nome");
		if(sistemaOperativo.equalsIgnoreCase("Android")||sistemaOperativo.equalsIgnoreCase("ios"))
			this.sistemaOperativo = sistemaOperativo;
		else 
		throw new Exception("Sistema operativo non valido");
		
		if(prezzo>=0)
			this.prezzo = prezzo;
		else 
			throw new Exception("Prezzo non può essere negativo");
		ricavoTotale=0;
		nrTotaleDownload=0;
	}
	
	public void download() {
		ricavoTotale+=prezzo;
		nrTotaleDownload++;
	}

	
	public void download(int numeroDownload) throws Exception {
		if(numeroDownload>=0) {
			ricavoTotale+=(prezzo*numeroDownload);
			nrTotaleDownload+=numeroDownload;
		}
    	else
    		throw new Exception("Numero inserito non valido");
    		
		
	}
	
	
	public void riceviRecensione(Recensione recensione) {
		elencoRecensioni.add(recensione);
	}
	
	public float valutazioneMedia() {
		float valutazioneMedia;
		float totaleStelle = 0f;
		if(!elencoRecensioni.isEmpty()) {
			for(Recensione r:elencoRecensioni) {
				totaleStelle+=r.numeroStelle;
			}
		}
		valutazioneMedia=totaleStelle/elencoRecensioni.size();
			return valutazioneMedia;	
	}



	public ArrayList<Recensione> getElencoRecensioni() {
		return elencoRecensioni;
	}

	public float getRicavoTotale() {
		return ricavoTotale;
	}

	public int getNrTotaleDownload() {
		return nrTotaleDownload;
	}


	
	
	
	
	
	
	
	
	
}
