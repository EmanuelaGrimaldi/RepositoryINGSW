package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AstaRepository;

import java.io.IOException;
import java.util.List;

import entità.Asta;
import implementazione.AstaRepositoryImpl;

@SuppressWarnings("serial")
@WebServlet("/getAsteByTipologia")
public class getAsteByTipologia extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	public List<Asta> findByTipologia(String tipologia)
	{
		AstaRepository a = AstaRepositoryImpl.getInstance();
		List<Asta> lista = a.findByTipologia(tipologia);
		return lista;
	}
	
	
}
