package entità;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ConcorrentiUtenteAsta")
public class ConcorrentiUtenteAsta 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Utente", nullable = false)
	private int ID_Utnete;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Asta", nullable = false)
	private int ID_Asta;

	// forse ci possiamo add degli attributi per sapere qualcosa in piu?
}