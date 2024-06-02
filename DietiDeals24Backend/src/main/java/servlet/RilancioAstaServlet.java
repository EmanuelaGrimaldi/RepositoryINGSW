package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AstaRepository;
import repository.NotificheRepository;
import repository.PartecipazioneUtenteAstaRepository;
import repository.UtenteRepository;

import java.io.IOException;

import entità.Asta;
import entità.Notifiche;
import entità.PartecipazioneUtenteAsta;
import entità.Utente;
import implementazione.AstaRepositoryImpl;
import implementazione.NotificheRepositoryImpl;
import implementazione.PartecipazioneUtenteAstaRepositoryImpl;
import implementazione.UtenteRepositoryImpl;

@WebServlet("/RilancioAstaServlet")
public class RilancioAstaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       

    public RilancioAstaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("ID UTENTE CHE RECUPERO: " + request.getParameter("idUtente"));
		
		int idUtenteCompratore = Integer.valueOf(request.getParameter("idUtente"));
		int idAstaINT = Integer.valueOf(request.getParameter("idAsta"));
		
		AstaRepository aRepo = AstaRepositoryImpl.getInstance();	
		Asta a = aRepo.findbyID(idAstaINT);
		
		float ultimaOfferta = a.getOffertaPiuAlta();
		float prezzoRilancio = 0, somma;
		
		if ("astaInglese".contentEquals(a.getTipologia())) {
			prezzoRilancio = a.getSogliaRialzo();
			//a.getTimer() = a.getTimerReset();
		}else {
			prezzoRilancio = Integer.valueOf(request.getParameter("cifraRilancio"));
		}
		
		somma = ultimaOfferta + prezzoRilancio;
		
		if (somma == ultimaOfferta) {
			System.out.println("\n\nQUALCOSA ANDATO STORTO\n\n");
		}
		
		a.setOffertaPiuAlta(somma);
		a.setIDOffertaPiuAlta(idUtenteCompratore);
		
		NotificheRepository nRepo = NotificheRepositoryImpl.getInstance();		
		Notifiche notificaVenditore = new Notifiche(), notificaCompratore = new Notifiche();
		
		UtenteRepository uRepo = UtenteRepositoryImpl.getInstance();	
		Utente utenteVenditore = uRepo.findbyID(a.getProprietario_FK());
		
		notificaVenditore.setTitolo("Qualcuno ha effettuato un rilancio per la tua asta: " + a.getTitolo());
		notificaVenditore.setTesto("L'utente: " + utenteVenditore.getNome() + " " + utenteVenditore.getCognome() + " ha effettuato un nuovo rilancio per l'asta " 
							+ a.getTitolo() + " facendo cosi salire il prezzo dell'asta a " + somma + "euro!");
		notificaVenditore.setIDUtenteFK(a.getProprietario_FK());
		notificaVenditore.setIDAsta(idAstaINT);
		nRepo.save(notificaVenditore);
		
		
		notificaCompratore.setTitolo("Hai appena effettuato un rilancio per l'asta: " + a.getTitolo());
		notificaCompratore.setTesto("Hai appena effettuato un nuovo rilancio per l'asta " 
							+ a.getTitolo() + ", se nessun altro effettuerà un rilancio vincerai il bene per soli " + somma + "euro!");
		notificaCompratore.setIDUtenteFK(idUtenteCompratore);
		nRepo.save(notificaCompratore);
		
		aRepo.update(a);
		
		PartecipazioneUtenteAsta pua = new PartecipazioneUtenteAsta();
		PartecipazioneUtenteAstaRepository puaRepo = PartecipazioneUtenteAstaRepositoryImpl.getInstance();
		
		pua.setIDAsta(idAstaINT);
		pua.setIDUtente(idUtenteCompratore);
		puaRepo.save(pua);

		request.getRequestDispatcher("elencoNotificheLoggato.jsp?idUtente=" + idUtenteCompratore).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
