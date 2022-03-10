package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Libro {
	
	@Id
	@Column(name = "id_libro", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String titolo;
	
	@Column(name = "autore_id")
	private Integer autoreId;
	
	@Column(name = "codice_isbn")
	private String codiceIsbn;
	
	private String genere;
	
	private Double prezzo;
	
	@ManyToOne
	@JoinColumn(name = "id_autore")
	private Autore autore;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAutoreId() {
		return autoreId;
	}

	public void setAutoreId(Integer autoreId) {
		this.autoreId = autoreId;
	}

	public String getCodiceIsbn() {
		return codiceIsbn;
	}

	public void setCodiceIsbn(String codiceIsbn) {
		this.codiceIsbn = codiceIsbn;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
}
