package entità;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Asta")
public class Asta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	public int ID;
	
	@Column(name = "Titolo", nullable = false, length = 30)
	private String titolo;
	
	@Column(name = "Descrizione", nullable = true, length = 130)
	private String descrizione;
	
	@Column(name = "Categoria", nullable = false, length = 30)
	private String categoria;
	
	@Column(name = "Tipologia", nullable = false, length = 30)
	private String tipologia;

	@Column(name = "DataInizio", nullable = false)
	private Date dataInizio;

	@Override
	public String toString() {
		return "Asta [ID=" + ID + ", titolo=" + titolo + ", descrizione=" + descrizione + ", categoria=" + categoria
				+ ", tipologia=" + tipologia + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", venditore="
				+ venditore + ", listaConcorrenti=" + listaConcorrenti + ", offertaPiuAlta=" + offertaPiuAlta
				+ ", fotoProfilo=" + fotoProfilo + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

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

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public int getVenditore() {
		return venditore;
	}

	public void setVenditore(int venditore) {
		this.venditore = venditore;
	}

	public String getListaConcorrenti() {
		return listaConcorrenti;
	}

	public void setListaConcorrenti(String listaConcorrenti) {
		this.listaConcorrenti = listaConcorrenti;
	}

	public float getOffertaPiuAlta() {
		return offertaPiuAlta;
	}

	public void setOffertaPiuAlta(float offertaPiuAlta) {
		this.offertaPiuAlta = offertaPiuAlta;
	}

	public String getFotoProfilo() {
		return fotoProfilo;
	}

	public void setFotoProfilo(String fotoProfilo) {
		this.fotoProfilo = fotoProfilo;
	}

	@Column(name = "DataFine", nullable = false)
	private Date dataFine;
	 
	@Column(name = "Venditore", nullable = false)
	private int venditore;
			   
	@Column(name = "ListaConcorrenti", nullable = false, length = 400)
	private String listaConcorrenti;
	 
	@Column(name = "OffertaPiuAlta", nullable = false)
	private float offertaPiuAlta;
	   
	@Column(name = "FotoProfilo", nullable = true, length = 300)
	private String fotoProfilo;
	
	
	//@OneToMany Connection con le aste
}