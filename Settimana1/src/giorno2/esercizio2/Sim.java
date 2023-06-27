package giorno2.esercizio2;

public class Sim {
 
	private String numeroTel;
	private double creditoTel = 0;
	private Chiamata[] listaChiamate = new Chiamata[5];
	
	public Sim(String numeroTel) {
	
		this.numeroTel = numeroTel;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public double getCreditoTel() {
		return creditoTel;
	}

	public void setCreditoTel(double creditoTel) {
		this.creditoTel = creditoTel;
	}

	public Chiamata[] getListaChiamate() {
		return listaChiamate;
	}

	public void setListaChiamate(Chiamata[] listaChiamate) {
		this.listaChiamate = listaChiamate;
	}
	
	
	
}
