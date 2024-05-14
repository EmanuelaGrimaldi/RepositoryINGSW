package entità;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int ID;
	
	@Column(name = "Nome", nullable = false, length = 45)
	private String nome;
	
	@Column(name = "Cognome", nullable = false, length = 45)
	private String cognome;
		
	@Column(name = "Biografia", nullable = false, length = 300)
	private String biografia;
		
	@Column(name = "Geolocalizzazione", nullable = true, length = 50)
	private String geolocalizzazione;
	
	@Column(name = "ElencoSocial", nullable = false, length = 30)
	private String elencoSocial;
	
	@Column(name = "FotoProfilo", nullable = false, length = 300)
	private String fotoProfilo;
		
	@Column(name = "ElencoRecensioni", nullable = false, length = 30)
	private String elencoRecensioni;
	
	@Column(name = "ElencoAste", nullable = true, length = 30)
	private String elencoAste;

	@Override
	public String toString() {
		return "Utente [ID=" + ID + ", nome=" + nome + ", cognome=" + cognome + ", biografia=" + biografia
				+ ", geolocalizzazione=" + geolocalizzazione + ", elencoSocial=" + elencoSocial + ", fotoProfilo="
				+ fotoProfilo + ", elencoRecensioni=" + elencoRecensioni + ", elencoAste=" + elencoAste
				+ ", isAmministratore=" + isAmministratore + ", emailUtente=" + emailUtente + ", passwordUtente="
				+ passwordUtente + ", elencoNotifiche=" + elencoNotifiche + "]";
	}

	@Column(name = "IsAmministratore", nullable = false)
	private boolean isAmministratore;

	@Column(name = "EmailUtente", nullable = true, length = 40)
	private String emailUtente;
	  
	@Column(name = "PasswordUtente", nullable = true, length = 40)
	private String passwordUtente;
	
	@Column(name = "ElencoNotifiche", nullable = true, length = 100)
	private String elencoNotifiche;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

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

	public String getElencoRecensioni() {
		return elencoRecensioni;
	}

	public void setElencoRecensioni(String elencoRecensioni) {
		this.elencoRecensioni = elencoRecensioni;
	}

	public String getElencoAste() {
		return elencoAste;
	}

	public void setElencoAste(String elencoAste) {
		this.elencoAste = elencoAste;
	}

	public boolean isAmministratore() {
		return isAmministratore;
	}

	public void setAmministratore(boolean isAmministratore) {
		this.isAmministratore = isAmministratore;
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

	public String getElencoNotifiche() {
		return elencoNotifiche;
	}

	public void setElencoNotifiche(String elencoNotifiche) {
		this.elencoNotifiche = elencoNotifiche;
	}
	
	  
	
}

