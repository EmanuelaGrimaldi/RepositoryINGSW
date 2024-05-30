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
	@Column(name = "ID_notifiche", nullable = false)
	private int ID_notifiche;
	
	@Column(name = "ID_Utente_FK", nullable = false)
	private int ID_Utente_FK;
	
	
	

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
		return ID_notifiche;
	}

	public void setID_notifiche(int iD_notifiche) {
		ID_notifiche = iD_notifiche;
	}

	public int getID_Utente_FK() {
		return ID_Utente_FK;
	}

	public void setID_Utente_FK(int iD_Utente_FK) {
		ID_Utente_FK = iD_Utente_FK;
	}
	
	@Override
	public String toString() {
		return "Notifiche [titolo=" + titolo + ", testo=" + testo + ", ID_notifiche=" + ID_notifiche + ", ID_Utente_FK="
				+ ID_Utente_FK + "]";
	}
	
}