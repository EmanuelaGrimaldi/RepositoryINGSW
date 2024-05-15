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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_notifiche", nullable = false)
	private int ID_notofiche;
	
	@Column(name = "testo", nullable = false, length = 50)
	private String testo;
	
}