// Dati del medico

var soggetto = localStorage.getItem('soggetto');
if(soggetto){
	// proietto sul file html i dati presi dal database usando il localstorage
	soggetto= JSON.parse(soggetto)
	$('#cognMedico').html(soggetto.cognome)
	$('#nomMedico').html(soggetto.nome)
	$('#tipMedico').html(soggetto.tipologia)
	$('#telefonoMedico').html(soggetto.numeroTelefono)
	$('#emailMedico').html(soggetto.email)
	
	// creo un oggetto e che ha come parametro solo la mail
	var e ={}
	e.emailMed = soggetto.email
	
	// faccio una chiamata ajax per ottenere tutti gli ambulatori
    $.ajax({
		url: 'elencoAmbulatori',
		method: 'post',
		data: e
	}).done(function(ambulatori){
		
	// faccio un ciclo for each e per ogni ambulatorio ottengo il suo indirizzo che poi proietto su html
		//poi lo appendo sul tag <p> con l'id sottostante
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
	// se il soggetto(medico) esiste nel localStorage
	// creo un oggetto chimato medico, a cui passo una mail
	var medico = {}
	medico.email = soggetto.email
	// faccio una chiamata ajax per ottenere tutte le prenotazioni a lui associate tramite mail
	$.ajax({
		url:'PrenotazioniMedico',
		method:'post',
		data:medico
    })
    .done(function(prenotazioni){
    	// faccio un ciclo foreach e per ogni prenotazione ottengo i dati sottoelencati 
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
			var emailUtente = visita.utente.email
			
			var appendiStorico = '<tr id="'+id+'" class="trVisite"><td>'+nomeMedico+' '+cognMedico+'</td>'+
			'<td>'+emailMedico+'</td>'+
			'<td>'+motivazione+'</td>'+
			'<td data-type="date">'+data+'</td>'+
			'<td data-type="time">'+ora+'</td>'+
			'<td>'+indirizzo+'</td>'+
			'<td><div class="container">'+
			'<button type="button" class="btn btn-info btn-lg aggiungiRecensione" idPrenotazione="'+id+'"data-toggle="modal" data-target="#myModal">Recensione</button>'+
				'</div>'+
			'</td></tr>'
				
				var appendiDaEffettuare = '<tr id ="'+id+'" class="trVisite"><td>'+nomeMedico+' '+cognMedico+'</td>'+
				'<td>'+emailMedico+'</td>'+
				'<td>'+motivazione+'</td>'+
				'<td data-type="date">'+data+'</td>'+
				'<td data-type="time">'+ora+'</td>'+
				'<td>'+indirizzo+'</td>'+
				'<td><div class="container">'+
				'<button type="button" class="btn btn-info btn-lg btnEliminaPrenotazione" idPre="'+id+'" emailUt="'+emailUtente+'" >Elimina</button>'+
					'</div>'+
				'</td></tr>'
		if(visitaIniziata==true){
		$('#tabellaStorico').append(appendiStorico);
			}else{
				$('#listaPrenotazioni').append(appendiDaEffettuare);
			}
		 })
		 		// eliminazione delle singole visite
			$('.btnEliminaPrenotazione').click(function(){
				var domanda = window.confirm('vuoi eliminare la prenotazione?');
				if(domanda){
				var emailUt= $(this).attr('emailUt');
				var idPre= $(this).attr('idPre');
				var visitaDaEliminare ={
						emailUtente: emailUt,
						id : idPre
				};
				
				console.log('visita da eliminare = '+ visitaDaEliminare);
				
			$.ajax({
				url:'EliminaPrenotazione',
				method:'post',
				data:visitaDaEliminare
			})
			.done(function(elimina){
				console.log(elimina)
				if(elimina.success){
					var arrVisite= [];
					$.each(visite,function(i,visita){
						if(visita.id == idPre){
							
						}else{
							arrVisite.push(visita);
							localStorage.setItem('visite',JSON.stringify(visite));
						}
					})
				
				}else{
					window.alert('cancellazione non avvenuta!!!')
				}
			
			})
			}
			})
			
		// aggiungi la recensione all'utente
		$('.aggiungiRecensione').click(function(){
			var idRecensione= $(this).attr('idPrenotazione')
			$('.recensione').click(function(){
			    
			    console.log('id= ' + idRecensione)
				val = $(".star:checked").val();
				console.log("Voto: " + val);
				var recensione={
						id:idRecensione,
						voto:val
				};
				console.log(recensione)
				$.ajax({
			url: 'RecensionePrenotazione',
			method: 'post',
			data: recensione
		})
		.done(function(recensisci){
			console.log(recensisci);
			if(recensisci.success){
				localStorage.setItem('visite', JSON.stringify(visite))
				alert('recensione effettuata')
				location.href='ProfiloUtente1.html'
			
			}else{
				window.alert('recensione non effettuata!')
			}
		})
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




