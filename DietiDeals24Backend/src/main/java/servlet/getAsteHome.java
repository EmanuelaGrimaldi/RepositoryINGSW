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
		
		//per comodità mi sto prendendo la propic del venditore invece che la foto asta, perché ci manca come valore.
		/*
		 * do { pw.println("<div class='flex-diviso2 cell'><div><h1>" +
		 * listaAsta.get(i).getTitolo() + ":</h1><h2>Nome venditore:" +
		 * listaAsta.get(i).getVenditore() + "</h2><h2>Descrizione Merce:</h2><p>" +
		 * listaAsta.get(i).getDescrizione() + "</p></div><img src=" +
		 * listaAsta.get(i).getFotoProfilo() +
		 * "alt='Immagine prodotto'class='immagineAsta'></div>"); i++;
		 * }while(listaAsta.get(i) != null);
		 */
		for(Asta a : listaAsta)
		{
			
			System.out.println(	"<div class='flex-diviso2 cell'><div><h1>" + a.getTitolo() +
								":</h1><h2>Nome venditore:" + a.getVenditore() + 
								"</h2><h2>Descrizione Merce:</h2><p>" + a.getDescrizione() +
								"</p></div><img src=" + a.getFotoProfilo() + 
								"alt='Immagine prodotto'class='immagineAsta'></div>"
								);
		
		}
	
		//request.getRequestDispatcher("/home.jsp").forward(request, response);
		
	}
}
