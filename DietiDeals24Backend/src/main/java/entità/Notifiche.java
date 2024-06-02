package entità;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notifiche")
public class Notifiche 
{

	@Column(name = "Titolo", nullable = false, length = 50)
	private String titolo;
	
	@Column(name = "Testo", nullable = false, length = 150)
	private String testo;
	
	@Id
	@Column(name = "idnotifiche", nullable = false)
	private int IDnotifiche;
	
	@Column(name = "idproprietarionotifica", nullable = false)
	private int IDProprietarioNotifica;
	
	@Column(name = "idasta", nullable = false)
	private int IDAsta;
	
	@Column(name = "idutentevenditore", nullable = false)
	private int IDUtenteVenditore;
	
	@Column(name = "idutentecompratore", nullable = false)
	private int IDUtenteCompratore;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public int getIDnotifiche() {
		return IDnotifiche;
	}

	public void setIDnotifiche(int iDnotifiche) {
		IDnotifiche = iDnotifiche;
	}

	public int getIDProprietarioNotifica() {
		return IDProprietarioNotifica;
	}

	public void setIDProprietarioNotifica(int iDProprietarioNotifica) {
		IDProprietarioNotifica = iDProprietarioNotifica;
	}

	public int getIDAsta() {
		return IDAsta;
	}

	public void setIDAsta(int iDAsta) {
		IDAsta = iDAsta;
	}

	public int getIDUtenteVenditore() {
		return IDUtenteVenditore;
	}

	public void setIDUtenteVenditore(int iDUtenteVenditore) {
		IDUtenteVenditore = iDUtenteVenditore;
	}

	public int getIDUtenteCompratore() {
		return IDUtenteCompratore;
	}

	public void setIDUtenteCompratore(int iDUtenteCompratore) {
		IDUtenteCompratore = iDUtenteCompratore;
	}

	
	

	
}