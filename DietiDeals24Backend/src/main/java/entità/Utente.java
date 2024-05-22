package entità;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {
	
	@Column(name = "nome", nullable = false, length = 30)
	private String nome;
	
	@Column(name = "cognome", nullable = false, length = 30)
	private String cognome;
		
	@Column(name = "biografia", nullable = true, length = 1000)
	private String biografia;
		
	@Column(name = "geolocalizzazione", nullable = true, length = 50)
	private String geolocalizzazione;
	
	@Column(name = "elencosocial", nullable = true, length = 1000)
	private String elencoSocial;
	
	@Column(name = "fotoprofilo", nullable = true, length = 1000)
	private String fotoProfilo;

	@Column(name = "emailutente", nullable = false, length = 40)
	private String emailUtente;
	  
	@Column(name = "passwordutente", nullable = false, length = 40)
	private String passwordUtente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idutente", nullable = false)
	private int ID_Utente;


	//Getters_setters_toString
	
	
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

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getGeolocalizzazione() {
		return geolocalizzazione;
	}

	public void setGeolocalizzazione(String geolocalizzazione) {
		this.geolocalizzazione = geolocalizzazione;
	}

	public String getElencoSocial() {
		return elencoSocial;
	}

	public void setElencoSocial(String elencoSocial) {
		this.elencoSocial = elencoSocial;
	}

	public String getFotoProfilo() {
		return fotoProfilo;
	}

	public void setFotoProfilo(String fotoProfilo) {
		this.fotoProfilo = fotoProfilo;
	}

	public String getEmailUtente() {
		return emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getPasswordUtente() {
		return passwordUtente;
	}

	public void setPasswordUtente(String passwordUtente) {
		this.passwordUtente = passwordUtente;
	}

	public int getID_Utente() {
		return ID_Utente;
	}

	public void setID_Utente(int iD_Utente) {
		ID_Utente = iD_Utente;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", biografia=" + biografia + ", geolocalizzazione="
				+ geolocalizzazione + ", elencoSocial=" + elencoSocial + ", fotoProfilo=" + fotoProfilo
				+ ", emailUtente=" + emailUtente + ", passwordUtente=" + passwordUtente + ", ID_Utente=" + ID_Utente
				+ "]";
	}
	

	
}

