package giorno4;

public class Dipendente {

	private double stipendioBase = 1000;
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private TipoLivello livello;
	private TipoDipartimento dipartimento;
	
	public Dipendente(String matricola, TipoDipartimento dipartimento) {

		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = TipoLivello.OPERAIO;
	}

	public Dipendente(String matricola, double stipendio, double importoOrarioStraordinario,
			TipoLivello livello, TipoDipartimento dipartimento) {
		
		
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}

	public double getStipendioBase() {
		return stipendioBase;
	}

	public String getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public TipoLivello getLivello() {
		return livello;
	}

	public TipoDipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(TipoDipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	public void stampaDatiDipendenti() {
		
		System.out.println("Matricola: " + matricola);
	    System.out.println("Stipendio: " + stipendio);
	    System.out.println("Livello: " + livello);
	    System.out.println("Dipartimento: " + dipartimento);
	}
	
	public TipoLivello promuovi() {
		
		if(livello == TipoLivello.OPERAIO) {
			this.livello = TipoLivello.IMPIEGATO;
			this.stipendio = stipendio * 1.2;
		} else if (livello == TipoLivello.IMPIEGATO) {
			this.livello = TipoLivello.QUADRO;
			this.stipendio = stipendio * 1.5;
		} else if (livello == TipoLivello.QUADRO) {
			this.livello = TipoLivello.DIRIGENTE;
			this.stipendio = stipendio * 2;
		} else if (livello == TipoLivello.DIRIGENTE) {
			System.out.println("Non puoi piu salire di livello");
		}
		return livello;
	}
	
}
