package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AstaRepository;
import repository.NotificheRepository;
import repository.UtenteRepository;
import java.io.IOException;
import entità.Asta;
import entità.Notifiche;
import entità.Utente;
import implementazione.AstaRepositoryImpl;
import implementazione.NotificheRepositoryImpl;
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
		int IDVenditore = a.getProprietario_FK();
		
		if ("astaInglese".contentEquals(a.getTipologia())) {
			prezzoRilancio = a.getSogliaRialzo();
			a.setTimer(a.getTimerReset());
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
		Utente utenteVenditore = uRepo.findbyID(IDVenditore);
		
		notificaVenditore.setTitolo("Qualcuno ha effettuato un rilancio per la tua asta: " + a.getTitolo());
		notificaVenditore.setTesto("L'utente: " + utenteVenditore.getNome() + " " + utenteVenditore.getCognome() + " ha effettuato un nuovo rilancio per l'asta " 
									+ a.getTitolo() + " facendo cosi salire il prezzo dell'asta a " + somma + "0 euro!");
		notificaVenditore.setIDAsta(idAstaINT);
		notificaVenditore.setIDProprietarioNotifica(IDVenditore);
		notificaVenditore.setIDUtenteVenditore(IDVenditore);
		notificaVenditore.setIDUtenteCompratore(idUtenteCompratore);
		nRepo.save(notificaVenditore);
		
		notificaCompratore.setTitolo("Hai appena effettuato un rilancio per l'asta: " + a.getTitolo());
		notificaCompratore.setTesto("Hai appena effettuato un nuovo rilancio per l'asta " 
									+ a.getTitolo() + ", se nessun altro effettuerà un rilancio vincerai il bene per soli " + somma + "0 euro!");
		notificaCompratore.setIDAsta(idAstaINT);
		notificaCompratore.setIDUtenteVenditore(IDVenditore);
		notificaCompratore.setIDProprietarioNotifica(idUtenteCompratore);
		notificaCompratore.setIDUtenteCompratore(idUtenteCompratore);
		nRepo.save(notificaCompratore);
		
		aRepo.update(a);
		
		request.getRequestDispatcher("elencoNotificheLoggato.jsp?idUtente=" + idUtenteCompratore).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
