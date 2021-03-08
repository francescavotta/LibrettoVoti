package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;


//POJO - plain old java object
//Java Bean
// semplici classi java, contenitore di dati -- non ha logica

/**
 * Memorizza il risultato di un esame singolo
 * 
 * @author Utente
 *
 */
public class Voto {
 
	private String nome;
	private int voto; // 30L come lo rappresento?
	private LocalDate data; // data superamento esame
	
	/**
	 * Costruttore della classe voto
	 * @param nome
	 * @param voto
	 * @param data
	 */
	
	public Voto(String nome, int voto, LocalDate data) {
		super();
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Esame "+ nome + " superato con " + voto + " il " + data;
	}
	
	
}
