
package servlet;

import repository.UtenteRepository;
import implementazione.UtenteRepositoryImpl;
import entità.Utente;
import java.io.IOException;
import java.util.Random;

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

	public void testNuovoSocialENuovaPosizioneNonVuoteTuttiGliAltriCampiVuoti()
	{
	}

	public void testNuovaEmailENuovaPosizioneNonVuoteTuttiGliAltriCampiVuoti()
	{
	}

	public void testNuovaPosizioneENuovaBiografiaNonVuoteTuttiGliAltriCampiVuoti()
	{
	}

	public void testNuovaEmailENuovaSocialNonVuoteTuttiGliAltriCampiVuoti()
	{
	}

	public void testNuovoSocialENuovaBiografiaNonVuoteTuttiGliAltriCampiVuoti()
	{
	}

	public void testNuovaEmailENuovaBiografiaNonVuoteTuttiGliAltriCampiVuoti()
	{
	}

	// 3 CAMPI PIENI E GIUSTI E GLI ALTRI VUOTI

	public void testNuovaPosizioneNuovoSocialNuovaEmailNonVuoteTuttiGliAltriCampiVuoti()
	{
	}

	public void testNuovoSocialNuovaEmailNuovaBiografiaNonVuoteTuttiGliAltriCampiVuoti()
	{
	}

	public void testNuovaPosizioneNuovaEmailNuovaBiografiaNonVuoteTuttiGliAltriCampiVuoti()
	{
	}
	// ----------------------------------------------------------------------------------------DA CONTROLLARE
	@Test
	public void testSettoNuovaPosizioneNuovoSocialNuovBiografiaNelDB()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();
		
		Utente uReset, uDopo;
		
		Integer idU = 100;
		Integer vari = (int) (1000 * Math.random());
		
		String giustaPosizione = "Napoli, Na";
		String giustoSocial = "Mastodon" + vari;
		String giustaEmail = "";
		String giustaBiografia = "Sono un potete investitore e qui posso trovare fantastiche offerte immobiliari.";
		
		
		String posCambiata = giustaPosizione+vari;
		String socialCambiata = giustaPosizione+vari;
		String emailCambiata = giustaPosizione+vari;
		String biografiaCambiata = giustaPosizione+vari;
		
		when(request.getParameter("idUtente")).thenReturn(idU.toString());

		when(request.getParameter("nuovaPosizione")).thenReturn(posCambiata);
		when(request.getParameter("nuovoSocial")).thenReturn(socialCambiata);
		when(request.getParameter("nuovaEmail")).thenReturn(emailCambiata);
		when(request.getParameter("nuovaBiografia")).thenReturn(biografiaCambiata);

		when(request.getRequestDispatcher("profiloUtenteLoggato.jsp?idUtente=" + idU)).thenAnswer(RETURNS_MOCKS);
		
		uReset = uRepo.findbyID(idU);
		
		try
		{
			new AggiornaMioProfiloServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
		}

		uDopo = uRepo.findbyID(idU);
		
		Assert.assertEquals(uDopo.getBiografia(), posCambiata);
		Assert.assertEquals(uDopo.getEmailUtente(), socialCambiata);
		Assert.assertEquals(uDopo.getGeolocalizzazione(), emailCambiata);
		Assert.assertEquals(uDopo.getLinkSocial(), biografiaCambiata);
		
		// reset
		uRepo.update(uReset);
		
	}

	// TUTTI I CAMPI PIENI E GIUSTI - FATTO
	@Test
	public void testCambiatoTTIValoriDelProfiloNelDB()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();
		Utente uPrima, uDopo;
		Integer idU = 100;
		String giustaPosizione = "Napoli, Na";
		String giustoSocial = "Mastodon";
		String giustaEmail = "vero.mario.esposito@gmail.com";
		String giustaBiografia = "Sono un potete investitore e qui posso trovare fantastiche offerte immobiliari.";

		when(request.getParameter("idUtente")).thenReturn(idU.toString());

		when(request.getParameter("nuovaPosizione")).thenReturn(giustaPosizione);
		when(request.getParameter("nuovoSocial")).thenReturn(giustoSocial);
		when(request.getParameter("nuovaEmail")).thenReturn(giustaEmail);
		when(request.getParameter("nuovaBiografia")).thenReturn(giustaBiografia);

		when(request.getRequestDispatcher("profiloUtenteLoggato.jsp?idUtente=" + idU)).thenAnswer(RETURNS_MOCKS);

		uPrima = uRepo.findbyID(idU);
		
		try
		{
			new AggiornaMioProfiloServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
		}

		uDopo = uRepo.findbyID(idU);

		Assert.assertEquals(uDopo.getBiografia(), giustaBiografia);
		Assert.assertEquals(uDopo.getEmailUtente(), giustaEmail);
		Assert.assertEquals(uDopo.getGeolocalizzazione(), giustaPosizione);
		Assert.assertEquals(uDopo.getLinkSocial(), giustoSocial);
		
		// reset
		uRepo.update(uPrima);
	}

	// TUTTI I CAMPI PIENI E SBAGLIATI - NON ABBIAMO IMPLEMENTATO QUESTA LOGICA DI
	// CONTROLLO

	public void testTuttiICampiNonSonoValidi()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();
		Utente uPrima, uDopo;
		Integer idU = 100;
		String errPosizione = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,"
				+ " totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae"
				+ " dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit,"
				+ " sed quia consequuntur magni dolores eos qui ratione";

		String errSocial = "MastodonFacebookTwitterXWhatzapMastodonFacebookTwitterXWhatzapMastodonFacebookTwitterXWhatzap"
				+ "MastodonFacebookTwitterXWhatzapMastodonFacebookTwitterXWhatzapMastodonFacebookTwitterXWhatzap"
				+ "MastodonFacebookTwitterXWhatzapMastodonFacebookTwitterXWhatzapMastodonFacebookTwitterXWhatzap"
				+ "MastodonFacebookTwitterXWhatzapMastodonFacebookTwitterXWhatzapMastodonFacebookTwitterXWhatzap";

		String errEmail = "spaziochiocchiolacaratterobello@gmail.com";

		String errBiografia = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor"
				+ "Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus."
				+ "Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim."
				+ "Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo."
				+ "Nullam dictum felis eu pede mollis pretium. Integer tincidunt."
				+ "Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus."
				+ "Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus."
				+ "Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue."
				+ "Curabitur ullamcorper ultricies nisi. Nam eget dui."
				+ "Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam q";

		when(request.getParameter("idUtente")).thenReturn(idU.toString());

		when(request.getParameter("nuovaPosizione")).thenReturn(errPosizione);
		when(request.getParameter("nuovoSocial")).thenReturn(errSocial);
		when(request.getParameter("nuovaEmail")).thenReturn(errEmail);
		when(request.getParameter("nuovaBiografia")).thenReturn(errBiografia);

		when(request.getRequestDispatcher("profiloUtenteLoggato.jsp?idUtente=" + idU)).thenAnswer(RETURNS_MOCKS);

		uDopo = uRepo.findbyID(idU);

		try
		{
			new AggiornaMioProfiloServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
		} catch (Exception e)
		{
		}

		uPrima = uRepo.findbyID(idU);

		Assert.assertFalse(uPrima.getGeolocalizzazione().equals(uDopo.getGeolocalizzazione()));
		Assert.assertFalse(uPrima.getBiografia().equals(uDopo.getBiografia()));
		Assert.assertFalse(uPrima.getLinkSocial().equals(uDopo.getLinkSocial()));
		Assert.assertFalse(uPrima.getEmailUtente().equals(uDopo.getEmailUtente()));

	}

	// TUTTI I CAMPI NULLI - FATTO
	@Test
	public void testTestoCheTuttiICampiNulliNonCambinoQualcosaNelDB()
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();
		Utente uPrima, uDopo;
		Integer idU = 100;

		when(request.getParameter("idUtente")).thenReturn(idU.toString());

		when(request.getParameter("nuovaPosizione")).thenReturn("");
		when(request.getParameter("nuovoSocial")).thenReturn("");
		when(request.getParameter("nuovaEmail")).thenReturn("");
		when(request.getParameter("nuovaBiografia")).thenReturn("");

		when(request.getRequestDispatcher("profiloUtenteLoggato.jsp?idUtente=" + idU)).thenAnswer(RETURNS_MOCKS);

		uPrima = uRepo.findbyID(idU);

		try
		{
			new AggiornaMioProfiloServlet().doGet(request, response);
		} catch (ServletException | IOException e)
		{
		}

		uDopo = uRepo.findbyID(idU);

		Assert.assertTrue(uPrima.getGeolocalizzazione().equals(uDopo.getGeolocalizzazione()));
		Assert.assertTrue(uPrima.getBiografia().equals(uDopo.getBiografia()));
		Assert.assertTrue(uPrima.getLinkSocial().equals(uDopo.getLinkSocial()));
		Assert.assertTrue(uPrima.getEmailUtente().equals(uDopo.getEmailUtente()));

	}

}
