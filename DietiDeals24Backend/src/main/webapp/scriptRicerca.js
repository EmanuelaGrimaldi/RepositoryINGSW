// Get the modal
var modalRicerca = document.getElementById("myModalRicerca");

// Get the button that opens the modal
var lenteRicercaButton = document.getElementById("lenteRicercaButton");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
lenteRicercaButton.onclick = function() {
  modalRicerca.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modalRicerca.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modalRicerca) {
    modalRicerca.style.display = "none";
  }
}