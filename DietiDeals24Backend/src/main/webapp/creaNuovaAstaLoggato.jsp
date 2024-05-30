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
<link rel="stylesheet" type="text/css" href="css/nuovaAstaStyle.css">
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
 	String tipoAsta = request.getParameter("tipologia");
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
    						<input type="hidden" name="idUtente" value="idUtente"/>
      						Il mio profilo
      					</a> 
						<a href="elencoNotificheLoggato.jsp?idUtente=<%=utente.getID_Utente()%>">
							<input type="hidden" name="idUtente" value="idUtente"/>
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
		<!--INSERIRE LOGO QUI:-->
		<div class="DietiDeals24_header">
			DietiDeals24
		</div>
</div>		
<div class="under-header">
  	<div class="homeButton">
			<a href="indexLoggato.jsp?idUtente=<%= utente.getID_Utente()%>">Home</a>
			<input type="hidden" name="idUtente" value="idUtente"/> 
  	</div> 		
  	<div class="dropdown">		
  		<button class="dropbtn">
  			Tipi di Asta
    		<i class="fa fa-caret-down"></i>
   		</button>
     	<div class="dropdown-content">
   			<a href="homeByTipologiaLoggato.jsp?tipologia=astaInglese&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="tipologia" value="astaInglese"/>
    				<input type="hidden" name="idUtente" value="idUtente"/>
      				Asta all'inglese</a> 
			<a href="homeByTipologiaLoggato.jsp?tipologia=astaTempoFisso&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="tipologia" value="astaTempoFisso"/>
    				<input type="hidden" name="idUtente" value="idUtente"/>
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
    				<input type="hidden" name="idUtente" value="idUtente"/>
    				Tablet e telefonia</a>
      		<a href="homeByCategoriaLoggato.jsp?categoria=Giocattoli&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="categoria" value="Giocattoli"/>
    				<input type="hidden" name="idUtente" value="idUtente"/>
    				Giocattoli</a>
      		<a href="homeByCategoriaLoggato.jsp?categoria=Elettronica&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="categoria" value="Elettronica"/>
    				<input type="hidden" name="idUtente" value="idUtente"/>
    				Elettronica</a>
     	 	<a href="homeByCategoriaLoggato.jsp?categoria=Arte&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="categoria" value="Arte"/>
    				<input type="hidden" name="idUtente" value="idUtente"/>
    				Arte</a>
    	    <a href="homeByCategoriaLoggato.jsp?categoria=Immobili&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="categoria" value="Immobili"/>
    				<input type="hidden" name="idUtente" value="idUtente"/>
    				Immobili</a>
    	    <a href="homeByCategoriaLoggato.jsp?categoria=Antiquariato&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="categoria" value="Antiquariato"/>
    				<input type="hidden" name="idUtente" value="idUtente"/>
    				Antiquariato</a>
    	</div>
  </div>
</div>

<!-- FINE HEADER LOGGATO-->

<div>
	<a href="profiloUtenteLoggato.jsp?idUtente=<%= utente.getID_Utente()%>">
  		<input type="hidden" name="idUtente" value="idUtente"/>
		<i class="fa-solid fa-arrow-left freccia-indietro"></i>
	</a>
</div>
	
	
<c:set var="tipologia" value="<%= tipoAsta %>" />

<h1>Per favore inserisci qui i dati richiesti</h1>
	
	<form name="nuovaAstaForm" method="post" action="addNuovaAsta">
	
<!-- IF ASTA INGLESE-->
			
		<c:if test = "${tipologia == 'astaInglese'}">			
			<h4>Che tipo di asta vuoi creare?</h4>
				
			<div class ="squareTipologia">		
			<a href="creaNuovaAstaLoggato.jsp?tipologia=astaTempoFisso&idUtente=<%= utente.getID_Utente()%>">
				<input type="hidden" name="idUtente" value="idUtente"/>
  				<h3>Asta a tempo fisso</h3>
			</a>
					
			<a href="creaNuovaAstaLoggato.jsp?tipologia=astaInglese&idUtente=<%= utente.getID_Utente()%>">
    			<input type="hidden" name="idUtente" value="idUtente" class ="inputTesto"/>
    			<div class="blueBackground"><h3>Asta all'Inglese</h3></div>
    		</a>
    		</div>	
		</c:if>
		
					
<!-- IF ASTA TEMPO FISSO-->
	
	
		<c:if test = "${tipologia == 'astaTempoFisso'}">
			<h4>Che tipo di asta vuoi creare?</h4>	
				
				<div class ="squareTipologia">	
				<a href="creaNuovaAstaLoggato.jsp?tipologia=astaTempoFisso&idUtente=<%= utente.getID_Utente()%>">
					<input type="hidden" name="idUtente" value="idUtente"/>
  					<div class="blueBackground"><h3>Asta a tempo fisso</h3></div>
				</a>
					
				<a href="creaNuovaAstaLoggato.jsp?tipologia=astaInglese&idUtente=<%= utente.getID_Utente()%>">
    				<input type="hidden" name="idUtente" value="idUtente"/>
    				<h3>Asta all'Inglese</h3>
    			</a>
    			</div>		
		</c:if>
		

			
				<div>
					<h4>Titolo Asta:</h4>
					<input type="text" name="titoloAsta" required class="inputTesto">
				</div>
				<div>
					<h4>Descrizione:</h4>
					<input type="text" name="descrizione" required class="inputDescrizione">
				</div>
				
				<div class="menuCategoria">
					<h4>Categoria Articolo:</h4>
				 	<select name="categoria">
						<option value="TabletTelefonia">Tablet e telefonia</option>
     					<option value="Giocattoli">Giocattoli</option>
     					<option value="Elettronica">Elettronica</option>
     					<option value="Arte">Arte</option>
     					<option value="Immobili">Immobili</option>
     					<option value="Antiquariato">Antiquariato</option>
   					</select>
   				</div>
   				
   				<c:if test = "${tipologia == 'astaTempoFisso'}">	
					<div>
						<h4>Data di scadenza:</h4>
						<input type="date" name="dataScadenza" required class="inputStretto">
					</div>
				</c:if>
				<c:if test = "${tipologia == 'astaInglese'}">		
					<div>
						<h4>Timer:</h4>
						<input type="time" name="timer" required class="inputTimer">
					</div>
				</c:if>
				
				<div>
					<h4>Base d'asta:</h4>
					<input type="text" name="baseAsta" required class="inputStretto">
				</div>
				<div>
					<h4>Soglia di rialzo:</h4>
					<input type="text" name="sogliaRialzo" required class="inputStretto">
				</div>	
				<div>
					<input type="submit" value="Pubblica" class="pubblicaAstaButton"/>
				</div>
				
				
	</form>

<!--Footer:-->
<br><br>
<div class="footer">
	<p> DietiDeals24 &#169</p>
</div>
</body>
</html>