package giorno2.esercizio3;

public class Cliente {

	private double codiceCliente;
	private String nomeCognome;
	private String email;
	private String dataIscrizione;
	public Cliente(double codiceCliente, String nomeCognome, String email, String dataIscrizione) {
		
		this.codiceCliente = codiceCliente;
		this.nomeCognome = nomeCognome;
		this.email = email;
		this.dataIscrizione = dataIscrizione;
	}
	
	public double getCodiceCliente() {
		return codiceCliente;
	}
	public void setCodiceCliente(double codiceCliente) {
		this.codiceCliente = codiceCliente;
	}
	public String getNomeCognome() {
		return nomeCognome;
	}
	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataIscrizione() {
		return dataIscrizione;
	}
	public void setDataIscrizione(String dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}
	
	
	
}
