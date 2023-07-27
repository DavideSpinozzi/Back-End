package com.example.demo;

public class Topping {
    private String nome;
    private int calorie;
	public Topping(String nome, int calorie) {
		
		this.nome = nome;
		this.calorie = calorie;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

    
}
