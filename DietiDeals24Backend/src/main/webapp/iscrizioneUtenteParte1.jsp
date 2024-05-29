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

<title>Iscrizione</title>
</head>
<body>
	<!--INIZIO HEADER-->
	<div class="over_header">
		<div class="loginButton">
			<i class="fa-regular fa-user"> <a href="login.jsp">Login</a>
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
		<a href="login.jsp"> <i
			class="fa-solid fa-arrow-left freccia-indietro"></i>
		</a>
	</div>

	<div>
		<h1>Creazione account: Per favore inserisci i tuoi dati:</h1>
	</div>

	<br>
	<br>




	<form name="loginForm" method="post" action="LoginUtente">

		<div class="flex-diviso2">
			<div>
				<h4>Nome:</h4>
				<!-- <input type="text" class="inputTesto"> -->
				<input type="text" placeholder="Enter Nome" name="nome" required>
			</div>
			<div>
				<h4>Cognome:</h4>
				<!-- <input type="text" class="inputTesto"> -->
				<input type="text" placeholder="Enter Cognome" name="cognome"
					required>
			</div>
			<div>
				<h4>Email:</h4>
				<!-- <input type="text" class="inputTesto"> -->
				<input type="text" placeholder="Enter Email" name="email" required>
			</div>
			<div>
				<h4>Crea la tua Password:</h4>
				<!-- <input type="text" class="inputTesto"> -->
				<input type="password" placeholder="Enter Password" name="password"
					required>
			</div>

			<!-- non c'è la data di nascita nel db -->
			 <div>
				<h4>Data di nascita:</h4>
				<!-- <input type="date" class="inputTesto">  -->  
				<input type="date" name="dataDiNascita" required>
			</div>
			<div>
				<input type="submit" value="avanti" class="avantiButton"/>
			</div>
		</div>

	</form>
<!--
	<div>
		<a href="IscrizioneUtenteParte2.jsp">
			<button type="button" class="avantiButton">Avanti</button>
		</a>
	</div>
	 
	<!--
<div class="flex-diviso2">	

	<div>
		<h4>Email:</h4>
		<input type="text" class="inputTesto">
	</div>
	
	<div>
		<h4>crea la tua Password:</h4>
		<input type="text" class="inputTesto">
	</div>	
	
	<div>
		<h4>Nome e Cognome:</h4>
		<input type="text" class="inputTesto">
	</div>	
	
	<div>
		<h4>Data di nascita:</h4>
		<input type="date" class="inputTesto">
	</div>
</div>


 -->




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