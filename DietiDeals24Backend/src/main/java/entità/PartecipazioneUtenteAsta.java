package entità;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PartecipazioneUtenteAsta")
public class PartecipazioneUtenteAsta {
	
	@Column(name = "IDUtente", nullable = false)
	private int IDUtente;

	@Column(name = "IDAsta", nullable = false)
	private int IDAsta;

	public int getIDUtente() {
		return IDUtente;
	}

	public void setIDUtente(int iDUtente) {
		IDUtente = iDUtente;
	}

	public int getIDAsta() {
		return IDAsta;
	}

	public void setIDAsta(int iDAsta) {
		IDAsta = iDAsta;
	}
	
}