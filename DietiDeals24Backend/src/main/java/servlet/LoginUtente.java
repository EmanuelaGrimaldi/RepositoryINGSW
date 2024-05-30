
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.UtenteRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import entità.Utente;
import implementazione.UtenteRepositoryImpl;

public class LoginUtente extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public LoginUtente()
	{
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Son passato per il doget");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		Utente utente = new Utente();
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setEmailUtente(request.getParameter("email"));
		utente.setPasswordUtente(request.getParameter("password"));

		utente.setDataNascita(LocalDate.parse(request.getParameter("dataDiNascita")));

		UtenteRepository utenteRepo = UtenteRepositoryImpl.getInstance();

		if (!utenteRepo.emailAlreadyExist(utente.getEmailUtente()))
		{

			request.setAttribute("utente", utente);
			request.getRequestDispatcher("IscrizioneUtenteParte2.jsp").forward(request, response);

		} else
		{

			// fare interface errore
			request.getRequestDispatcher("iscrizioneUtenteParte1.jsp").forward(request, response);

		}

	}

}

