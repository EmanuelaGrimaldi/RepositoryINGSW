
package servlet;

import repository.UtenteRepository;
import implementazione.UtenteRepositoryImpl;
import entità.Utente;
import java.io.IOException;

import org.mockito.Mock;
import org.mockito.Mockito;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

class AggiornaMioProfiloServletTest extends Mockito
{

	@Mock
	RequestDispatcher rd;

	
	// 1 CAMPO PIENO E GIUSTO E GLI ALTRI VUOTI
	@Test
	public void testNuovaPosizioneNonVuotaTuttiGliAltriCampiVuoti()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();
		Utente uPrima, uDopo;
		String posizioneTest = "Napoli, Na";
		Integer idU = 100;

		when(request.getParameter("idUtente")).thenReturn(idU.toString());

		when(request.getParameter("nuovaPosizione")).thenReturn(posizioneTest);
		when(request.getParameter("nuovoSocial")).thenReturn("");
		when(request.getParameter("nuovaEmail")).thenReturn("");
		when(request.getParameter("nuovaBiografia")).thenReturn("");

		when(request.getRequestDispatcher("profiloUtenteLoggato.jsp?idUtente=" + idU)).thenAnswer(RETURNS_MOCKS);

		uDopo = uRepo.findbyID(idU);

		try
		{
			new AggiornaMioProfiloServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
		}

		uPrima = uRepo.findbyID(100);

		Assert.assertTrue(uPrima.getGeolocalizzazione().equals(uDopo.getGeolocalizzazione()));
		Assert.assertTrue(uPrima.getBiografia().equals(uDopo.getBiografia()));
		Assert.assertTrue(uPrima.getLinkSocial().equals(uDopo.getLinkSocial()));
		Assert.assertTrue(uPrima.getEmailUtente().equals(uDopo.getEmailUtente()));

	}
	public void testNovoSocialNonVuotaTuttiGliAltriCampiVuoti()
	{
	}
	public void testNuovaEmailNonVuotaTuttiGliAltriCampiVuoti()
	{
	}
	public void testNuovaBiografiaNonVuotaTuttiGliAltriCampiVuoti()
	{
	}
	
	
	// 2 CAMPI PIENI E GIUSTI E GLI ALTRI VUOTI
	
	public void testNuovoSocialENuovaPosizioneNonVuoteTuttiGliAltriCampiVuoti() {}
	public void testNuovaEmailENuovaPosizioneNonVuoteTuttiGliAltriCampiVuoti() {}
	public void testNuovaPosizioneENuovaBiografiaNonVuoteTuttiGliAltriCampiVuoti() {}
	public void testNuovaEmailENuovaSocialNonVuoteTuttiGliAltriCampiVuoti() {}
	public void testNuovoSocialENuovaBiografiaNonVuoteTuttiGliAltriCampiVuoti() {}
	public void testNuovaEmailENuovaBiografiaNonVuoteTuttiGliAltriCampiVuoti() {}

	
	// 3 CAMPI PIENI E GIUSTI E GLI ALTRI VUOTI
	
	public void testNuovaPosizioneNuovoSocialNuovaEmailNonVuoteTuttiGliAltriCampiVuoti() {}
	public void testNuovoSocialNuovaEmailNuovaBiografiaNonVuoteTuttiGliAltriCampiVuoti() {}
	public void testNuovaPosizioneNuovaEmailNuovaBiografiaNonVuoteTuttiGliAltriCampiVuoti() {}
	public void testNuovaPosizioneNuovoSocialNuovBiografiaNonVuoteTuttiGliAltriCampiVuoti() {}
	
	// TUTTI I CAMPI PIENI E GIUSTI 
	
	public void testNessunCampoVuoto() {}
	
	
	// TUTTI I CAMPI VUOTI
	
	public void testCampiNonValidi() {}
	
	//TUTTI I CAMPI PIENI E SBAGLIATI
	
	public void testCampiTuttiNulli() {}
	
	
	
}
