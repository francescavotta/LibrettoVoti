package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	//list è un'interfaccia
	private List <Voto> voti; //definisco una variabile che punta a null
	
	public Libretto() {
		this.voti = new ArrayList<Voto>(); //ora punta all'oggetto, grazie alla parola new
	}
	
	public void add(Voto v) {
		
		this.voti.add(v);
	}
	
	public String toString() {
		String s="";
		for(Voto v: this.voti) {
			s = s + v.toString() + "\n";
		}
		return s;
	}
	
	/*public void stampaVotiUguali(int punteggio) {
		//il libretto stampa da solo i voti
		//stampa solo sulla console.. e se dovessi metterla in una txt
	}
	
	public String votiUguali(int punteggio) {
		//calcola la stringa che contiene i voti
		//sarà il chiamante a stamparli
		//MA voglio il nome del corso? la data?
		return null;
	}*/
	
	public List<Voto> listaVotiUguali(int punteggio){
		//restituisce i voti uguali al criterio
		// poi stampali come vuoi
		//difetto: espone all'esterno la struttura dati usata
		
		List<Voto> risultato = new ArrayList<>();
		for (Voto v: this.voti) {
			if(v.getVoto()==punteggio)
				risultato.add(v); //contenuto in due liste diverse, è lo stesso oggetto!!
		}
		return risultato;
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato = new Libretto();
		//creo un libretto con solo i voti uguali a punteggio
		//filtro dei dati, in fondo è sempre un libretto!!
		
		for(Voto v: this.voti) {
			if(v.getVoto()==punteggio)
				risultato.add(v); //uso il metodo add() creato prima
			//risultato.voti.add(v);
		}
		return risultato;
	}

}
