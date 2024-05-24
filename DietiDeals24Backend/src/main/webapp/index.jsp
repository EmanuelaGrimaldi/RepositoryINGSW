<%@page import="servlet.getAsteByTipologia"%>
<%@page import="servlet.getAsteByCategoria"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "javaJSP.getAllAste, servlet.getAsteHome,implementazione.AstaRepositoryImpl, java.util.List, entità.Asta"%>
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
  			<%! String tipologia; %>
    		<i class="fa fa-caret-down"></i>
   		</button>
   		<div class="dropdown-content">
      		<a href="#">Asta all'inglese</a> 	<%= tipologia="astaInglese" %> 
      		<a href="#">Asta a tempo fisso</a>	<%= tipologia="astaTempoFisso" %> 
      		
    	</div>
  </div>
  <div class="dropdown"> 
  		<button class="dropbtn">
  			Categorie
  			<%! String categoria; %>
    		<i class="fa fa-caret-down"></i>
   		</button>
    	<div class="dropdown-content">
      		<a href="#">Tablet e telefonia</a> <%= categoria="TabletTelefonia" %> 
      		<a href="#">Giocattoli</a> <%= categoria="Giocattoli" %>
      		<a href="#">Elettronica</a> <%= categoria="Elettronica" %>
     	 	<a href="#">Arte</a> <%= categoria="Arte" %>
    	    <a href="#">Immobili</a> <%= categoria="Immobili" %>
    	    <a href="#">Antiquariato</a><%= categoria="Antiquariato" %>
    	</div>
  </div>
</div>

<!-- FINE HEADER -->
		
	<!-- DA IMPLEMENTARE: Invece di "findAll" va cambiata la ricerca in base a:
			-HOME
			-CATEGORIA
			-TIPO ASTA
	-->
		
	<%	List<Asta> listaAsta, listaAsteByCategoria, listaAsteByTipologia, listaAsteInScadenza;
	
		listaAsta = AstaRepositoryImpl.getInstance().findAll();
		
		getAsteByCategoria asteByCategoria = new getAsteByCategoria(); 
		listaAsteByCategoria = asteByCategoria.findByCategoria(categoria);
		
		getAsteByTipologia asteByTipologia = new getAsteByTipologia();
		listaAsteByTipologia = asteByTipologia.findByTipologia(tipologia);
		
		getAsteHome asteInScadenza = new getAsteHome();
		listaAsteInScadenza = asteInScadenza.findAsteInScadenza();
	
		
	%>

	<c:forEach var = "i" items="<%= listaAsta %>">
	
	<div class="flex-diviso2 cell">
	
		<div>
    		<a href="profiloAsta.html">
    			<img src="${i.fotoAsta1}" alt="Immagine prodotto" class="immagineAsta">
   	 		</a>
   	 	</div>
   	 	
    	<div>
			<div class="testoAsta">
    			<h3>OFFERTA!</h3>		
				<h1><a href="profiloAsta.html"><c:out value = "${i.titolo}"/></a></h1>
				<p><c:out value = "${i.descrizione}"/></p>
				
				<!-- In base a tipo di asta -->
				<h5>Scadrà tra: <c:out value = "${i.timer}"/></h5>
				<h5>Data fine: <c:out value = "${i.dataFine}"/></h5>
				<h2><c:out value = "${i.tipologia}"/></h2>		     
   			</div>
  		</div> 
  		
  	</div>
  		   	
	</c:forEach>
	
	<!-- funziona ma non conosco il tag <option> 
	<c:forEach var="element" items="< % = listaAsta % > ">
	  	<option value="${element}">${element}</option>
	 </c:forEach>
	-->
	
   
<!--Footer:-->

<div class="footer">
	<p> DietiDeals24 &#169;</p>
</div>


</body>
</html>