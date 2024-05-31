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

@WebServlet("/LoginUtenteEsistenteServlet")
public class LoginUtenteEsistenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginUtenteEsistenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utente u = new Utente();
		
		u.setEmailUtente((String) request.getParameter("inputEmail"));
		u.setPasswordUtente((String) request.getParameter("inputPassword"));
		
		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();
		Utente utenteDB = uRepo.findByEmail(u.getEmailUtente());
		
		if (utenteDB == null) {
			//request.getRequestDispatcher("login.jsp?idErrore=2").forward(request, response); però con "email errata"
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
		if (utenteDB.getPasswordUtente().compareTo(u.getPasswordUtente()) == 0) {
			request.getRequestDispatcher("indexLoggato.jsp?idUtente=" + utenteDB.getID_Utente()).forward(request, response);
		} else {
			//request.getRequestDispatcher("login.jsp?idErrore=1").forward(request, response); "psw errata"
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
