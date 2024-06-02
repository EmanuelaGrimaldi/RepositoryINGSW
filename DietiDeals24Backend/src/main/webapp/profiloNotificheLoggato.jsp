<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "implementazione.NotificheRepositoryImpl, implementazione.UtenteRepositoryImpl, implementazione.AstaRepositoryImpl,
					java.util.List, entità.Notifiche, entità.Utente, entità.Asta"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/headerAndFooter.css">
<link rel="stylesheet" type="text/css" href="css/profiloAstaStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />


<title>Le mie Notifiche</title>
</head>
<body>

<!--INIZIO HEADER LOGGATO-->

	<%	
    //per prendere ID dall'url
    String stringVenditoreID = request.getParameter("idUtente");
	int intIDutente = Integer.valueOf(stringVenditoreID);
 	Utente utente = UtenteRepositoryImpl.getInstance().findbyID(intIDutente);
 	%>
 	<%
 	
 	String stringNotificaID = request.getParameter("idNotifica");
	int intNotificaID = Integer.valueOf(stringNotificaID);
	Notifiche notifica;
	notifica = NotificheRepositoryImpl.getInstance().findbyID(intNotificaID);
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
</div>

<!-- FINE HEADER LOGGATO-->

<c:set var="Notifiche" value="${notifica}" />

<div class="titoloNotifica">&#x2022 <%= notifica.getTitolo() %> &#x2022</div>


    	<div class ="descrizioneNotifica">
    			<p><%=notifica.getTesto() %></p>
    	
    		<div>
    			<c:set var="idAstaNotifica" value="<%=notifica.getIDAsta() %>" />
    			<c:set var="idVenditore" value="<%=notifica.getIDUtenteVenditore() %>" />
    			<c:set var="idproprietario" value="<%=intIDutente%>" />
    		
    			<c:if test= "${idAstaNotifica != '0'}">
    			<br>
    			<div class="dettagliAsta">--- DETTAGLI ASTA: ---</div>
    			<br>
    			<div class="riquadroInformazioni">
    			<%Asta asta = AstaRepositoryImpl.getInstance().findbyID(notifica.getIDAsta());%>
    			<a href="profiloAstaLoggato.jsp?idAsta=<%=notifica.getIDAsta()%>&idUtente=<%=intIDutente%>" class="BlackLink">
    				<input type="hidden" name="IdAsta" value="<%=notifica.getIDAsta() %>"/>
    				<input type="hidden" name="idUtente" value="<%=intIDutente%>"/>
    				&#x2022 BENE ALL'ASTA:<br>
    				Titolo:<%=asta.getTitolo() %> <br>
    				Costo attuale:<%=asta.getOffertaPiuAlta() %>0€<br>
    			</a>
    			</div>
    			<c:choose>
       		  	<c:when test = "${idVenditore == idproprietario}">
       		  		<div class="riquadroInformazioni">
           			<a href="profiloUtenteLoggato.jsp?idUtente=<%=intIDutente%>" class="BlackLink">
    						<input type="hidden" name="idUtente" value="<%=intIDutente%>"/>
      						&#x2022 PROFILO VENDITORE:<br>
      						Nome:<%=utente.getNome() %><br>
      						Cognome:<%=utente.getCognome()%><br>
      						Posizione:<%=utente.getGeolocalizzazione() %><br>
      				</a>
      				</div>
      				<%Utente utenteCompratore = UtenteRepositoryImpl.getInstance().findbyID(notifica.getIDUtenteCompratore());%>
      				<div class="riquadroInformazioni">
      				<a href="profiloVenditoreLoggato.jsp?idVenditore=<%=utenteCompratore.getID_Utente()%>&idUtente=<%=intIDutente%>" class="BlackLink">
    					<input type="hidden" name="idVenditore" value="<%=utenteCompratore.getID_Utente()%>"/>
    					<input type="hidden" name="idUtente" value="<%=intIDutente%>"/>
    					&#x2022 PROFILO COMPRATORE:<br>
    					Nome:<%=utenteCompratore.getNome() %><br>
      					Cognome:<%=utenteCompratore.getCognome()%><br>
      					Posizione:<%=utenteCompratore.getGeolocalizzazione() %><br>
    				</a>
    				</div>
				</c:when>
	         	<c:otherwise>
	         	<%Utente utenteVenditore = UtenteRepositoryImpl.getInstance().findbyID(notifica.getIDUtenteVenditore());%>
	         		<div class="riquadroInformazioni">
	            	<a href="profiloVenditoreLoggato.jsp?idVenditore=<%=utenteVenditore.getID_Utente()%>&idUtente=<%=intIDutente%>" class="BlackLink">
    					<input type="hidden" name="idVenditore" value="<%=utenteVenditore.getID_Utente()%>"/>
    					<input type="hidden" name="idUtente" value="<%=intIDutente%>"/>
      						&#x2022 PROFILO VENDITORE:<br>
      						Nome:<%=utenteVenditore.getNome() %><br>
      						Cognome:<%=utenteVenditore.getCognome()%><br>
      						Posizione:<%=utenteVenditore.getGeolocalizzazione() %><br>
      				</a>
      				</div>
      				<div class="riquadroInformazioni">
      				<a href="profiloUtenteLoggato.jsp?idUtente=<%=intIDutente%>" class="BlackLink">
    						<input type="hidden" name="idUtente" value="<%=intIDutente%>"/>
      						&#x2022 PROFILO COMPRATORE:<br>
      						Nome:<%=utente.getNome() %><br>
      						Cognome:<%=utente.getCognome()%><br>
      						Posizione:<%=utente.getGeolocalizzazione() %><br>
      				</a>
      				</div>
         		</c:otherwise>
      			</c:choose>		
    	</c:if>
    		
    		</div>
    	</div> 
    	
    	
    	<a href="elencoNotificheLoggato.jsp?idUtente=<%=intIDutente%>">
			<input type="hidden" name="idUtente" value="<%=intIDutente%>"/>
			<button type="button" class="notificaIndietroButton">Indietro</button>
		</a>
		
		
<br><br><br><br><br><br><br><br><br>
<div class="footer">
	<p> DietiDeals24 &#169;</p>
</div>
</body>
</html>