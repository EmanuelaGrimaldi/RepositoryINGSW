
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.UtenteRepository;

import java.io.IOException;

import entità.Utente;
import implementazione.UtenteRepositoryImpl;

public class LoginUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginUtente() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Son passato per il doget");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utente utente = new Utente();
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setEmailUtente(request.getParameter("email"));
		utente.setPasswordUtente(request.getParameter("password"));
		// utente.setDataDiNascita ma non c'è

		// per ora è questo ma poi si cambia in base all'esigenza.
		String profiloVenditore_site = "/DietiDeals24Backend/src/main/webapp/profiloVenditore.jsp";
		String errore_site = "/DietiDeals24Backend/src/main/webapp/login.jsp";

		UtenteRepository utenteRepo = UtenteRepositoryImpl.getInstance();

		if (!utenteRepo.emailAlreadyExist(utente.getEmailUtente())) {
			// il tipo non esisite gia e si puo continuare con l'iscrizione
			request.setAttribute("utente", utente);
			request.getRequestDispatcher("IscrizioneUtenteParte2.jsp").forward(request, response);
		} else {
			// che faccio quando mette una email gia presente?
			request.getRequestDispatcher("iscrizioneUtenteParte1.jsp").forward(request, response);
			// parte la notifica / siconola il testo idk
		}

		/*
		 * if(!utenteRepo.emailAlreadyExist(utente.getEmailUtente())) {
		 * utenteRepo.save(utente); response.setStatus(response.SC_ACCEPTED);
		 * response.setHeader("Location", profiloVenditore_site);
		 * response.sendRedirect(profiloVenditore_site); } else {
		 * response.setStatus(response.SC_UNAUTHORIZED); response.setHeader("Location",
		 * errore_site); response.sendRedirect(errore_site); }
		 */

	}

}
