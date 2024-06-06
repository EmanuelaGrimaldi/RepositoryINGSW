/**
 * 
 */
package servlet;

import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;
import repository.UtenteRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entità.Utente;
import implementazione.UtenteRepositoryImpl;
import jakarta.servlet.ServletException;

class AggiornaMioProfiloServletTest
{
	private WebTester webTester;
	private static final String WEBSITE_URL = "http://localhost:8080/DietiDeals24Backend/";

	@Test
	@BeforeAll
	public void entraNelProfilo()
	{
		
		webTester = new WebTester();
		webTester.setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
		webTester.getTestContext().setBaseUrl(WEBSITE_URL);

		webTester.clickLink("login");
		webTester.assertFormPresent("aggiornaMioProfiloForm");
		webTester.assertFormElementPresent("inputEmail");
		webTester.assertFormElementPresent("inputPassword");
		
		webTester.setTextField("inputEmail", "marioesposito@root.com");
		webTester.setTextField("inputPassword", "root");
		webTester.submit();
		webTester.clickLink("profiloUtenteLoggato.jsp?idUtente=100");
		
		
	}
	
	@Test
	public void testBiografiaNonVuotaTuttiGliAltriCampiVuoti()
	{
		
		String biografiaTest = "Sono uo stimato scienziato";
		String posizioneaTest = "";
		String socialTest = "";
		String emailTest = "";
		
		
		
		webTester.setTextField("nuovaBiografia", biografiaTest);
		webTester.setTextField("nuovaPosizione", posizioneaTest);
		webTester.setTextField("nuovoSocial", socialTest);
		webTester.setTextField("nuovaEmail", emailTest);
		webTester.submit();
		
		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();
		Utente u = uRepo.findByEmail("marioesposito@root.com");
		//webTester.assert
		
		assertEquals(u.getEmailUtente(), );
		
		
		
	}
	
		
	
	

}
