package giorno2.esercizio3;

public class Articolo {
	private String codiceArticolo;
	private String descrizioneArticolo;
	private double prezzo;
	private int pezziDisponibili;
	
	public Articolo(String codiceArticolo, String descrizioneArticolo, double prezzo, int pezziDisponibili) {
		this.codiceArticolo = codiceArticolo;
		this.descrizioneArticolo = descrizioneArticolo;
		this.prezzo = prezzo;
		this.pezziDisponibili = pezziDisponibili;
	}

	public String getCodiceArticolo() {
		return codiceArticolo;
	}

	public void setCodiceArticolo(String codiceArticolo) {
		this.codiceArticolo = codiceArticolo;
	}

	public String getDescrizioneArticolo() {
		return descrizioneArticolo;
	}

	public void setDescrizioneArticolo(String descrizioneArticolo) {
		this.descrizioneArticolo = descrizioneArticolo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getPezziDisponibili() {
		return pezziDisponibili;
	}

	public void setPezziDisponibili(int pezziDisponibili) {
		this.pezziDisponibili = pezziDisponibili;
	}

	@Override
	public String toString() {
		return descrizioneArticolo;
	}

	
	
}
