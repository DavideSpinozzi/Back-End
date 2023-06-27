package giorno2.esercizio2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Sim nuovaSim = new Sim("3271518382");
		
		datiSim(nuovaSim);
		
	}

	public static void datiSim(Sim sim) {
	
	System.out.println("Numero telefonico: " +sim.getNumeroTel()+ " Credito residuo: " + sim.getCreditoTel()+ " Ultime chiamate effettuate: " +Arrays.toString(sim.getListaChiamate()));
		
	}
}
