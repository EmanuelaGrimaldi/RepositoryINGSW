package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AstaRepository;

import java.io.IOException;

import implementazione.AstaRepositoryImpl;

@WebServlet("/EliminaMiaAstaServlet")
public class EliminaMiaAstaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public EliminaMiaAstaServlet()
	{
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		response.getWriter().append("Served at: ").append(request.getContextPath()); // non so cosa faccia questo hahah
		int idUtenteINT = Integer.valueOf(request.getParameter("idUtente"));
		String idA = request.getParameter("idAsta");
		
		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		aRepo.deletebyID(Integer.parseInt(idA));
		
		
		request.getRequestDispatcher("profiloUtenteLoggato.jsp?idUtente=" + idUtenteINT).forward(request, response);
	}

}
