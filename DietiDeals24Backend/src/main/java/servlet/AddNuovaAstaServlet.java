package servlet;

import jakarta.servlet.ServletException;
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
import java.util.Calendar;
import entità.Asta;
import implementazione.AstaRepositoryImpl;

public class AddNuovaAstaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int IDCountAsta = 240;
	Date dataFine;
	Time timer;
       
    public AddNuovaAstaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Asta a = (Asta) request.getSession().getAttribute("asta");
			
		a.setTitolo((String) request.getParameter("titoloAsta"));
		a.setDescrizione((String) request.getParameter("descrizione"));
		a.setCategoria((String) request.getParameter("categoria"));
		a.setTipologia((String) request.getParameter("tipologia"));

		Calendar calendar = Calendar.getInstance();
		Date currentDate = (Date) calendar.getTime(); 
		a.setDataInizio(currentDate);
		a.setOffertaIniziale(Integer.valueOf(request.getParameter("baseAsta")));
		a.setOffertaPiuAlta(Integer.valueOf(request.getParameter("baseAsta")));
		a.setIDOffertaPiuAlta(0);
		 //a.setFotoAsta1((String) request.getAttribute("fotoProfilo"));
		
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("00:00:00");
		LocalTime time = LocalTime.parse(request.getParameter("timer"), formatterTime );
		a.setTimer(time);
		
		a.setSogliaRialzo(Integer.valueOf(request.getParameter("sogliaRialzo")));
	
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy:mm:dd");
		LocalDate date = LocalDate.parse(request.getParameter("date"), formatterDate );
		a.setDataFine(date);

		a.setID(IDCountAsta);
		IDCountAsta++;
		int idUtenteINT = Integer.valueOf(request.getParameter("idUtente"));
		
		a.setProprietario_FK(idUtenteINT);
		
		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		aRepo.save(a);
		
		request.getRequestDispatcher("profiloUtenteLoggato.jsp?idUtente=" + idUtenteINT).forward(request, response);
		
	}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
