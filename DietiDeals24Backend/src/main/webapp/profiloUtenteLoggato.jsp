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
<link rel="stylesheet" type="text/css" href="css/indexStyle.css">
<link rel="stylesheet" type="text/css" href="css/profiloVenditoreStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />


<title>Il mio profilo</title>
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
	List<Asta> listaAsta;
	listaAsta = AstaRepositoryImpl.getInstance().findAstaByProprietarioFK(intVenditoreID);
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
						<a href="">
							<!--DA IMPLEMENTARE profiloNotificheLoggato.jsp-->
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
			
 	
 	<div class="headerVenditore">
 		<div class="divSX">
    		<img src=<%= utente.getFotoProfilo() %> alt="Immagine profilo" class="immagineProfiloUtente">    
    	</div>
 		<div class="divDX">
 			<h4 class="nomeVenditore"><%= utente.getNome() %> <%= utente.getCognome() %></h4>
 			<h4><%= utente.getGeolocalizzazione() %></h4>
 			<p><%= utente.getBiografia() %></p>
 			<i class="fa-solid fa-link iconaLink">&nbsp <%= utente.getLinkSocial() %></i>
 		</div>
 	</div>
  	
<!-- FINE HEADER VENDITORE -->

<div class="asteVenditore">Le mie aste:</div>	 	

<!--INIZIO BODY ASTE-->	
	<c:forEach var = "i" items="<%= listaAsta %>">
	
	
	<c:if test= "${i.tipologia == 'astaInglese'}">
	
		<div class="flex-diviso2 cell">
			<div>
    			<a href="">
    			<!--Da implementare:miaAstaLoggato.jsp-->
    				<img src="${i.fotoAsta1}" alt="Immagine prodotto" class="immagineAsta">
   	 			</a>
   	 		</div>	 	
    		<div>
				<div class="testoAsta">		
					<h1>
					<a href=""><c:out value = "${i.titolo}"/></a></h1>
					<!--Da implementare:miaAstaLoggato.jsp-->
					<p><c:out value = "${i.descrizione}"/></p>
					<h5>Scadrà tra: <c:out value = "${i.timer}"/></h5>
					<h5>Base d'asta: <c:out value = "${i.offertaIniziale}"/> €</h5>
					<h5>Soglia di rialzo: <c:out value = "${i.sogliaRialzo}"/> €</h5>
					<h5>Prezzo attuale: <c:out value = "${i.offertaPiuAlta}"/> €</h5>
					<h2><c:out value = "Asta all'inglese"/></h2>		     
   				</div>
  			</div> 	
  		</div>
	</c:if>
	
	<c:if test= "${i.tipologia == 'astaTempoFisso'}">
	
		<div class="flex-diviso2 cell">
			<div>
			<!--
			Da implementare:miaAstaLoggato.jsp
			<a href="miaAsta.jsp?idAsta=${i.ID}&&idUtente=< % = utente.getID_Utente()% > >
			-->
    			<a href="">
    				<input type="hidden" name="IdAsta" value="${i.ID}"/>
    				<img src="${i.fotoAsta1}" alt="Immagine prodotto" class="immagineAsta">
    			</a>
   	 		</div>	
    		<div>
				<div class="testoAsta">		
						<a href="">
						<!--Da implementare:miaAstaLoggato.jsp-->
    						<input type="hidden" name="IdAsta" value="${i.ID}"/>
    						<c:out value = "${i.titolo}"/>
    					</a>
					<p><c:out value = "${i.descrizione}"/></p>
					<h5>Data fine: <c:out value = "${i.dataFine}"/></h5>
					<h5>Prezzo attuale: <c:out value = "${i.offertaPiuAlta}"/> €</h5>
					<h2><c:out value = "Asta a tempo fisso"/></h2>		     
   				</div>
  			</div> 		
  		</div>
	</c:if>
	   	
	</c:forEach>
<!--FINE BODY ASTE-->
   
<!--Footer:-->

<div class="footer">
	<p> DietiDeals24 &#169;</p>
</div>


</body>
</html>