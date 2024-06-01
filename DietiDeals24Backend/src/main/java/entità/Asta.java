package entità;


import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	
	@Column(name = "fotoasta1", nullable = true, length = 500)
	private String fotoAsta1;
	
	@Column(name = "fotoasta2", nullable = true, length = 500)
	private String fotoAsta2;
	
	@Column(name = "fotoasta3", nullable = true, length = 500)
	private String fotoAsta3;
	
	@Column(name = "fotoasta4", nullable = true, length = 500)
	private String fotoAsta4;
	
	@Column(name = "fotoasta5", nullable = true, length = 500)
	private String fotoAsta5;
	
	
	//Per_aste_inglesi
	
	@Column(name = "timer", nullable = true)
	private LocalTime timer;
	
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

	public String getFotoAsta1() {
		return fotoAsta1;
	}

	public void setFotoAsta1(String fotoAsta1) {
		this.fotoAsta1 = fotoAsta1;
	}

	public String getFotoAsta2() {
		return fotoAsta2;
	}

	public void setFotoAsta2(String fotoAsta2) {
		this.fotoAsta2 = fotoAsta2;
	}

	public String getFotoAsta3() {
		return fotoAsta3;
	}

	public void setFotoAsta3(String fotoAsta3) {
		this.fotoAsta3 = fotoAsta3;
	}

	public String getFotoAsta4() {
		return fotoAsta4;
	}

	public void setFotoAsta4(String fotoAsta4) {
		this.fotoAsta4 = fotoAsta4;
	}

	public String getFotoAsta5() {
		return fotoAsta5;
	}

	public void setFotoAsta5(String fotoAsta5) {
		this.fotoAsta5 = fotoAsta5;
	}

	public String getTimer() {
		return timer.toString();
	}

	public void setTimer(LocalTime time) {
		this.timer = time;
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

	@Override
	public String toString() {
		return "Asta [titolo=" + titolo + ", descrizione=" + descrizione + ", categoria=" + categoria + ", tipologia="
				+ tipologia + ", dataInizio=" + dataInizio + ", offertaIniziale=" + offertaIniziale
				+ ", offertaPiuAlta=" + offertaPiuAlta + ", IDOffertaPiuAlta=" + IDOffertaPiuAlta + ", fotoAsta1="
				+ fotoAsta1 + ", fotoAsta2=" + fotoAsta2 + ", fotoAsta3=" + fotoAsta3 + ", fotoAsta4=" + fotoAsta4
				+ ", fotoAsta5=" + fotoAsta5 + ", timer=" + timer + ", sogliaRialzo=" + sogliaRialzo + ", dataFine="
				+ dataFine + ", ID=" + ID + ", proprietario_FK=" + proprietario_FK + "]";
	}  

	
	
	
}