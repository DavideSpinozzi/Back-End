package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ordine {
    private static int prossimoNumeroOrdine = 1;

    private int numeroOrdine;
    private StatoOrdine stato;
    private int numeroCoperti;
    private LocalDateTime oraAcquisizione;
    private List<ElementoMenu> elementi;
    private double importoTotale;

    public Ordine(int numeroCoperti) {
        this.numeroOrdine = prossimoNumeroOrdine++;
        this.stato = StatoOrdine.IN_CORSO;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = LocalDateTime.now();
        this.elementi = new ArrayList<>();
        this.importoTotale = 0.0;
    }

 

    public static int getProssimoNumeroOrdine() {
		return prossimoNumeroOrdine;
	}



	public static void setProssimoNumeroOrdine(int prossimoNumeroOrdine) {
		Ordine.prossimoNumeroOrdine = prossimoNumeroOrdine;
	}



	public int getNumeroOrdine() {
		return numeroOrdine;
	}



	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}



	public StatoOrdine getStato() {
		return stato;
	}



	public void setStato(StatoOrdine stato) {
		this.stato = stato;
	}



	public int getNumeroCoperti() {
		return numeroCoperti;
	}



	public void setNumeroCoperti(int numeroCoperti) {
		this.numeroCoperti = numeroCoperti;
	}



	public LocalDateTime getOraAcquisizione() {
		return oraAcquisizione;
	}



	public void setOraAcquisizione(LocalDateTime oraAcquisizione) {
		this.oraAcquisizione = oraAcquisizione;
	}



	public List<ElementoMenu> getElementi() {
		return elementi;
	}



	public void setElementi(List<ElementoMenu> elementi) {
		this.elementi = elementi;
	}



	public double getImportoTotale() {
		return importoTotale;
	}



	public void setImportoTotale(double importoTotale) {
		this.importoTotale = importoTotale;
	}



	public void aggiungiElementoMenu(ElementoMenu elementoMenu) {
        elementi.add(elementoMenu);
        this.importoTotale += elementoMenu.getPrezzo();
    }

   
    public void aggiungiElementoMenu(Pizza pizza) {
        ElementoMenu elementoMenu = new ElementoMenu(pizza.getNome(), pizza.getDescrizione(), pizza.getPrezzo());
        elementi.add(elementoMenu);
        this.importoTotale += elementoMenu.getPrezzo();
    }


    public void aggiungiElementoMenu(Beverage beverage) {
        ElementoMenu elementoMenu = new ElementoMenu(beverage.getNome(), beverage.getDescrizione(), beverage.getPrezzo());
        elementi.add(elementoMenu);
        this.importoTotale += elementoMenu.getPrezzo();
    }
}
