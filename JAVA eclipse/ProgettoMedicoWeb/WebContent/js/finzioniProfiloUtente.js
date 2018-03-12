// area riservata medico 

var soggetto = localStorage.getItem('soggetto');
if(soggetto){
	soggetto= JSON.parse(soggetto)
	$('#cognUtente').html(soggetto.cognome)
	$('#nomUtente').html(soggetto.nome)
	$('#emailUtente').html(soggetto.email)
	
	var p ={}
	p.emailMed = soggetto.email
	console.log(p)
	$.ajax({
		url: 'ProfiloUtente',
		method: 'get',
		data: p
	}).done(function(utente){
		console.log(utente)
	})
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


// 

function listaPrenotazioniUtente(){
	var rows = "";
	$.getJSON("/ProgettoMedicoWeb/ProfiloUtente", {utente: "gupta@gmail.com" })
	.done(function( response ){
		$.foreach( response, function(index, item){
//			item.idPrenotazione
//			item.idPrenotazione
//			item.nome_dottore
//			item.nome_ambulatorio
//			item.data
//			item.ora
//			item.tipologia_prenotazione
//			item.motivazione
//			item.Ambulatorio_idAmbulatorio
//			item.Utente_idUtente
//			item.Medico_idMedico

			rows += `<tr>
			<th scope="nomeMedico">` + item.nome_dottore + `</th>
			<td data-title="motivazione">` + item.motivazione + `</td>
			<td data-title="data" data-type="date">` + item.data + `</td>
			<td data-title="ora" data-type="time">` + item.ora + `</td>
			<td data-title="indirizzo">` + item.nome_ambulatorio + `</td>
			<td>
				<div class="container">

					<!-- Trigger the modal with a button -->
					<button type="button" class="btn btn-info btn-lg" data-id="` + item.idPrenotazione + `" data-toggle="modal" data-target="#modal2">Elimina</button>

					<!-- Modal -->
					</div></td>
			</tr>`;

		});
		
		$("#listaPrenotazioni tbody").html( rows );
	
	});

}
}