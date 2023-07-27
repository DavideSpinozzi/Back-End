package com.example.demo;

import java.util.List;

public class Pizza {
	private String nome;
	private String descrizione;
	private double prezzo;
	private boolean haTopping;
	private List<Topping> topping;

	public String getNome() {
		return nome;
	}

	public Pizza(String nome, String descrizione, double prezzo, boolean haTopping, List<Topping> topping) {

		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.haTopping = haTopping;
		this.topping = topping;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isHaTopping() {
		return haTopping;
	}

	public void setHaTopping(boolean haTopping) {
		this.haTopping = haTopping;
	}

	public List<Topping> getTopping() {
		return topping;
	}

	public void setTopping(List<Topping> topping) {
		this.topping = topping;
	}

	public int getCalorieTotali() {
		int calorieTotali = 0;
		if (topping != null) {
			for (Topping topping : topping) {
				calorieTotali += topping.getCalorie();
			}
		}
		return calorieTotali;
	}
}