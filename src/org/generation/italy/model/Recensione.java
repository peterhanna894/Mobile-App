package org.generation.italy.model;

import java.time.LocalDate;


public class Recensione {

	protected LocalDate data;
	protected String nomeUtente;
	protected int numeroStelle;
	protected String testo;
	
	
	public Recensione(String nomeUtente, int numeroStelle, String testo) throws Exception {
		super();
		if (!nomeUtente.isBlank()) {
			this.nomeUtente = nomeUtente;
		}else // valore predefinito
			throw new Exception("Non hai inserito il nome");
		if (numeroStelle >= 1 && numeroStelle <= 5) {
			this.numeroStelle = numeroStelle;
		} else // valore predefinito
			throw new Exception("Numero di stelle non valido");
		if (!testo.isBlank() && testo.length() > 20)
			this.testo = testo;
		else
			throw new Exception("Testo troppo corto");
		data=LocalDate.now();
	
	}

	@Override
	public String toString() {
		return "Recensione [data=" + data + ", nomeUtente=" + nomeUtente + ", numeroStelle=" + numeroStelle + ", testo="
				+ testo + "]";
	}

}
