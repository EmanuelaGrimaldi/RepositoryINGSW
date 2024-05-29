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
   			<a href="homeByTipologia.jsp?tipologia=astaInglese">
    				<input type="hidden" name="tipologia" value="astaInglese"/>
      				Asta all'inglese</a> 
			<a href="homeByTipologia.jsp?tipologia=astaTempoFisso">
    				<input type="hidden" name="tipologia" value="astaTempoFisso"/>
      				Asta a tempo fisso</a> 		
    	</div>
  </div>
  <div class="dropdown"> 
  		<button class="dropbtn">
  			Categorie
    		<i class="fa fa-caret-down"></i>
   		</button>
    	<div class="dropdown-content">
      		<a href="homeByCategoria.jsp?categoria=TabletTelefonia">
    				<input type="hidden" name="categoria" value="TabletTelefonia"/>
    				Tablet e telefonia</a>
      		<a href="homeByCategoria.jsp?categoria=Giocattoli">
    				<input type="hidden" name="categoria" value="Giocattoli"/>
    				Giocattoli</a>
      		<a href="homeByCategoria.jsp?categoria=Elettronica">
    				<input type="hidden" name="categoria" value="Elettronica"/>
    				Elettronica</a>
     	 	<a href="homeByCategoria.jsp?categoria=Arte">
    				<input type="hidden" name="categoria" value="Arte"/>
    				Arte</a>
    	    <a href="homeByCategoria.jsp?categoria=Immobili">
    				<input type="hidden" name="categoria" value="Immobili"/>
    				Immobili</a>
    	    <a href="homeByCategoria.jsp?categoria=Antiquariato">
    				<input type="hidden" name="categoria" value="Antiquariato"/>
    				Antiquariato</a>
    	</div>
  </div>
</div>

<!-- FINE HEADER -->
 
	<%	
    //per prendere ID dall'url
    String stringAstaID = request.getParameter("idAsta");
	int intAstaID = Integer.valueOf(stringAstaID);
 	Asta asta = AstaRepositoryImpl.getInstance().findbyID(intAstaID);
 	Utente venditore = UtenteRepositoryImpl.getInstance().findbyID(asta.getProprietario_FK());
	%>
	
	
<c:set var="Asta" value="${asta}" />

<h1><%= asta.getTitolo() %></h1>

<div class="background">

	<div class="flex-diviso2">
	
		<div class="divSX">
    		<img src= "<%=asta.getFotoAsta1() %>" alt="Immagine prodotto" class="immagineAsta">  
    		<div class ="descrizioneAsta">
    				<p><%=asta.getDescrizione()%></p>
    		</div>  
    	</div>
		
		<div  class="divDX">
			
			<c:set var="tipoAsta" value="<%=asta.getTipologia()%>" />
			
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
						<br><br>
						<h4>Data di scadenza: <%=asta.getDataFine() %></h4>
					</div>
    			</c:otherwise> 
   			</c:choose>
   			
			<br><br>
			<div class="Offerta">
				FAI LA TUA OFFERTA
			</div>	
			<div class="profiloVenditore">
					<img src= "<%= venditore.getFotoProfilo() %>" 
    				alt="Propic Venditore"
    				class="fotoVenditore"> 
    				
    			<div class="nomeVenditore">
    				<%= venditore.getNome() %> <%= venditore.getCognome() %>
    			</div>
    				
    			<div class="scrittaVisitaProfilo">
    				<a href="profiloVenditore.jsp?idUtente=<%= venditore.getID_Utente() %>">
    					<input type="hidden" name="idUtente" value="<%= venditore.getID_Utente() %>"/>
    					Visita il profilo
    				</a>
    			</div>
			</div>
		</div>
	</div>


</div>




<!--Footer:-->

<div class="footer">
	<p> DietiDeals24 &#169</p>
</div>
</body>
</html><html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>