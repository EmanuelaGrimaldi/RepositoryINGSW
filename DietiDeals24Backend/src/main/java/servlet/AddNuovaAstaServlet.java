package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AstaRepository;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import entità.Asta;
import implementazione.AstaRepositoryImpl;

@WebServlet("/AddNuovaAstaServlet")
public class AddNuovaAstaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	int IDCountAsta = 260;
	Date dataFine;
	Time timer;
	Asta a = new Asta();
       
    public AddNuovaAstaServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idUtenteINT = Integer.valueOf(request.getParameter("idUtente"));
		String tipologiaAsta = (request.getParameter("tipologia"));
		LocalDate date = LocalDate.now();
		LocalTime time;
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");	////// la string in jsp deve avere questa fomrattazione
		//DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
		a.setTitolo(request.getParameter("titoloAsta"));
		a.setDescrizione(request.getParameter("descrizione"));
		a.setCategoria(request.getParameter("categoria"));
		a.setTipologia(tipologiaAsta);
		a.setDataInizio(date);
		a.setOffertaIniziale(Integer.valueOf(request.getParameter("baseAsta")));
		a.setOffertaPiuAlta(Integer.valueOf(request.getParameter("baseAsta")));
		a.setIDOffertaPiuAlta(0);
		a.setFotoAsta("https://cdn-icons-png.flaticon.com/512/10982/10982466.png"); 
		
		
		
		if (tipologiaAsta.equals("astaInglese")) {
			
			time = LocalTime.parse(request.getParameter("timer"));//, formatterTime);

			a.setTimer(time);
			a.setSogliaRialzo(Integer.valueOf(request.getParameter("sogliaRialzo")));
			
			//data_fine null
			a.setDataFine(date);
			
			
		}else {
						
			System.out.println("\n\n\n\n\nIL PARAMETRO date E: " + request.getParameter("dataScadenza"));
			date = LocalDate.parse(request.getParameter("dataScadenza"));
			a.setDataFine(date);
			
			//timer_e_soglia_rialzo null
			time = LocalTime.parse("00:00:00");//, formatterTime );
			a.setTimer(time);
			a.setSogliaRialzo(0);
			a.setTipologia("astaTempoFisso");
			
		}
		
		int nuovoIDtrovato = 0;
		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		
		// ciclo inutile
		do {
			if(aRepo.findbyID(IDCountAsta) == null) {
				a.setID(IDCountAsta);
				nuovoIDtrovato++;
			}
		IDCountAsta++;
		} while(nuovoIDtrovato == 0);
		
		
		a.setProprietario_FK(idUtenteINT);
		
		aRepo.save(a);
		
		request.getRequestDispatcher("indexLoggato.jsp?idUtente=" + idUtenteINT).forward(request, response);
	}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
