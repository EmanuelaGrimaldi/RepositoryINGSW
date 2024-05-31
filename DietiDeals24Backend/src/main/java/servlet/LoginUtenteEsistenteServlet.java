package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.UtenteRepository;
import java.io.IOException;
import java.io.PrintWriter;

import entità.Utente;
import implementazione.UtenteRepositoryImpl;

@WebServlet("/LoginUtenteEsistenteServlet")
public class LoginUtenteEsistenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginUtenteEsistenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Utente u = new Utente();
		
		u.setEmailUtente((String) request.getParameter("inputEmail"));
		u.setPasswordUtente((String) request.getParameter("inputPassword"));
		
		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();
		Utente utenteDB = uRepo.findByEmail(u.getEmailUtente());
			
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	 
		if (utenteDB == null) {
			out.println("<h5>ATTENZIONE!L'email non è presente nel nostro sistema.</h5>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		} else if (utenteDB.getPasswordUtente().compareTo(u.getPasswordUtente()) == 0) {
			request.getRequestDispatcher("indexLoggato.jsp?idUtente=" + utenteDB.getID_Utente()).forward(request, response);
			
		} else {
			out.println("<h5>ATTENZIONE!La password non è corretta.</h5>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		out.close();
	}

}
