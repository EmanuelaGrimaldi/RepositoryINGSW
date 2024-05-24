package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AstaRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import entità.Asta;
import entità.Utente;
import implementazione.AstaRepositoryImpl;
import implementazione.UtenteRepositoryImpl;

@SuppressWarnings("serial")
@WebServlet("/getAsteByCategoria")
public class getAsteByCategoria extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {	
	}

	public List<Asta> findByCategoria(String categoria)
	{
		AstaRepository a = AstaRepositoryImpl.getInstance();
		List<Asta> lista = a.findByCategoria(categoria);
		return lista;
	}
	

}
