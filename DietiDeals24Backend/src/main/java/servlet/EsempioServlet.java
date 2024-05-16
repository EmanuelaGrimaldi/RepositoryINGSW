package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import entità.Utente;
import repository.UtenteRepository;
import implementazione.UtenteRepositoryImpl;

@SuppressWarnings("serial")
@WebServlet("/EsempioServlet")
public class EsempioServlet extends HttpServlet {
	
	
	private UtenteRepository utenterepository;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		
		pw.println("Ora stampo tutta la lista degli utenti nel DB:");
		
		utenterepository = UtenteRepositoryImpl.getInstance();	
		List<Utente> listaUtenti = utenterepository.findAll();
		
		pw.println(listaUtenti.toString());
		
		//POTENZIALE COMANDO: resquest.getRequestDispatcher("/index.jsp").forward(request,response);
		
	}


}
