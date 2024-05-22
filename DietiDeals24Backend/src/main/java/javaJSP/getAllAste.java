package javaJSP;

import java.util.List;
import entità.Asta;
import implementazione.AstaRepositoryImpl;
import repository.AstaRepository;

public class getAllAste {
	
	private AstaRepository astarepository;
	int i;
	List<Asta> listaAsta;
	
	public List<Asta> getAllAsteFunction() {
		
		astarepository = AstaRepositoryImpl.getInstance();		
		listaAsta = astarepository.findAll();
		i = 0;
		
		/*do {
			out.println("<div class='flex-diviso2 cell'><div><h1>" + listaAsta.get(i).getTitolo() + ":</h1><h2>Nome venditore:" + 
					listaAsta.get(i).getVenditore() + "</h2><h2>Descrizione Merce:</h2><p>" + listaAsta.get(i).getDescrizione() +
					"</p></div><img src=" + listaAsta.get(i).getFotoProfilo() + "alt='Immagine prodotto'class='immagineAsta'></div>");
			i++;
		}while(listaAsta.get(i) != null);
		
		for(Asta a : listaAsta)
		{
			
			System.out.println(	"<div class='flex-diviso2 cell'><div><h1>" + a.getTitolo() +
								":</h1><h2>Nome venditore:" + a.getVenditore() + 
								"</h2><h2>Descrizione Merce:</h2><p>" + a.getDescrizione() +
								"</p></div><img src=" + a.getFotoProfilo() + 
								"alt='Immagine prodotto'class='immagineAsta'></div>"
								);
		
		}
		*/
	return listaAsta;
	}
	

}

