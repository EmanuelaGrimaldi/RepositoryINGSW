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

import entità.Asta;
import implementazione.AstaRepositoryImpl;

@WebServlet("/AggiornaMiaAstaServlet")
public class AggiornaMiaAstaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AggiornaMiaAstaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tipologia = request.getParameter("tipoAsta");
		int idAstaINT = Integer.valueOf(request.getParameter("idAsta"));
		int idVenditoreINT = Integer.valueOf(request.getParameter("idUtente"));
		String stringa;
		Date nuovaDataScadenza;
		Time nuovoTimer;
		
		AstaRepository aRepo = AstaRepositoryImpl.getInstance();	
		Asta a = aRepo.findbyID(idAstaINT);
		
		if (tipologia.equals("astaInglese")) {
			
			stringa = request.getParameter("nuovaSogliaRialzo");
			
			if (!stringa.isEmpty()){
				a.setSogliaRialzo(Integer.valueOf(stringa));	
			}
			
			stringa = request.getParameter("nuovoTimer");
			
			if (!stringa.isEmpty()){
				DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("00:00:00");
				LocalTime time = LocalTime.parse(stringa, formatterTime );
				a.setTimer(time);	
			}
			
		}else {
			
			stringa = request.getParameter("nuovoDataScadenza");
			
			if (!stringa.isEmpty()){
				DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy:mm:dd");
				LocalDate date = LocalDate.parse(stringa, formatterDate );
				a.setDataFine(date);	
			}
		}
		
		aRepo.update(a);
		
		request.getRequestDispatcher("MiaAstaLoggato.jsp?idAsta=" + idAstaINT + "&&idUtente=" + idVenditoreINT).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
