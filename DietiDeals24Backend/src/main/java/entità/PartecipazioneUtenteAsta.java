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
	
	@Column(name = "ID_Utente", nullable = false)
	private int ID_Utente;

	@Column(name = "ID_Asta", nullable = false)
	private int ID_Asta;
	
}