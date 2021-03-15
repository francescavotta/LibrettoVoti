package it.polito.tdp.librettovoti.model;
//oggettiamente non fa parte del model
import java.time.LocalDate;
import java.util.*;

public class TestLibretto {

	public static void main(String[] args) {
		
		System.out.println("Test metodi di libretto");
		
		Libretto libretto = new Libretto();
		Voto voto1 = new Voto("Analisi 1", 30, LocalDate.of(2019, 2, 15));
		
		libretto.add(voto1);
		libretto.add(new Voto("Chimica", 25, LocalDate.of(2019, 9, 15)));
		libretto.add(new Voto("Fisica 1", 28, LocalDate.of(2019, 7, 15)));
		libretto.add(new Voto("Informatica", 24, LocalDate.of(2019, 9, 15)));
		
		System.out.println(libretto);
		
		List <Voto> venticinque = libretto.listaVotiUguali(25);
		System.out.println(venticinque);
		
		Libretto libretto25 = libretto.votiUguali(25);
		System.out.println(libretto25);
		
		if(libretto.ricercaCorso("Chimica")!=null)
			System.out.println(libretto.ricercaCorso("Chimica"));
	
		Voto analisi3 = libretto.ricercaCorso("Analisi3");
		System.out.println(analisi3);
		
		Voto chimica = libretto.ricercaCorso("Chimica");
		Voto chimica_doppio = new Voto("Chimica", 25, LocalDate.of(2019, 9, 15));
		Voto chimica_conflitto = new Voto("Chimica", 29, LocalDate.of(2019, 9, 15));
		System.out.println(chimica + " è in conflitto con " + chimica_conflitto+ "? -->" + libretto.esisteConflitto(chimica_conflitto));
		System.out.println(chimica + " è doppione di " + chimica_doppio+ "? -->" + libretto.esisteDuplicato(chimica_doppio));
	
		libretto.add(chimica_doppio);
		System.out.println("\nStampo libretto, prova metodo add()");
		System.out.println(libretto);
	}
	
}
