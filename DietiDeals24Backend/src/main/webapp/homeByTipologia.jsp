<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "implementazione.AstaRepositoryImpl, java.util.List, entità.Asta"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/headerAndFooter.css">
<link rel="stylesheet" type="text/css" href="css/indexStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />


<title>Aste a tempo fisso: DietiDeals24</title>
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
    String stringTipologia = request.getParameter("tipologia");
	List<Asta> listaAste;
	listaAste = AstaRepositoryImpl.getInstance().findByTipologia(stringTipologia);	
	System.out.println(listaAste.toString());
	%>

	<c:set var="tipoAsta" value="<%=stringTipologia%>" />
	
	<c:if test= "${tipoAsta == 'astaInglese'}">
	
		<c:forEach var = "i" items="<%= listaAste %>">
	
			<div class="flex-diviso2 cell">
				<div>
    				<a href="profiloAsta.jsp?idAsta=${i.ID}">
    					<input type="hidden" name="IdAsta" value="${i.ID}"/>
    					<img src="${i.fotoAsta1}" alt="Immagine prodotto" class="immagineAsta">
    				</a>
   	 			</div>	 	
    			<div>
					<div class="testoAsta">		
						<h1><a href="profiloAsta.jsp?idAsta=${i.ID}">
    						<input type="hidden" name="IdAsta" value="${i.ID}"/>
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
  		</c:forEach>
	</c:if>
	
	<c:if test= "${tipoAsta == 'astaTempoFisso'}">
	
		<c:forEach var = "i" items="<%= listaAste %>">
	
			<div class="flex-diviso2 cell">
				<div>
    				<a href="profiloAsta.jsp?idAsta=${i.ID}">
    					<input type="hidden" name="IdAsta" value="${i.ID}"/>
    					<img src="${i.fotoAsta1}" alt="Immagine prodotto" class="immagineAsta">
    				</a>
   	 			</div>	
    			<div>
					<div class="testoAsta">		
						<h1><a href="profiloAsta.jsp?idAsta=${i.ID}">
    						<input type="hidden" name="IdAsta" value="${i.ID}"/>
    						<c:out value = "${i.titolo}"/>
    					</a></h1>
						<p><c:out value = "${i.descrizione}"/></p>
						<h5>Data fine: <c:out value = "${i.dataFine}"/></h5>
						<h5>Prezzo attuale: <c:out value = "${i.offertaPiuAlta}"/> €</h5>
						<h2><c:out value = "Asta a tempo fisso"/></h2>		     
   					</div>
  				</div> 		
  			</div>
  		</c:forEach>
	</c:if>
	
 
<!--Footer:-->

<div class="footer">
	<p> DietiDeals24 &#169;</p>
</div>


</body>
</html>