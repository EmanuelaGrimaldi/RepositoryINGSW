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

public class LoginUtente2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginUtente2Servlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		Utente u = (Utente) request.getAttribute("utente");
		u.setFotoProfilo((String) request.getAttribute("fotoProfilo"));
		u.setBiografia((String) request.getAttribute("biografia"));
		u.setLinkSocial((String) request.getAttribute("social"));
		
		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();

		uRepo.save(u);

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
