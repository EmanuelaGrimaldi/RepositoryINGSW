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

 
public class Login_quelloVero extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login_quelloVero() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// controlla
		// se ok vai avanti come dice l' emy-commento jsp 
		// se no tonra errore/ricarica pagina/ messaggio d'errore/ boh
		
		
		Utente user = new Utente();
		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();
		
		user.setID_Utente(Integer.parseInt(request.getParameter("idUtente")));
		user.setPasswordUtente( request.getParameter("password"));
		
		
		//if( uRepo.  )

		//utente.setNome(request.getParameter("nome"));
		
		
	}

}


