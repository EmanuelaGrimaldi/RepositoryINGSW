<%@page import="entità.Utente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/headerAndFooter.css">
<link rel="stylesheet" type="text/css" href="css/loginStyle.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<title>Iscrizione:Ci sei quasi..</title>
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
			<a href="index.jsp" class="homeButton">Home</a>
		<div class="dropdown">
			<button class="dropbtn">
				Tipi di Asta <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="homeByTipologia.jsp?tipologia=astaInglese"> <input
					type="hidden" name="tipologia" value="astaInglese" /> Asta
					all'inglese
				</a> <a href="homeByTipologia.jsp?tipologia=astaTempoFisso"> <input
					type="hidden" name="tipologia" value="astaTempoFisso" /> Asta a
					tempo fisso
				</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				Categorie <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="homeByCategoria.jsp?categoria=TabletTelefonia"> <input
					type="hidden" name="categoria" value="TabletTelefonia" /> Tablet e
					telefonia
				</a> <a href="homeByCategoria.jsp?categoria=Giocattoli"> <input
					type="hidden" name="categoria" value="Giocattoli" /> Giocattoli
				</a> <a href="homeByCategoria.jsp?categoria=Elettronica"> <input
					type="hidden" name="categoria" value="Elettronica" /> Elettronica
				</a> <a href="homeByCategoria.jsp?categoria=Arte"> <input
					type="hidden" name="categoria" value="Arte" /> Arte
				</a> <a href="homeByCategoria.jsp?categoria=Immobili"> <input
					type="hidden" name="categoria" value="Immobili" /> Immobili
				</a> <a href="homeByCategoria.jsp?categoria=Antiquariato"> <input
					type="hidden" name="categoria" value="Antiquariato" />
					Antiquariato
				</a>
			</div>
		</div>
	</div>

	<!-- FINE HEADER -->

	<!-- LOGIN-->

	<div>
		<a href="iscrizioneUtenteParte1.jsp"> <i
			class="fa-solid fa-arrow-left freccia-indietro"></i>
		</a>
	</div>

	<div>
		<h1>Creazione account: Personalizza il tuo profilo!</h1>
	</div>

	<br>
	<br>

	<form name="loginForm2" method="get" action="LoginUtente2Servlet">
		<div class="flex-diviso2">

			<div>
				<h4>Inserisci qui la tua foto profilo:</h4>
				<i class="fa-solid fa-file-circle-plus immagineProfilo"></i> 
			</div>

			<div>
				<h4>Parlaci di te:</h4>
				<input type="text"
					placeholder="Inserisci una tua Biografia" name="biografia" class="shortBio">
			</div>
			<br><br>
			<div>
				<h4>Posizione geografica:</h4>
				<input type="text"
					placeholder="inserisci una short bio!"
					name="posizioneGeografica" class="inputTesto">
			</div>

			<div>
				<h4>Link ai tuoi socials:</h4>
				<input type="text"	placeholder="Inserisci il tuo social preferito" name="social" class="inputTesto">
			</div>

			<br>
					<input type="submit" value="Fine" class="avantiButton"/>
		</div>
		
		
		
		<%
		//create the object you want to pass 
		
		Utente obj = (Utente) request.getAttribute("utente");

		obj.setFotoProfilo((String) request.getAttribute("fotoProfilo"));
		obj.setBiografia((String) request.getAttribute("biografia"));
		obj.setGeolocalizzazione((String) request.getAttribute("posizioneGeografica"));
		obj.setLinkSocial((String) request.getAttribute("social"));
		
		session.setAttribute("utente", obj);
		//request.setAttribute("utente", obj);
		%>
	</form>


	<!--Footer:-->
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="footer">
		<p>DietiDeals24 &#169</p>
	</div>
</body>
</html>