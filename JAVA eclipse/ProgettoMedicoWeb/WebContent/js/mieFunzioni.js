// Dati del medico

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
    $.ajax({
		url: 'elencoAmbulatori',
		method: 'post',
		data: e
	}).done(function(ambulatori){
		
		
		$.each(ambulatori, function(i,ambulatorio){
			var indirizzo = ambulatorio.indirizzo
			var citta = ambulatorio.citta.nome
			var appendi = '<p>'+indirizzo + ',' + citta +'</p>'
			$('#indirizzoMedico').append(appendi);
		})
			
		
	})
}

//Prenotazioni del medico
if(soggetto){
	
	var medico = {}
	medico.email = soggetto.email
	$.ajax({
		url:'PrenotazioniMedico',
		method:'post',
		data:medico
    })
    .done(function(prenotazioni){
    	console.log(prenotazioni)
    	$.each(prenotazioni,function(i,prenotazione){
    		var data = prenotazione.dataStringa
    		var motivazione = prenotazione.motivazione
    		var ora = prenotazione.ora
    		var indirizzo = prenotazione.ambulatorio.indirizzo
    		var citta = prenotazione.ambulatorio.citta.nome
    		var emailUtente= prenotazione.utente.email
    		var nomeUtente= prenotazione.utente.nome
    		var cognomeUtente= prenotazione.utente.cognome
    		var appendi = '<tr><td id="dataTabella">'+data+
    		'</td><td id="timeTabella">'+ora+
    		'</td><td id="luogoTabella">'+indirizzo+','+citta+'</td>'+
    		'<td id="nomeECognomeUtente">'+nomeUtente+' '+cognomeUtente+'</td><td id="emailUtenteTabella">'+emailUtente+'</td><td id="motivazioneTabella">'
    		+motivazione+'</td></tr>'
    	    $('#bodyTabella').append(appendi)
    		
    	})
    })
}

// profilo personale del medico

var utente = localStorage.getItem('utente');
if(utente){
	utente = JSON.parse(utente)
	$('#nomeUtente').html(utente.nome)
	$('#cognUtente').html(utente.cognome)
	$('#emailUtente').html(utente.email)
}

// logout medico

function logout(){
	var domanda = window.confirm("Vuoi uscire dalla pagina?")
	if(domanda){
		top.location.href = 'Login.html';
    	localStorage.clear();
	}else{
		console.log("errore");
	}
}
//logout utente

function logoutUtente(){
	var domanda = window.confirm('vuoi uscire dalla tua area personale?');
	if(domanda){
		top.location.href='Login.html'
			localStorage.clear();
	}else{
		console.log('problema ad effettuare il logout');
	}
}
// loginOLogout

function loginOLogout(){
	if(soggetto){
		esito = logout();
	}else{
		console.log('non hai ancora effettuato accesso');
		alert('devi effettuare l accesso');
		window.location='Login.html'
		
	}
}




