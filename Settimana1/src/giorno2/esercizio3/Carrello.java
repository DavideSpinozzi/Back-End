package giorno2.esercizio3;

public class Carrello {
   
	private Cliente clienteAssociato;
	private Articolo[] elencoArticoli = {};
	private double costoTotale = 0;
	
	public Carrello(Cliente clienteAssociato) {
		
		this.clienteAssociato = clienteAssociato;
	}

	public Cliente getClienteAssociato() {
		return clienteAssociato;
	}

	public void setClienteAssociato(Cliente clienteAssociato) {
		this.clienteAssociato = clienteAssociato;
	}

	public Articolo[] getElencoArticoli() {
		return elencoArticoli;
	}

	public void setElencoArticoli(Articolo[] elencoArticoli) {
		this.elencoArticoli = elencoArticoli;
	}

	public double getCostoTotale() {
		
		double somma = 0;
		
		for(Articolo articolo : elencoArticoli) {
			
			somma += articolo.getPrezzo();
		}
		costoTotale = somma;
		
		return costoTotale;
	}

	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}
	
	public void aggiungiArticolo(Articolo articolo) {
		
		
		Articolo[] elencoArticoliNuovo = new Articolo[this.elencoArticoli.length + 1];
		
		for( int i=0 ; i<this.elencoArticoli.length; i++) {
			
			elencoArticoliNuovo[i]= this.elencoArticoli[i];
		}
		elencoArticoliNuovo[elencoArticoliNuovo.length -1]= articolo;
		this.elencoArticoli = elencoArticoliNuovo;
	}
	
}