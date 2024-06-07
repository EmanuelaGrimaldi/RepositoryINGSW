
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

	// NON SI PUO FARE ORA
	// @Test
	public void testUsoValoreNulloPerAstaATempoFisso()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta aPrima, aDopo;

		String tipologia = "astaTempoFisso", sogliaDiRialzo, timer, dataScadenza;
		Integer idAstaINT = 201, idVenditoreINT = 110;

		when(request.getParameter("tipoAsta")).thenReturn(tipologia);
		when(request.getParameter("idAsta")).thenReturn("");
		when(request.getParameter("idUtente")).thenReturn("");
		when(request.getParameter("nuovaSogliaRialzo")).thenReturn("");
		when(request.getParameter("nuovoTimer")).thenReturn("");
		when(request.getParameter("nuovoDataScadenza")).thenReturn("");

		aPrima = aRepo.findbyID(idAstaINT);

		try
		{
			new AggiornaMioProfiloServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}

		aDopo = aRepo.findbyID(idAstaINT);

		// Assert.assertTrue(uDopo.getGeolocalizzazione().equals(posizioneTest));
//			Assert.assertEquals(, aDopo.get);
//			Assert.assertTrue(aPrima.equals(aDopo.));
//			Assert.assertTrue(aPrima.equals(aDopo.);
//			Assert.assertTrue(aPrima..equals(aDopo.);

		// reset
		aRepo.update(aPrima);

	}

}
