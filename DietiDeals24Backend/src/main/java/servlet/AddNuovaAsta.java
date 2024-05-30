package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entità.Asta;
import entità.Utente;

public class AddNuovaAsta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int IDCountAsta = 240;
       
    public AddNuovaAsta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Asta a = (Asta) request.getSession().getAttribute("asta");
		/*
		 u.setFotoProfilo((String) request.getAttribute("fotoProfilo"));
		 
		a.setTitolo(LEGACY_DO_HEAD);
		a.setDescrizione(LEGACY_DO_HEAD);
		a.setCategoria(LEGACY_DO_HEAD);
		a.setTipologia(LEGACY_DO_HEAD);
		a.getDataInizio();
		u.setID_Utente(IDCountAsta);
		IDCountAsta++;
		*/
	}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
