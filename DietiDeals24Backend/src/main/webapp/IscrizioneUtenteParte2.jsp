<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/headerAndFooter.css">
<link rel="stylesheet" type="text/css" href="css/loginStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<title>Iscrizione:Ci sei quasi..</title>
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
 
<!-- LOGIN-->

<div>
	<a href="iscrizioneUtenteParte1.jsp">
	<i class="fa-solid fa-arrow-left freccia-indietro"></i>
	</a>
</div>
	
<div>
	<h1>Creazione account: Personalizza il tuo profilo!</h1>
</div>

<br><br>
	
<div class="flex-diviso2">	

	<div>
		<h4>Inserisci qui la tua foto profilo:</h4>
		<i class="fa-solid fa-file-circle-plus immagineProfilo"></i>
	</div>
	
	<div>
		<h4>Parlaci di te:</h4>
		<input type="text" class="shortBio">
	</div>	
	
	<div>
		<h4>Posizione geografica:</h4>
		<input type="text" class="inputTesto">
	</div>
	

</div>

<div>
	<h4>Link ai tuoi socials:</h4>
	<i class="fa-solid fa-circle-plus plusButton"></i>
</div>	

<br>

<div>
	<a href="index.jsp">
		<button type="button" class="avantiButton">Fine</button>
	</a>
</div>



<!--Footer:-->
<br><br><br><br><br><br>
<div class="footer">
	<p> DietiDeals24 &#169</p>
</div>
</body>
</html>