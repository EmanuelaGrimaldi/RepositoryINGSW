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
    		<i class="fa fa-caret-down"></i>
   		</button>
   		<div class="dropdown-content">
      		<a href="#">Asta all'inglese</a>
      		<a href="#">Asta a tempo fisso</a>
    	</div>
  </div>
  
  			
  <div class="dropdown">
  			<%! 
  				String categoria; 
  				enum categoriaenum{TabletTelefonia, Giocattoli, Elettronica, Arte, Immobili, Antiquariato}; 
  			%>
  			 
  		<button class="dropbtn">
  			Categorie
  			<i class="fa fa-caret-down"></i>
   		</button>
    	<div class="dropdown-content">
      		<a href="#">Tablet e telefonia
      			<%= categoria=categoriaenum.TabletTelefonia.toString()  %></a>
      		<a href="#">Giocattoli 
      			<%= categoria=categoriaenum.Giocattoli.toString()  %></a>
      		<a href="#">Elettronica 
      			<%= categoria=categoriaenum.Elettronica.toString()  %></a>
     	 	<a href="#">Arte 
     	 		<%= categoria=categoriaenum.Arte.toString() %></a>
    	    <a href="#">Immobili 
    	    	<%= categoria=categoriaenum.Immobili.toString()  %></a>
    	    <a href="#">Antiquariato 
    	    	<%= categoria=categoriaenum.Antiquariato.toString() %></a>
    	</div>
  </div>
</div>

<!-- FINE HEADER -->

 <br>
 
<!-- CODICE DINAMICO: PROVE-->

	<!--  al posto di astarepository metto la servlet? -->
	
	<% List<Asta> listaAsta = AstaRepositoryImpl.getInstance().findAll(); %>
	<% List<Asta> listaAstaPerCategoria = AstaRepositoryImpl.getInstance().findByCategoria( categoria ); %>
	
	

	<c:forEach var = "i" items="<%= listaAsta %>">
    	Item <c:out value = "No. ${i.titolo}"/><p>
    	Item <c:out value = "No. ${i.descrizione}"/><p>
	</c:forEach>
	
	
	
	
	<c:choose>
	    <c:when test="${param.enter=='1'}">
	 
	        <br />
	    </c:when>    
	    <c:otherwise>
	        pizzas. 
	        <br />
	    </c:otherwise>
	</c:choose>
	
	
	<!-- funziona ma non conosco il tag <option> 
	<c:forEach var="element" items="<%= listaAsta %>">
	  	<option value="${element}">${element}</option>
	 </c:forEach>
	FINE-->
	

<!-- vecchi esempi:
  <div class="flex-diviso2 cell">
    <div>
    	<h3>OFFERTA</h3>		
		<h1>
			<a href="profiloAsta.html">TITOLO ARTICOLO:</a>
			<%=	get()%>
			
			
		</h1>
		<h2>Nome venditore: Mario Rossi</h2>
		<h2>Descrizione Merce:</h2>
		<p>Descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione</p>     
    </div>
    <a href="profiloAsta.html">
    	<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTufU2S_PzDaYmOTvxGL7M-OE-XOn7Op9E3XRL3vWYXAw&s" 
   		alt="Immagine prodotto"
    	class="immagineAsta">
    </a>
  </div> 
  
    <div class="flex-diviso2 cell">
    	<a href="profiloAsta.html">
    		<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTufU2S_PzDaYmOTvxGL7M-OE-XOn7Op9E3XRL3vWYXAw&s" 
    		 alt="Immagine prodotto"
    		 class="immagineAsta">
     	</a>
    <div>
		<h3>
			<a href="profiloAsta.html"></a>
			OFFERTA
		</h3>
		<h1>
			<a href="profiloAsta.html"></a>
			TITOLO ARTICOLO:
		</h1>
		
		
		<h2>Nome venditore: Mario Rossi</h2>
		<h2>Descrizione Merce:</h2>
		<p>Descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione</p>    
    </div>
  </div> 
   
   

  <div class="flex-diviso2 cell">
  	<div>
  		<h3>
			<a href="profiloAsta.html"></a>
			OFFERTA
		</h3>
		<h1>
			<a href="profiloAsta.html"></a>
			TITOLO ARTICOLO:
		</h1>
		<h2>Nome venditore: Mario Rossi</h2>
		<h2>Descrizione Merce:</h2>
		<p>Descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione</p>     
    </div>
    <a href="profiloAsta.html">
   		<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTufU2S_PzDaYmOTvxGL7M-OE-XOn7Op9E3XRL3vWYXAw&s" 
    	alt="Immagine prodotto"
    	class="immagineAsta">
    </a>
  </div> 
  
    <div class="flex-diviso2 cell">
     <a href="profiloAsta.html">
   		 <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTufU2S_PzDaYmOTvxGL7M-OE-XOn7Op9E3XRL3vWYXAw&s" 
    	 alt="Immagine prodotto"
    	 class="immagineAsta">
    </a>
     <div>
     	<h3>
			<a href="profiloAsta.html"></a>
			OFFERTA
		</h3>
		<h1>
			<a href="profiloAsta.html"></a>
			TITOLO ARTICOLO:
		</h1>
		<h2>Nome venditore: Mario Rossi</h2>
		<h2>Descrizione Merce:</h2>
		<p>Descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione</p>    
    </div>
  </div> 
  
   -->
   
<!--Footer:-->

<div class="footer">
	<p> DietiDeals24 &#169;</p>
</div>


</body>
</html>