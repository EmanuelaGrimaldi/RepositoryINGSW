package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import entità.Asta;
import repository.AstaRepository;
import implementazione.AstaRepositoryImpl;

@SuppressWarnings("serial")
@WebServlet("/getAsteHome")
public class getAsteHome extends HttpServlet {
       
	private AstaRepository astarepository;
	int i;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		PrintWriter pw = response.getWriter();

		astarepository = AstaRepositoryImpl.getInstance();		
		
		//qua ho lasciato una find all, ma va implementata una funzione dove selezionano solo determinate aste.
		List<Asta> listaAsta = astarepository.findAll();
		//request.setAttribute("listaAsta", listaAsta);
		
		i = 0;
		
		for(Asta a : listaAsta)
		{
			
			System.out.println(	"<div class='flex-diviso2 cell'><div><h1>" + a.getTitolo() +
								":</h1><h2>Nome venditore:" + a.getProprietario_FK() + 
								"</h2><h2>Descrizione Merce:</h2><p>" + a.getDescrizione() +
								"</p></div><img src=" + a.getFotoAsta1() + 
								"alt='Immagine prodotto'class='immagineAsta'></div>"
								);
		
		}
		//request.getRequestDispatcher("/home.jsp").forward(request, response);
		
	}
	
	public List<Asta> findAsteInScadenza()
	{
		AstaRepository a = AstaRepositoryImpl.getInstance();
		List<Asta> lista = a.findAsteInScadenza();
		return lista;
	}
}
