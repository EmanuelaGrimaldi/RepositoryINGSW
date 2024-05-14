package entità;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Recensione")
public class Recensione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int ID;
	
	@Column(name = "nomeCompratore", nullable = false, length = 30)
	private String nomeCompratore;
	
	@Column(name = "compratore", nullable = false)
	private int compratore;   

	@Column(name = "Titolo", nullable = false, length = 30)
	private String titolo;
	  
	@Override
	public String toString() {
		return "Recensione [ID=" + ID + ", nomeCompratore=" + nomeCompratore + ", compratore=" + compratore
				+ ", titolo=" + titolo + ", contenuto=" + contenuto + ", numeroStelle=" + numeroStelle + "]";
	}

	@Column(name = "Contenuto", nullable = true, length = 200)
	private String contenuto;
	
	@Column(name = "numeroStelle", nullable = false)
	private int numeroStelle;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNomeCompratore() {
		return nomeCompratore;
	}

	public void setNomeCompratore(String nomeCompratore) {
		this.nomeCompratore = nomeCompratore;
	}

	public int getCompratore() {
		return compratore;
	}

	public void setCompratore(int compratore) {
		this.compratore = compratore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public int getNumeroStelle() {
		return numeroStelle;
	}

	public void setNumeroStelle(int numeroStelle) {
		this.numeroStelle = numeroStelle;
	}

	
	
	//@OneToMany Connection con le aste
	
}
