package com.example.demo;

public class Tavolo {
    private int numeroTavolo;
    private int copertiMassimi;
    private boolean occupato;

    public Tavolo(int numeroTavolo, int copertiMassimi) {
        this.numeroTavolo = numeroTavolo;
        this.copertiMassimi = copertiMassimi;
        this.occupato = false;
    }

	public int getNumeroTavolo() {
		return numeroTavolo;
	}

	public void setNumeroTavolo(int numeroTavolo) {
		this.numeroTavolo = numeroTavolo;
	}

	public int getCopertiMassimi() {
		return copertiMassimi;
	}

	public void setCopertiMassimi(int copertiMassimi) {
		this.copertiMassimi = copertiMassimi;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}}