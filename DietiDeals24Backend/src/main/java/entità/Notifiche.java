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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDnotifiche", nullable = false)
	private int IDnotifiche;
	
	@Column(name = "IDUtenteFK", nullable = false)
	private int IDUtenteFK;
	
	@Column(name = "IDAsta", nullable = false)
	private int IDAsta;
	

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

	public int getIDUtenteFK() {
		return IDUtenteFK;
	}

	public void setIDUtenteFK(int iDUtenteFK) {
		IDUtenteFK = iDUtenteFK;
	}

	public int getIDnotifiche() {
		return IDnotifiche;
	}

	public void setIDnotifiche(int iDnotifiche) {
		IDnotifiche = iDnotifiche;
	}

	public int getIDAsta() {
		return IDAsta;
	}

	public void setIDAsta(int iDAsta) {
		IDAsta = iDAsta;
	}
	

	
}