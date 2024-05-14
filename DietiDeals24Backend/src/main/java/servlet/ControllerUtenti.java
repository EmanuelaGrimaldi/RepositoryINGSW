package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import repository.UtenteRepository;
import entità.Utente;
import implementazione.UtenteRepositoryImpl;

@SuppressWarnings("serial")

@WebServlet("/ControllerUtenti")
public class ControllerUtenti extends HttpServlet {
	
	
	private UtenteRepository utenterepository;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		
		pw.println("Ora stampo tutta la lista degli utenti nel DB:");
		
		System.out.println("Pre riga problematica");
		utenterepository = UtenteRepositoryImpl.getInstance();	
		System.out.println("AAAA DOPO riga problematica");
		
		List<Utente> listaUtenti = utenterepository.findAll();
		
		
		System.out.println(listaUtenti);
		pw.println(listaUtenti.toString());
		
		//POTENZIALE COMANDO: resquest.getRequestDispatcher("/index.jsp").forward(request,response);
		
	}


}
