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

public class LoginUtente2Servlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	int IDcount = 115;

	public LoginUtente2Servlet()
	{
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		Utente u = (Utente) request.getSession().getAttribute("utente");

		u.setFotoProfilo((String) request.getParameter("https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/man-user-circle-icon.png"));
		u.setBiografia((String) request.getParameter("biografia"));
		u.setGeolocalizzazione((String) request.getParameter("posizioneGeografica"));
		u.setLinkSocial((String) request.getParameter("social"));
		u.setID_Utente(IDcount);

		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();

		uRepo.save(u);

		request.getRequestDispatcher("indexLoggato.jsp?idUtente=" + IDcount).forward(request, response);
		IDcount++;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

}

