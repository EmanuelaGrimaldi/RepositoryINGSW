package entità;


import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asta")
public class Asta {

	@Column(name = "titolo", nullable = false, length = 30)
	private String titolo;
	
	@Column(name = "descrizione", nullable = true, length = 150)
	private String descrizione;
	
	@Column(name = "categoria", nullable = false, columnDefinition = "ENUM('TabletTelefonia', 'Giocattoli', 'Elettronica', 'Arte', 'Immobili', 'Antiquariato')")
	private String categoria;
	
	@Column(name = "tipologia", nullable = false, columnDefinition = "ENUM('astaTempoFisso', 'astaInglese')")
	private String tipologia;

	@Column(name = "datainizio", nullable = false)
	private LocalDate dataInizio;
	
	@Column(name = "offertainiziale", nullable = false)
	private float offertaIniziale;
	
	@Column(name = "offertapiualta", nullable = true)
	private float offertaPiuAlta;
	
	@Column(name = "idoffertapiualta", nullable = true)
	private int IDOffertaPiuAlta;
	
	@Column(name = "fotoasta", nullable = true)
	private String fotoAsta;
	
	
	//Per_aste_inglesi
	
	@Column(name = "timer", nullable = true)
	private LocalTime timer;
	
	@Column(name = "timerreset", nullable = true)
	private LocalTime timerReset;
	
	@Column(name = "sogliarialzo", nullable = true)
	private float sogliaRialzo;
	
	
	//Per_aste_tempoFisso
	
	@Column(name = "datafine", nullable = true)
	private LocalDate dataFine;
	
	
	//PK_e_FK
	
	@Id
	@Column(name = "idasta", nullable = false)
	public int ID;
	 
	@Column(name = "proprietariofk", nullable = false)
	private int proprietario_FK;
	
	
	//Getters_Setters_toSring
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate date) {
		this.dataInizio = date;
	}

	public float getOffertaIniziale() {
		return offertaIniziale;
	}

	public void setOffertaIniziale(float offertaIniziale) {
		this.offertaIniziale = offertaIniziale;
	}

	public float getOffertaPiuAlta() {
		return offertaPiuAlta;
	}

	public void setOffertaPiuAlta(float offertaPiuAlta) {
		this.offertaPiuAlta = offertaPiuAlta;
	}

	public int getIDOffertaPiuAlta() {
		return IDOffertaPiuAlta;
	}

	public void setIDOffertaPiuAlta(int iDOffertaPiuAlta) {
		IDOffertaPiuAlta = iDOffertaPiuAlta;
	}

	public String getFotoAsta() {
		return fotoAsta;
	}

	public void setFotoAsta(String fotoAsta) {
		this.fotoAsta = fotoAsta;
	}

	public LocalTime getTimer() {
		return timer;
	}

	public void setTimer(LocalTime timer) {
		this.timer = timer;
	}

	public LocalTime getTimerReset() {
		return timerReset;
	}

	public void setTimerReset(LocalTime timerReset) {
		this.timerReset = timerReset;
	}

	public float getSogliaRialzo() {
		return sogliaRialzo;
	}

	public void setSogliaRialzo(float sogliaRialzo) {
		this.sogliaRialzo = sogliaRialzo;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate date) {
		this.dataFine = date;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getProprietario_FK() {
		return proprietario_FK;
	}

	public void setProprietario_FK(int proprietario_FK) {
		this.proprietario_FK = proprietario_FK;
	}





  

	
	
	
}