package com.example.demo;

public class MenuItem {
    private String nome;
    private String descrizione;
    private double prezzo;
    private int calorie;

    public MenuItem(String nome, String descrizione, double prezzo, int calorie) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.calorie = calorie;
    }

	public String getNome() {
		return nome;
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

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}


}