// area riservata medico 

var soggetto = localStorage.getItem('soggetto');
if(soggetto){
	soggetto= JSON.parse(soggetto)
	$('#cognMedico').html(soggetto.cognome)
	$('#nomMedico').html(soggetto.nome)
	$('#tipMedico').html(soggetto.tipologia)
	$('#telefonoMedico').html(soggetto.numeroTelefono)
	$('#emailMedico').html(soggetto.email)
	var e ={}
	e.emailMed = soggetto.email
	console.log(e)
	$.ajax({
		url: 'elencoAmbulatori',
		method: 'post',
		data: e
	}).done(function(ambulatorio){
	})
}

// logout medico

function logout(){
	if(soggetto){
	var domanda = window.confirm("Vuoi uscire dalla pagina?")
	if(domanda){
		top.location.href = 'Login.html';
    	localStorage.clear();
	}else{
		console.log("errore");
	}
	}else{
		console.log("non hai effettuato l'accesso");
	}
}

// funzione per fare login o logout nella pagina di prenotazione.

function loginOLogout(){
	if(soggetto){
		esito = logout();
	}else{
		top.location.href = 'registerPage.html';
	}
}

// funzione per modificare il numero di telefono



