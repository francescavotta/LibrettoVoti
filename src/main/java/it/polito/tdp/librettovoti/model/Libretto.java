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
	

}
