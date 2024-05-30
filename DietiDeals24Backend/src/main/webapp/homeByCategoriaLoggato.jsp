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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />


<title>Home: DietiDeals24</title>
</head>
<body>
<!--INIZIO HEADER LOGGATO-->

		<%	
	//Per portarmi l'ID_Utente
	String stringUtenteID = request.getParameter("idUtente");
    int utenteID = Integer.valueOf(stringUtenteID);
    Utente utente = UtenteRepositoryImpl.getInstance().findbyID(utenteID);	
	
    //per prendere categoria dall'url
    String stringCategoria = request.getParameter("categoria");
	List<Asta> listaAsteByCategoria;
	listaAsteByCategoria = AstaRepositoryImpl.getInstance().findByCategoria(stringCategoria);		
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

	<!--INIZIO BODY ASTE-->	
	
	<c:set var="categoriaAsta" value="<%=stringCategoria%>" />
	<c:set var="idUtenteLoggato" value="<%= utente.getID_Utente()%>" />
	
	<c:forEach var = "i" items="<%= listaAsteByCategoria %>">
	
	<c:if test= "${i.tipologia == 'astaInglese'} && ${i.ID != idUtenteLoggato}">
	
			<div class="flex-diviso2 cell">
				<div>
    				<a href="profiloAstaLoggato.jsp?idAsta=${i.ID}&idUtente=<%= utente.getID_Utente()%>">
    					<input type="hidden" name="IdAsta" value="${i.ID}"/>
    					<input type="hidden" name="idUtente" value="idUtente"/>
    					<img src="${i.fotoAsta1}" alt="Immagine prodotto" class="immagineAsta">
    				</a>
   	 			</div>	 	
    			<div>
					<div class="testoAsta">		
						<h1><a href="profiloAstaLoggato.jsp?idAsta=${i.ID}&idUtente=<%= utente.getID_Utente()%>">
    						<input type="hidden" name="IdAsta" value="${i.ID}"/>
    						<input type="hidden" name="idUtente" value="idUtente"/>
    						<c:out value = "${i.titolo}"/>
    					</a></h1>
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
	
	<c:if test= "${i.tipologia == 'astaTempoFisso'}&& ${i.ID != idUtenteLoggato}">
	
			<div class="flex-diviso2 cell">
				<div>
    				<a href="profiloAstaLoggato.jsp?idAsta=${i.ID}&idUtente=<%= utente.getID_Utente()%>">
    					<input type="hidden" name="IdAsta" value="${i.ID}"/>
    					<input type="hidden" name="idUtente" value="idUtente"/>
    					<img src="${i.fotoAsta1}" alt="Immagine prodotto" class="immagineAsta">
    				</a>
   	 			</div>	
    			<div>
					<div class="testoAsta">		
						<h1><a href="profiloAstaLoggato.jsp?idAsta=${i.ID}&idUtente=<%= utente.getID_Utente()%>">
    						<input type="hidden" name="IdAsta" value="${i.ID}"/>
    						<input type="hidden" name="idUtente" value="idUtente"/>
    						<c:out value = "${i.titolo}"/>
    					</a></h1>
						<p><c:out value = "${i.descrizione}"/></p>
						<h5>Data fine: <c:out value = "${i.dataFine}"/></h5>
						<h5>Prezzo attuale: <c:out value = "${i.offertaPiuAlta}"/> €</h5>
						<h2><c:out value = "Asta a tempo fisso"/></h2>		     
   					</div>
  				</div> 		
  			</div>
	</c:if>
	
</c:forEach>
	

	
   
<!--Footer:-->

<div class="footer">
	<p> DietiDeals24 &#169;</p>
</div>


</body>
</html>