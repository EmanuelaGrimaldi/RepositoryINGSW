
package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import junit.framework.Assert;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import repository.AstaRepository;
import entità.Asta;
import implementazione.AstaRepositoryImpl;

class AggiornaMiaAstaServletTest extends Mockito
{



	// FATTO
	@Test
	public void testSettoSogliaRialzoMinoreDi1PerAstaAllInglese() 
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta aPrima, aDopo;
		
		String tipologia = "astaInglese";
		Integer idAstaINT = 201, idVenditoreINT = 110, sogliaDiRialzo = -1;

		String timer = "";
		String dataScadenza = "";
		
		aPrima = aRepo.findbyID(idAstaINT);		
		
		when(request.getParameter("tipoAsta")).thenReturn(tipologia);
		when(request.getParameter("idAsta")).thenReturn(idAstaINT.toString());
		when(request.getParameter("idUtente")).thenReturn(idVenditoreINT.toString());
		when(request.getParameter("nuovaSogliaRialzo")).thenReturn(sogliaDiRialzo.toString());
		when(request.getParameter("nuovoTimer")).thenReturn(timer);
		when(request.getParameter("nuovoDataScadenza")).thenReturn(dataScadenza);

		when(request.getRequestDispatcher("MiaAstaLoggato.jsp?idAsta=" + idAstaINT + "&&idUtente=" + idVenditoreINT))
				.thenAnswer(RETURNS_MOCKS);

		try
		{
			new AggiornaMiaAstaServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}

		aDopo = aRepo.findbyID(idAstaINT);

		Assert.assertNotSame(aPrima.getSogliaRialzo(), aDopo.getSogliaRialzo());
		System.out.println("\n\n"+aPrima.getSogliaRialzo() +"\n"+aDopo.getSogliaRialzo());

		// reset
		aRepo.update(aPrima);

	}
	
	// FATTO
	@Test 
	public void testSettoDataDiFineMinoreAQuellaOdiernaPerAstaATempoFisso() 
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta aPrima, aDopo;

		String tipologia = "astaATempoFisso";
		Integer idAstaINT = 201, idVenditoreINT = 110;
		String sogliaDiRialzo = "";

		String timer = "";
		String dataScadenza = "2023-02-22";

		when(request.getParameter("tipoAsta")).thenReturn(tipologia);
		when(request.getParameter("idAsta")).thenReturn(idAstaINT.toString());
		when(request.getParameter("idUtente")).thenReturn(idVenditoreINT.toString());
		when(request.getParameter("nuovaSogliaRialzo")).thenReturn(sogliaDiRialzo.toString());
		when(request.getParameter("nuovoTimer")).thenReturn(timer);
		when(request.getParameter("nuovoDataScadenza")).thenReturn(dataScadenza);

		when(request.getRequestDispatcher("MiaAstaLoggato.jsp?idAsta=" + idAstaINT + "&&idUtente=" + idVenditoreINT))
				.thenAnswer(RETURNS_MOCKS);

		aPrima = aRepo.findbyID(idAstaINT);

		try
		{
			new AggiornaMiaAstaServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}

		aDopo = aRepo.findbyID(idAstaINT);

		Assert.assertNotSame(aPrima.getDataFine(), aDopo.getDataFine());
		System.out.println(aPrima.getDataFine()+"\n"+ aDopo.getDataFine());
		
		// reset
		aRepo.update(aPrima);

	}
	
	// FATT
	@Test 
	public void testSettoValoriNulliPerAstaAllInglese()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta aPrima, aDopo;

		String tipologia = "astaInglese";
		Integer idAstaINT = 201, idVenditoreINT = 110;
		String sogliaDiRialzo = "";

		String timer = "";
		String dataScadenza = "";

		when(request.getParameter("tipoAsta")).thenReturn(tipologia);
		when(request.getParameter("idAsta")).thenReturn(idAstaINT.toString());
		when(request.getParameter("idUtente")).thenReturn(idVenditoreINT.toString());
		when(request.getParameter("nuovaSogliaRialzo")).thenReturn(sogliaDiRialzo.toString());
		when(request.getParameter("nuovoTimer")).thenReturn(timer);
		when(request.getParameter("nuovoDataScadenza")).thenReturn(dataScadenza);

		when(request.getRequestDispatcher("MiaAstaLoggato.jsp?idAsta=" + idAstaINT + "&&idUtente=" + idVenditoreINT))
				.thenAnswer(RETURNS_MOCKS);

		aPrima = aRepo.findbyID(idAstaINT);

		try
		{
			new AggiornaMiaAstaServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}

		aDopo = aRepo.findbyID(idAstaINT);

		Assert.assertEquals(aPrima.getSogliaRialzo(), aDopo.getSogliaRialzo());
		Assert.assertEquals(aPrima.getTimer(), aDopo.getTimer());
		Assert.assertEquals(aPrima.getDataFine(), aDopo.getDataFine());

		// reset
		aRepo.update(aPrima);

	}
	
	// FATTO
	@Test
	public void testSettoNuovoTimerDiversoDaQuelloCorrenteENuovoTimerMaggioreDi0PerAstaAllInglese()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta aPrima, aDopo;

		String tipologia = "astaInglese";
		Integer idAstaINT = 201, idVenditoreINT = 110, sogliaDiRialzo = 200;

		LocalTime t = LocalTime.of(0, 0, 0);

		String timer = "10:09:30";
		String dataScadenza = "2040-10-10";

		when(request.getParameter("tipoAsta")).thenReturn(tipologia);
		when(request.getParameter("idAsta")).thenReturn(idAstaINT.toString());
		when(request.getParameter("idUtente")).thenReturn(idVenditoreINT.toString());
		when(request.getParameter("nuovaSogliaRialzo")).thenReturn(sogliaDiRialzo.toString());
		when(request.getParameter("nuovoTimer")).thenReturn(timer);
		when(request.getParameter("nuovoDataScadenza")).thenReturn(dataScadenza);
		when(request.getRequestDispatcher("MiaAstaLoggato.jsp?idAsta=" + idAstaINT + "&&idUtente=" + idVenditoreINT))
				.thenAnswer(RETURNS_MOCKS);

		aPrima = aRepo.findbyID(idAstaINT);

		try
		{
			new AggiornaMiaAstaServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}

		aDopo = aRepo.findbyID(idAstaINT);

		Assert.assertFalse(aDopo.getTimer().equals(aPrima.getTimer()));
		Assert.assertFalse(aDopo.getTimer().equals(t));

		// reset
		aRepo.update(aPrima);
	}

	// FATTO
	@Test
	public void testSettoNuovaSogliaDiRialzoMaggioreDi0ENuovoTimerMaggioreDi0PerAstaAllInglese()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta aPrima, aDopo;

		String tipologia = "astaInglese";
		Integer idAstaINT = 201, idVenditoreINT = 110, sogliaDiRialzo = 200;

		LocalTime t = LocalTime.of(0, 0, 0);

		String timer = "10:09:30";
		String dataScadenza = "2040-10-10";

		when(request.getParameter("tipoAsta")).thenReturn(tipologia);
		when(request.getParameter("idAsta")).thenReturn(idAstaINT.toString());
		when(request.getParameter("idUtente")).thenReturn(idVenditoreINT.toString());
		when(request.getParameter("nuovaSogliaRialzo")).thenReturn(sogliaDiRialzo.toString());
		when(request.getParameter("nuovoTimer")).thenReturn(timer);
		when(request.getParameter("nuovoDataScadenza")).thenReturn(dataScadenza);
		when(request.getRequestDispatcher("MiaAstaLoggato.jsp?idAsta=" + idAstaINT + "&&idUtente=" + idVenditoreINT))
				.thenAnswer(RETURNS_MOCKS);

		aPrima = aRepo.findbyID(idAstaINT);

		try
		{
			new AggiornaMiaAstaServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}

		aDopo = aRepo.findbyID(idAstaINT);

		Assert.assertTrue(aDopo.getSogliaRialzo() > 0);
		Assert.assertTrue(aDopo.getTimer().isAfter(t));

		// reset
		aRepo.update(aPrima);
	}

	// FATTO
	@Test
	public void testSettoNuovaDataScadenzaMaggioreDiQUellaAttualeEDIversaDallaPRecedentePerAstaATempoFisso()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta aPrima, aDopo;

		Integer idAstaINT = 201, idVenditoreINT = 110, sogliaDiRialzo = 200;
		String tipologia = "astaTempoFisso";

		String tempo = "";
		String data = "2024-09-27";

		aPrima = aRepo.findbyID(idAstaINT);

		when(request.getParameter("tipoAsta")).thenReturn(tipologia);
		when(request.getParameter("idAsta")).thenReturn(idAstaINT.toString());
		when(request.getParameter("idUtente")).thenReturn(idVenditoreINT.toString());
		when(request.getParameter("nuovaSogliaRialzo")).thenReturn(sogliaDiRialzo.toString());
		when(request.getParameter("nuovoTimer")).thenReturn(tempo);
		when(request.getParameter("nuovoDataScadenza")).thenReturn(data);

		when(request.getRequestDispatcher("MiaAstaLoggato.jsp?idAsta=" + idAstaINT + "&&idUtente=" + idVenditoreINT))
				.thenAnswer(RETURNS_MOCKS);

		try
		{
			new AggiornaMiaAstaServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}

		aDopo = aRepo.findbyID(idAstaINT);

//		{(nuovaDataScadenza > currDate) && (nuovaDataScadenza != dataScadenzaCorrente)}VALIDO
		Assert.assertTrue(aDopo.getDataFine().isAfter(LocalDate.now()));
		Assert.assertFalse(aDopo.getDataFine().equals(aPrima.getDataFine()));

		// reset
		aRepo.update(aPrima);
	}

	// FATTO
	@Test
	public void testUsoValoreNulloPerAstaATempoFisso()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta aPrima, aDopo;

		String tipologia = "astaATempoFisso";
		Integer idAstaINT = 201, idVenditoreINT = 110;
		String sogliaDiRialzo = "";

		String timer = "";
		String dataScadenza = "";

		when(request.getParameter("tipoAsta")).thenReturn(tipologia);
		when(request.getParameter("idAsta")).thenReturn(idAstaINT.toString());
		when(request.getParameter("idUtente")).thenReturn(idVenditoreINT.toString());
		when(request.getParameter("nuovaSogliaRialzo")).thenReturn(sogliaDiRialzo.toString());
		when(request.getParameter("nuovoTimer")).thenReturn(timer);
		when(request.getParameter("nuovoDataScadenza")).thenReturn(dataScadenza);

		when(request.getRequestDispatcher("MiaAstaLoggato.jsp?idAsta=" + idAstaINT + "&&idUtente=" + idVenditoreINT))
				.thenAnswer(RETURNS_MOCKS);

		aPrima = aRepo.findbyID(idAstaINT);

		try
		{
			new AggiornaMiaAstaServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}

		aDopo = aRepo.findbyID(idAstaINT);

		Assert.assertEquals(aPrima.getSogliaRialzo(), aDopo.getSogliaRialzo());
		Assert.assertEquals(aPrima.getTimer(), aDopo.getTimer());
		Assert.assertEquals(aPrima.getDataFine(), aDopo.getDataFine());

		// reset
		aRepo.update(aPrima);

	}

}
