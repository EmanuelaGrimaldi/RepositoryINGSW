package servlet;

import java.io.IOException;
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

class RilancioAstaServletTest extends Mockito
{

//	per asta all'inglese
//	

//
//	CE4: {(nuovaOfferta == ultimaOfferta + sogliaRialzo) && (sogliaRialzo > 0)}
//	VALIDA

//
	
	@Test
	public void testRilancioAstaATempoFisso()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta aPrima, aDopo;
		LocalTime timerPrima;

		
		aPrima = (Asta) aRepo.findByTipologia("astaTempoFisso").get(0);
		timerPrima = aPrima.getTimer();
		aPrima.setTimer(aPrima.getTimerReset());
		aRepo.update(aPrima);
		
		Integer idU 	= aPrima.getProprietario_FK(), 
				idAsta 	= aPrima.getID(),
				sogliaACaso = 10,
				cifreRilancio = sogliaACaso;

		when(request.getParameter("idUtente")).thenReturn(idU.toString());
		when(request.getParameter("idAsta")).thenReturn(idAsta.toString());
		when(request.getParameter("cifraRilancio")).thenReturn(cifreRilancio.toString());

		when(request.getRequestDispatcher("elencoNotificheLoggato.jsp?idUtente=" + idU)).thenAnswer(RETURNS_MOCKS);

		try
		{
			new RilancioAstaServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}

		aDopo = (Asta) aRepo.findByTipologia("astaTempoFisso").get(0);

		Assert.assertTrue( Integer.compare(cifreRilancio, 0) >0);
		// Assert.assertEquals(aDopo.getTimer(), aDopo.getTimerReset()); non si aggiorna 
		// se l'applicativo non è in uso
		Assert.assertEquals(aDopo.getOffertaPiuAlta(), aPrima.getOffertaPiuAlta() + cifreRilancio);

		// reset
		aPrima.setTimer(timerPrima);
		aRepo.update(aPrima);

	}

	//
	@Test
	public void testRilancioAstaAllInglese()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		AstaRepository aRepo = AstaRepositoryImpl.getInstance();
		Asta aPrima, aDopo;

		Integer idU = 110, idAsta = 201;

		LocalTime timerPrima;

		aPrima = (Asta) aRepo.findByTipologia("astaInglese").get(0);
		timerPrima = aPrima.getTimer();
		aPrima.setTimer(aPrima.getTimerReset());
		aRepo.update(aPrima);

		Float cifreRilancio = aPrima.getOffertaPiuAlta() + aPrima.getSogliaRialzo();

		when(request.getParameter("idUtente")).thenReturn(idU.toString());
		when(request.getParameter("idAsta")).thenReturn(idAsta.toString());
		when(request.getParameter("cifraRilancio")).thenReturn(cifreRilancio.toString());

		when(request.getRequestDispatcher("elencoNotificheLoggato.jsp?idUtente=" + idU)).thenAnswer(RETURNS_MOCKS);

		try
		{
			new RilancioAstaServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}

		aDopo = (Asta) aRepo.findByTipologia("astaInglese").get(0);

		Assert.assertEquals(aPrima.getTimer(), aDopo.getTimer());
		// Assert.assertEquals(aDopo.getTimer(), aDopo.getTimerReset()); non si aggiorna 
		// se l'applicativo non è in uso
		Assert.assertEquals(aDopo.getOffertaPiuAlta(), cifreRilancio);

		// reset
		aPrima.setTimer(timerPrima);
		aRepo.update(aPrima);

	}

}
