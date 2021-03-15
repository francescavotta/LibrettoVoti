package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	//list è un'interfaccia
	private List <Voto> voti; //definisco una variabile che punta a null
	private Map<String, Voto> votiMap; //identify map: nome esame --> oggetto Voto
	
	public Libretto() {
		this.voti = new ArrayList<Voto>(); //ora punta all'oggetto, grazie alla parola new
		this.votiMap = new HashMap<>();
	}
	
	public void add(Voto v) {
		if(this.esisteConflitto(v)==false && this.esisteDuplicato(v)==false) {
			this.voti.add(v);
			this.votiMap.put(v.getNome(), v);
		}
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
			// il metodo add() fa più operazioni di un semplice 
			//risultato.voti.add(v);
		}
		return risultato;
	}
	/**
	 * Ricerca un voto del corso di cui è specificato il nome
	 * se il corso non esiste, restituisce null.
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaCorso(String nomeCorso) {
/*		Voto risultato = null;
		for(Voto v: this.voti) {
			if(v.getNome().equals(nomeCorso)) {//equal per UGUAGLIANZA, compareTo solo per ORDINARE
				risultato = v;
				break;
			}
		}
		return risultato;*/
		
		return this.votiMap.get(nomeCorso);
	}
	/**
	 * Verifica se c'è già un voto con lo stesso esame e stessa valutazione
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
		/*boolean trovato = false;
		
		for(Voto voto: this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()==v.getVoto())
				trovato = true;
		}
		return trovato;*/
		
		Voto trovato = this.votiMap.get(v.getNome()); // più efficiente, tempo costante di ricerca in una mappa
		//nella lista è lineare
		if(trovato == null)
			return false;
		if(trovato.getVoto() == v.getVoto())
			return true;
		else
			return false;
		
		
	}
	/**
	 * Verifica se un voto ha lo stesso nome ma valutazione diversa
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
		boolean trovato = false;
		
		for(Voto voto: this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()!=v.getVoto())
				trovato = true;
		}
		return trovato;
	}

}
