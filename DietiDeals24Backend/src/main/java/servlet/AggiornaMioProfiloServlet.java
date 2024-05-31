package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AstaRepository;
import repository.UtenteRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import entità.Asta;
import entità.Utente;
import implementazione.AstaRepositoryImpl;
import implementazione.UtenteRepositoryImpl;

@WebServlet("/AggiornaMioProfiloServlet")
public class AggiornaMioProfiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AggiornaMioProfiloServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idVenditoreINT = Integer.valueOf(request.getParameter("idUtente"));
		
		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();	
		Utente u = uRepo.findbyID(idVenditoreINT);
		String temp;
		
		temp = request.getParameter("nuovaBiografia");
		
		if (temp != null) {
			u.setBiografia(temp);
		}
		
		temp = request.getParameter("nuovaPosizione");
		
		if (temp != null) {
			u.setGeolocalizzazione(temp);
		}
		
		temp = request.getParameter("nuovoSocial");
		
		if (temp != null) {
			u.setLinkSocial(temp);
		}
		
		temp = request.getParameter("nuovaEmail");
		
		if (temp != null) {
			u.setEmailUtente(temp);
		}
		
		uRepo.update(u);
		
		request.getRequestDispatcher("profiloUtenteLoggato.jsp?idUtente=" + idVenditoreINT).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
