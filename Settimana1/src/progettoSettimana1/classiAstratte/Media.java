package progettoSettimana1.classiAstratte;

public abstract class Media{
    private String titolo;
    private int durata;
    private int volume;
    private int luminosita;
    
    public Media(String titolo, int luminosita) {
    	this.titolo = titolo;
    	this.luminosita = luminosita;
    }
    
    public Media(String titolo, int durata, int volume, int luminosita) {
        this.titolo = titolo;
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public Media(String titolo, int durata, int volume) {
        this.titolo = titolo;
        this.durata = durata;
        this.volume = volume;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

	public int getLuminosita() {
		return luminosita;
	}

	public void setLuminosita(int luminosita) {
		this.luminosita = luminosita;
	}
	
	protected String ripetiCarattere(char carattere, int conteggio) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < conteggio; i++) {
			sb.append(carattere);
		}
		return sb.toString();
	}
}