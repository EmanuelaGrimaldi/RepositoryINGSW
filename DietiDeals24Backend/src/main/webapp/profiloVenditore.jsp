<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "implementazione.AstaRepositoryImpl, implementazione.UtenteRepositoryImpl, java.util.List, entità.Asta, entità.Utente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/headerAndFooter.css">
<link rel="stylesheet" type="text/css" href="css/profiloVenditoreStyle.css">
<link rel="stylesheet" type="text/css" href="css/indexStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<title>DietiDeals24</title>
</head>
<body>
<!--INIZIO HEADER-->
<div class="over_header">
	<div class="loginButton">
		<i class="fa-regular fa-user">
			<a href="login.jsp">Login</a>
		</i>	
	</div>
	
</div>	
<div class="header">
		<!--INSERIRE LOGO QUI:-->
		<div class="DietiDeals24_header">
			<a href="index.jsp">DietiDeals24</a>
		</div>
</div>		
<div class="under-header">
  	<div class="homeButton">
  		<a href="index.jsp">Home</a> 
  	</div> 		
  	<div class="dropdown">		
  		<button class="dropbtn">
  			Tipi di Asta
    		<i class="fa fa-caret-down"></i>
   		</button>
   		<div class="dropdown-content">
      		<a href="homeByAstaInglese.jsp">Asta all'inglese</a> 
      		<a href="homeByAstaTempoFisso.jsp">Asta a tempo fisso</a>
      		
    	</div>
  </div>
  <div class="dropdown"> 
  		<button class="dropbtn">
  			Categorie
    		<i class="fa fa-caret-down"></i>
   		</button>
    	<div class="dropdown-content">
      		<a href="homeByTabletTelefonia.jsp">Tablet e telefonia</a>
      		<a href="homeByGiocattoli.jsp">Giocattoli</a>
      		<a href="homeByElettronica.jsp">Elettronica</a>
     	 	<a href="homeByArte.jsp">Arte</a>
    	    <a href="homeByImmobili.jsp">Immobili</a>
    	    <a href="homeByAntiquariato.jsp">Antiquariato</a>
    	</div>
  </div>
</div>

<!-- FINE HEADER -->
 
 	<!--IMPORTANTE 
 	
 		DA FARE: COME MI PORTO L'ID DEL VENDITORE DALLA PAGINA PROFILOASTA? 

 		Come select * from utente where IDUtente = asta.Proprietario.FK-->
 	
 	
 <!-- INIZIO HEADER VENDITORE -->
 
 	<%	
	Utente venditore;
 	venditore = UtenteRepositoryImpl.getInstance().findbyID(1);
	%>
 
 	 <!-- Domanda: c per singolo oggetto?-->
 	
 	<div class="headerVenditore">
 		<div class="divSX">
    		<<img src="${venditore.fotoProfilo}" alt="Immagine prodotto" class="immagineVenditore">    
    	</div>
 		<div class="divDX">
 			<h4 class="nomeVenditore"><c:out value = "${venditore.nome}"/>  <c:out value = "${venditore.cognome}"/>"/></h4>
 			<h4><c:out value = "${venditore.geolocalizzazione}"/></h4>
 			<p><c:out value = "${venditore.biografia}"/></p>
 			<i class="fa-solid fa-link iconaLink">&nbsp <c:out value = "${venditore.elencoSocial}"/></i>
 		</div>
 	</div>
  	
<!-- FINE HEADER VENDITORE -->

	<div class="asteVenditore">Aste venditore:</div>	 	
 	 
 	<%	
	List<Asta> listaAsta;
	listaAsta = AstaRepositoryImpl.getInstance().findAstaByProprietarioFK(1);		
	%>

<!--INIZIO BODY ASTE-->	
	<c:forEach var = "i" items="<%= listaAsta %>">
	
	
	<c:if test= "${i.tipologia == 'astaInglese'}">
	
		<div class="flex-diviso2 cell">
			<div>
    			<a href="profiloAsta.html">
    				<img src="${i.fotoAsta1}" alt="Immagine prodotto" class="immagineAsta">
   	 			</a>
   	 		</div>	 	
    		<div>
				<div class="testoAsta">		
					<h1><a href="profiloAsta.html"><c:out value = "${i.titolo}"/></a></h1>
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
    			<a href="profiloAsta.html">
    				<img src="${i.fotoAsta1}" alt="Immagine prodotto" class="immagineAsta">
   	 			</a>
   	 		</div>	
    		<div>
				<div class="testoAsta">		
					<h1><a href="profiloAsta.html"><c:out value = "${i.titolo}"/></a></h1>
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
	<p> DietiDeals24 &#169</p>
</div>
</body>
</html></html>