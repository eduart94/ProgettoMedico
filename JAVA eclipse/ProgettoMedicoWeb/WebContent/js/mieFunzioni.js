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
	utente= JSON.parse(utente)
	$('#nomeUtente').html(utente.nome)
	$('#cognUtente').html(utente.cognome)
	$('#emailUtente').html(utente.email)
	
	var u = {};
	u.emailUtente= utente.email;
	$.ajax({
		url:'UtentePrenotazioni',
		method:'post',
		data:u
	})
	.done(function(visite){
		localStorage.setItem('visite', JSON.stringify(visite))
	$.each(visite,function(i,visita){
			var nomeMedico = visita.medico.nome;
			var cognMedico = visita.medico.cognome;
			var motivazione = visita.motivazione;
			var data = visita.dataStringa;
			var ora  = visita.ora;
			var indirizzo = visita.ambulatorio.indirizzo;
			var citta = visita.ambulatorio.citta.nome;
			var emailMedico= visita.medico.email;
			var visitaIniziata= visita.iniziato;
			var id = visita.id;
			
			var appendiStorico = '<tr id="'+id+'" class="trVisite"><td>'+nomeMedico+' '+cognMedico+'</td>'+
			'<td>'+emailMedico+'</td>'+
			'<td>'+motivazione+'</td>'+
			'<td data-type="date">'+data+'</td>'+
			'<td data-type="time">'+ora+'</td>'+
			'<td>'+indirizzo+'</td>'+
			'<td><div class="container">'+
			'<button type="button" class="btn btn-info btn-lg"data-toggle="modal" data-target="#myModal">Recensione</button>'+
				'</div>'+
			'</td></tr>'
				
				var appendiDaEffettuare = '<tr id ="'+id+'" class="trVisite"><td>'+nomeMedico+' '+cognMedico+'</td>'+
				'<td>'+emailMedico+'</td>'+
				'<td>'+motivazione+'</td>'+
				'<td data-type="date">'+data+'</td>'+
				'<td data-type="time">'+ora+'</td>'+
				'<td>'+indirizzo+'</td>'+
				'<td><div class="container">'+
				'<button type="button" class="btn btn-info btn-lg btnEliminaPrenotazione" >Elimina</button>'+
					'</div>'+
				'</td></tr>'
		if(visitaIniziata==true){
		$('#tabellaStorico').append(appendiStorico);
			}else{
				$('#listaPrenotazioni').append(appendiDaEffettuare);
			}
			$('.btnEliminaPrenotazione').click(function(){
				var domanda = window.confirm('vuoi eliminare la prenotazione?');
				if(domanda){
				var visitaDaEliminare ={
						emailUtente: utente.email,
						id : visita.id
				};
				console.log(visitaDaEliminare);
			
			$.ajax({
				url:'EliminaPrenotazione',
				method:'post',
				data:visitaDaEliminare
			})
			.done(function(elimina){
				console.log(elimina)
				if(elimina.success){
					localStorage.setItem('visite', JSON.stringify(visite))
					location.href='ProfiloUtente1.html'
				
				}else{
					window.alert('cancellazione non avvenuta!!!')
				}
			
			})
			}
			})
		})
	})
	
}

// elimina la prenotazione


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




