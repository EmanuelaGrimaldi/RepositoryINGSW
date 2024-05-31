<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "implementazione.UtenteRepositoryImpl, entità.Utente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/headerAndFooter.css">
<link rel="stylesheet" type="text/css" href="css/loginStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<title>Login: Welcome!</title>
</head>
<body>
<!--INIZIO HEADER-->

<div class ="bluePadding"></div>

<div class="over_header">
	<div class="loginButton">
		<i class="fa-regular fa-user">
			<a href="login.jsp">Login</a>
		</i>	
	</div>
	
</div>	
<div class="header">
		<div class="DietiDeals24_header">
			<img alt="logo" src="LOGO_DIETIDEALS.png">
		</div>
</div>	
<div class ="bluePadding"></div>		
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
 
<!-- LOGIN-->

<div>
	<a href="index.jsp">
	<i class="fa-solid fa-arrow-left freccia-indietro"></i>
	</a>
</div>
	
<div>
	<h1>Inserisci qui le tue credenziali:</h1>
</div>

<br><br>
	
	
	
	<form name="loginUtenteForm" method=post action="LoginUtenteEsistenteServlet">
	
		<div class="flex-diviso2">
	
			<div>
				<h2>Email:</h2>
				<input type="text" name="inputEmail" class="inputTesto">
			</div>
	
			<div>
				<h2>Password:</h2>
				<input type="password" name="inputPassword" class="inputTesto">
			</div>		
		</div>
		<div>
			<input type="submit" value="Avanti" class="avantiButtonLogin"/>
		</div>

	</form>
	
<br>
<div>
	<a href="iscrizioneUtenteParte1.jsp">
	<h3>Non sei già iscritto?Clicca qui!</h3>
	</a>
</div>




<!--Footer:-->
<br><br><br><br><br><br>
<div class="footer">
	<p> DietiDeals24 &#169</p>
</div>
</body>
</html>