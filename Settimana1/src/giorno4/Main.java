package giorno4;

public class Main {

	public static void main(String[] args) {
		
		Dipendente Giovanni = new Dipendente("GVN", TipoDipartimento.PRODUZIONE);
		Dipendente Peppino = new Dipendente("PPP", TipoDipartimento.PRODUZIONE);
		Dipendente Asdrubale = new Dipendente("ASD", 1200, 40, TipoLivello.IMPIEGATO, TipoDipartimento.AMMINISTRAZIONE);
		Dipendente Gianni = new Dipendente("GNN", 2000, 60, TipoLivello.DIRIGENTE, TipoDipartimento.VENDITE);
		
		Peppino.promuovi();
		Asdrubale.promuovi();
		System.out.println();
		Giovanni.stampaDatiDipendenti();
		System.out.println();
		Peppino.stampaDatiDipendenti();
		System.out.println();
		Asdrubale.stampaDatiDipendenti();
		System.out.println();
		Gianni.stampaDatiDipendenti();
		System.out.println();
		
		sommaStipendi(Giovanni, Peppino, Asdrubale, Gianni);
	}

	public static double calcolaPaga(Dipendente x) {
		return x.getStipendio();
	}
	
	public static double calcolaPaga(Dipendente x, int ore) {
		return x.getStipendio() + (ore * x.getImportoOrarioStraordinario());
	}
	
	public static void sommaStipendi(Dipendente...dipendenti) {
		
		double somma = 0;
		
		for(Dipendente dipendente : dipendenti) {
			
			somma += calcolaPaga(dipendente, 5);
			
		}
		
		System.out.println("Il totale degli stipendi e: " +somma);
		
	}
	
}
