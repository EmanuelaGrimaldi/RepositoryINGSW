<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	<a href="login.jsp">
		<div class="loginButton">
		<i class="fa-regular fa-user"></i>   Login</div>
	</a>	
</div>	
<div class="header">
	<a href="index.jsp">
		<!--INSERIRE LOGO QUI:-->
		<div class="DietiDeals24_header">
		DietiDeals24
		</div>
	</a>
</div>		
<div class="under-header">

	<a href="index.jsp"> 
  		<div class="homeButton">Home</div> 		
  	</a>
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
  		<button class="dropbtn">
  			Categorie
    		<i class="fa fa-caret-down"></i>
   		</button>
    	<div class="dropdown-content">
      		<a href="#">Tablet e telefonia</a>
      		<a href="#">Giocattoli</a>
      		<a href="#">Elettronica</a>
     	 	<a href="#">Arte</a>
    	    <a href="#">Immobili</a>
    	    <a href="#">Antiquariato</a>
    	</div>
  </div>
</div>

<!-- FINE HEADER -->

 <br>
 
<!-- Containers per le aste-->

  <div class="flex-diviso2 cell">
    <div>
    	<h3>OFFERTA</h3>	
		<a href="profiloAsta.html">
		<h1>TITOLO ARTICOLO:</h1>
		</a>
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
		<a href="profiloAsta.html">
		<h3>OFFERTA</h3>
		<h1>TITOLO ARTICOLO:</h1>
		</a>
		<h2>Nome venditore: Mario Rossi</h2>
		<h2>Descrizione Merce:</h2>
		<p>Descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione</p>    
    </div>
  </div> 
   
   <!--AGGIUNTO SOLO A SCOPO VISIVO: DA CANCELLARE-->

  <div class="flex-diviso2 cell">
  	<div>
  		<a href="profiloAsta.html">
  		<h3>OFFERTA</h3>
		<h1>TITOLO ARTICOLO:</h1>
		</a>
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
     	<h3>OFFERTA</h3>
		<a href="profiloAsta.html"></a>
		<h1>TITOLO ARTICOLO:</h1>
		</a>
		<h2>Nome venditore: Mario Rossi</h2>
		<h2>Descrizione Merce:</h2>
		<p>Descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione</p>    
    </div>
  </div> 
  
   <!--FINE CODICE DA CANCELLARE-->
   
<!--Footer:-->

<div class="footer">
	<p> DietiDeals24 &#169</p>
</div>


</body>
</html>