<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "implementazione.AstaRepositoryImpl, implementazione.UtenteRepositoryImpl, java.util.List, entità.Asta, entità.Utente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/headerAndFooter.css">
<link rel="stylesheet" type="text/css" href="css/profiloAstaStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<title>DietiDeals24</title>
</head>
<body>
<!--INIZIO HEADER LOGGATO-->

	<%	
    //per prendere ID dall'url
    String stringVenditoreID = request.getParameter("idUtente");
	int intVenditoreID = Integer.valueOf(stringVenditoreID);
 	Utente utente = UtenteRepositoryImpl.getInstance().findbyID(intVenditoreID);
 	%>
 	<%	
    //per prendere IDAsta dall'url
    String stringAstaID = request.getParameter("idAsta");
	int intAstaID = Integer.valueOf(stringAstaID);
 	Asta asta = AstaRepositoryImpl.getInstance().findbyID(intAstaID);
 	Utente venditore = UtenteRepositoryImpl.getInstance().findbyID(asta.getProprietario_FK());
	%>
	<div class ="bluePadding"></div>
        <div class="over_header">
			<div class="loginButton ">
				<img src=<%= utente.getFotoProfilo() %> alt="Immagine profilo" class="immagineVenditoreLoggato">
	
			<div class="nomeVenditoreLoggato">
				<div class ="dropdown">
					<button class="dropbtn"> <%= utente.getNome()%> <%= utente.getCognome()%>    		
					<i class="fa fa-caret-down"></i>
   					</button>
   				
   					<div class="dropdown-content">
   						<a href="profiloUtenteLoggato.jsp?idUtente=<%= utente.getID_Utente()%>">
    						<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/>
      						Il mio profilo
      					</a> 
						<a href="elencoNotificheLoggato.jsp?idUtente=<%=utente.getID_Utente()%>">
							<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/>
      						Le mie notifiche
      					</a>
						<a href="index.jsp">
      						Logout
      					</a>		
    				</div>
   				</div>	
   			</div>	
   			</div>
  	</div>
				

<div class="header">
		<div class="DietiDeals24_header">
			<img alt="logo" src="LOGO_DIETIDEALS.png">
		</div>
</div>	
<div class ="bluePadding"></div>	
<div class="under-header">
			<a href="indexLoggato.jsp?idUtente=<%= utente.getID_Utente()%>" class="homeButton">Home</a>
			<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/> 		
  	<div class="dropdown">		
  		<button class="dropbtn">
  			Tipi di Asta
    		<i class="fa fa-caret-down"></i>
   		</button>
     	<div class="dropdown-content">
   			<a href="homeByTipologiaLoggato.jsp?tipologia=astaInglese&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="tipologia" value="astaInglese"/>
    				<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/>
      				Asta all'inglese</a> 
			<a href="homeByTipologiaLoggato.jsp?tipologia=astaTempoFisso&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="tipologia" value="astaTempoFisso"/>
    				<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/>
      				Asta a tempo fisso</a> 		
    	</div>
  	</div>
  <div class="dropdown"> 
  		<button class="dropbtn">
  			Categorie
    		<i class="fa fa-caret-down"></i>
   		</button>
    	<div class="dropdown-content">
      		<a href="homeByCategoriaLoggato.jsp?categoria=TabletTelefonia&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="categoria" value="TabletTelefonia"/>
    				<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/>
    				Tablet e telefonia</a>
      		<a href="homeByCategoriaLoggato.jsp?categoria=Giocattoli&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="categoria" value="Giocattoli"/>
    				<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/>
    				Giocattoli</a>
      		<a href="homeByCategoriaLoggato.jsp?categoria=Elettronica&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="categoria" value="Elettronica"/>
    				<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/>
    				Elettronica</a>
     	 	<a href="homeByCategoriaLoggato.jsp?categoria=Arte&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="categoria" value="Arte"/>
    				<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/>
    				Arte</a>
    	    <a href="homeByCategoriaLoggato.jsp?categoria=Immobili&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="categoria" value="Immobili"/>
    				<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/>
    				Immobili</a>
    	    <a href="homeByCategoriaLoggato.jsp?categoria=Antiquariato&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="categoria" value="Antiquariato"/>
    				<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/>
    				Antiquariato</a>
    	</div>
  </div>
        	<div class="lenteRicerca">
    			<i class="fa-solid fa-magnifying-glass lenteRicercaSymbol" id="lenteRicercaButton"></i>
    		</div>
</div>

<!-- FINE HEADER LOGGATO-->
		
	<div id="myModalRicerca" class="modalRicerca">
  		<form name="RicercaByParolaChiaveForm" method="get" action="RicercaByParolaChiaveServlet">
  			<div class="modal-content-Ricerca">
   	 			<div class="modal-header-Ricerca">
   	   				<span class="close">&times;</span>
   	   				<div class="titoloRicercaParolaChiave">Inserisci qui la tua parola chiave</div>
  	  			</div>
 	   			<div class="modal-body-Ricerca">
 	   				<br>
 	     			<input type="text" name="inputParolaChiave" class="inputTestoRicercaParolaChiave" required>
 	     			<br><br>
 	   			</div>
  	  			<div class="modal-footer-Ricerca">
  	  				<input type="hidden" name="idUtente" value="<%= utente.getID_Utente()%>"/>
  	  				<input type="submit" value="Cerca" class="ricercaParolaChiaveButton"/>
  	    			<br>
  	  			</div>
 	 		</div>
 	 	</form>
	</div>


	<c:set var="tipoAsta" value="<%=asta.getTipologia()%>" />
	<c:set var="idAsta" value="<%=asta.getID() %>" />
	<c:set var="idUtente" value="<%=intVenditoreID %>" />
	
<!--INIZIO FORM POPUP-->


	<c:choose>
		<c:when test="${ tipoAsta == 'astaInglese'}">
			<form name="aggioraMiaAstaForm" method="get" action="AggiornaMiaAstaServlet">
			<div id="myModal" class="modal">
  				<!-- Modal content -->
  				<div class="modal-content-blueBorder ">
   	 				<div class="modal-header">
   	   					<span class="close">&times;</span>
  	    				<h2></h2>
  	  				</div>
 	   				<div class="modal-body">
 	   					<br>
 	     				<p>Soglia di rialzo:</p>
 	     				<input type="number" name="nuovaSogliaRialzo" class="inputTesto">
 	     				<p>Timer:</p>
 	     				<input type="time" name="nuovoTimer" class="inputTesto">
 	     				<br><br>
 	   				</div>
  	  				<div class="modal-footer">
  	  					<input type="hidden" name="idUtente" value="<%=intVenditoreID %>"/>
  	  					<input type="hidden" name="idAsta" value="<%=asta.getID() %>"/>
  	  					<input type="hidden" name="tipoAsta" value="<%=asta.getTipologia()%>"/>
  	    				<input type="submit" value="Salva modifiche" class="popupButtonLogin"/>
  	    				<br>
  	  				</div>
 	 			</div>
			</div>
			</form>
    	</c:when>
    	<c:otherwise>
    		<form name="aggioraMiaAstaForm" method="get" action="AggiornaMiaAstaServlet">
			<div id="myModal" class="modal">
  				<!-- Modal content -->
  				<div class="modal-content-blueBorder">
   	 				<div class="modal-header">
   	   					<span class="close">&times;</span>
  	    				<h2></h2>
  	  				</div>
 	   				<div class="modal-body">
 	   					<br>
 	     				<p>Data di scadenza:</p>
 	     				<input type="date" name="nuovoDataScadenza" class="inputTesto">
 	     				<br><br>
 	   				</div>
  	  				<div class="modal-footer">
  	  					<input type="hidden" name="idUtente" value="<%=intVenditoreID %>"/>
  	  					<input type="hidden" name="idAsta" value="<%=asta.getID() %>"/>
  	  					<input type="hidden" name="tipoAsta" value="<%=asta.getTipologia()%>"/>
  	    				<input type="submit" value="Salva modifiche" class="popupButtonLogin"/>
  	    				<br>
  	  				</div>
 	 			</div>
			</div>
			</form>
    	</c:otherwise> 
   	</c:choose>
   	
   	
<!--FINE FORM POPUP-->

	
<c:set var="Asta" value="${asta}" />

<h1><%= asta.getTitolo() %></h1>

<div class="background">

	<div class="flex-diviso2">
	
		<div class="divSX">
    		<img src= "<%=asta.getFotoAsta() %>" alt="Immagine prodotto" class="immagineAsta">  
    		<div class ="descrizioneAsta">
    				<p><%=asta.getDescrizione()%></p>
    		</div>  
    	</div>
		
		<div  class="divDX">
			
			<c:choose>
				<c:when test="${ tipoAsta == 'astaInglese'}">
					<div class="squareInfoAsta">
					<h1>Base d'asta: <%=asta.getOffertaIniziale() %>0€</h1>
					<h2>Offerta Corrente: <%=asta.getOffertaPiuAlta() %>0€</h2>
					<h3>Soglia di Rialzo: <%=asta.getSogliaRialzo() %>0€</h3>
					<br>
					<h4>Timer: <%=asta.getTimer() %> allo scadere.</h4>
			</div>
    			</c:when>
    			<c:otherwise>
    				<div class="squareInfoAsta">
						<h2>Offerta Corrente: <%=asta.getOffertaPiuAlta() %>0€</h2>
						<h3>La base d'asta che hai inserito per questo bene è di  <%=asta.getOffertaIniziale() %>0€</h3>
						<br><br>
						<h4>Data di scadenza: <%=asta.getDataFine() %></h4>
					</div>
    			</c:otherwise> 
   			</c:choose>
   			
			<br><br>
			<button id="modificaButton" class="Offerta">
				Modifica <i class="fa-regular fa-pen-to-square"></i>
			</button>	
			<div class="profiloVenditore">
					<img src= "<%= venditore.getFotoProfilo() %>" 
    				alt="Propic Venditore"
    				class="fotoVenditore"> 
    				
    			<div class="nomeVenditore">
    				<%= venditore.getNome() %> <%= venditore.getCognome() %>
    			</div>
    				
			</div>
		</div>
	</div>


</div>
	<form name="EliminaMiaAstaForm" method="post" action="EliminaMiaAstaServlet">
		
		<input type="hidden" name="idAsta" value="<%=asta.getID() %>"/>
		<input type="hidden" name="idUtente" value="<%=intVenditoreID %>"/>
		<button id="modificaButton" class="EliminaButton">Elimina</button>
	</form>
		




<!--Footer:-->

<div class="footer">
	<p> DietiDeals24 &#169</p>
</div>


 <script>
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var modificaButton = document.getElementById("modificaButton");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
modificaButton.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>
<script src="scriptRicerca.js"></script>
</body>
</html>