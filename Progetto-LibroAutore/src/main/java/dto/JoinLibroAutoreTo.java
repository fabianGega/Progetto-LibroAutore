package dto;

public class JoinLibroAutoreTo {
	
	private String nome;
	private String cognome;
	private String titolo;
	private String genere;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	public String toString() {
		return "( Nome: "+ nome+ ", Cognome: "+cognome +", titolo: " + titolo + ", genere: " + genere +" )" + "\n";
	}
	
}
