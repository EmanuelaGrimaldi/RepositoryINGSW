package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import junit.framework.Assert;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import repository.AstaRepository;
import entità.Asta;
import implementazione.AstaRepositoryImpl;

 
class AddNuovaAstaServletTest extends Mockito
{

	// FATTO	
	@Test
	public void testCreaClasseAstaAllIngleseConValoriNellaNorma()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta asta = null;
		List<Asta> listAsta;
		
		Integer idU = 101, 
				sogliaRialzo = 18,
				offertaIniziale = 4;
		
		String titoloAsta = "Nuova Asta", 
				descrizione = "Un set di Aggeggi Elettronici per una casa Domotica",
				categoria = "Elettronica";

		
		String tipologiaAsta = "astaInglese",
				timer = "19:18:17";
		
		when(request.getParameter("idUtente")).thenReturn(idU.toString());
		when(request.getParameter("tipologia")).thenReturn(tipologiaAsta);
		when(request.getParameter("titoloAsta")).thenReturn(titoloAsta);
		when(request.getParameter("descrizione")).thenReturn(descrizione);
		when(request.getParameter("categoria")).thenReturn(categoria);
		when(request.getParameter("baseAsta")).thenReturn(offertaIniziale.toString());
		when(request.getParameter("sogliaRialzo")).thenReturn(sogliaRialzo.toString());
		when(request.getParameter("timer")).thenReturn(timer);
		
		when(request.getRequestDispatcher("indexLoggato.jsp?idUtente=" + idU))
				.thenAnswer(RETURNS_MOCKS);
		
		try
		{
			new AddNuovaAstaServlet().doPost(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}
		
		listAsta = aRepo.findAstaByProprietarioFK(idU);
		for (Asta a : listAsta)
		{
			if(a.getTitolo().equals(titoloAsta))
			{
				asta = a;
				break;
			}
		}		
		
		Assert.assertEquals(asta.getTipologia(), tipologiaAsta);
		Assert.assertEquals(asta.getTitolo(), tipologiaAsta);
		Assert.assertEquals(asta.getDescrizione(), descrizione);
		Assert.assertEquals(asta.getCategoria(), categoria);
		Assert.assertEquals(asta.getOffertaIniziale(), offertaIniziale.floatValue());
		Assert.assertEquals(asta.getSogliaRialzo(), sogliaRialzo.floatValue());
			
		// reset
		aRepo.delete(asta);
		Assert.assertTrue( aRepo.findbyID(asta.getID()) == null );
	}
	
	// FATTO
	@Test
	public void testCreaClasseAstaATempoFissoConValoriNellaNorma()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta asta = null;
		List<Asta> listAsta;

		Integer idU = 101, 
				offertaIniziale = 4;
		
		String titoloAsta = "Nuova Asta", 
				descrizione = "Un set di Aggeggi Elettronici per una casa Domotica",
				categoria = "Elettronica";

		
		String dataFine = "2024-11-23", 
				tipologiaAsta = "astaTempoFisso";
		
		when(request.getParameter("idUtente")).thenReturn(idU.toString());
		when(request.getParameter("tipologia")).thenReturn(tipologiaAsta);
		when(request.getParameter("titoloAsta")).thenReturn(titoloAsta);
		when(request.getParameter("descrizione")).thenReturn(descrizione);
		when(request.getParameter("categoria")).thenReturn(categoria);
		when(request.getParameter("baseAsta")).thenReturn(offertaIniziale.toString());
		when(request.getParameter("dataScadenza")).thenReturn(dataFine);

		when(request.getRequestDispatcher("indexLoggato.jsp?idUtente=" + idU))
				.thenAnswer(RETURNS_MOCKS);
		
		try
		{
			new AddNuovaAstaServlet().doPost(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}
		
		listAsta = aRepo.findAstaByProprietarioFK(idU);
		for (Asta a : listAsta)
		{
			if(a.getTitolo().equals(titoloAsta))
			{
				asta = a;
				break;
			}
		}

		Assert.assertEquals(asta.getTipologia(), tipologiaAsta);
		Assert.assertEquals(asta.getTitolo(), tipologiaAsta);
		Assert.assertEquals(asta.getDescrizione(), descrizione);
		Assert.assertEquals(asta.getCategoria(), categoria);
		Assert.assertEquals(asta.getOffertaIniziale(), offertaIniziale.floatValue());
		Assert.assertEquals(asta.getDataFine().toString(), dataFine);
		
		// reset
		aRepo.delete(asta);
		Assert.assertTrue( aRepo.findbyID(asta.getID()) == null );
	}

}



















