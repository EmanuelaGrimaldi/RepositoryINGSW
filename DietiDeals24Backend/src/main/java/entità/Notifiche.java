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

	public int getID_notifiche() {
		return IDnotifiche;
	}

	public void setID_notifiche(int iDnotifiche) {
		IDnotifiche = iDnotifiche;
	}

	public int getIDUtenteFK() {
		return IDUtenteFK;
	}

	public void setIDUtenteFK(int iDUtenteFK) {
		IDUtenteFK = iDUtenteFK;
	}
	
	@Override
	public String toString() {
		return "Notifiche [titolo=" + titolo + ", testo=" + testo + ", IDnotifiche=" + IDnotifiche + ", IDUtenteFK="
				+ IDUtenteFK + "]";
	}
	
}