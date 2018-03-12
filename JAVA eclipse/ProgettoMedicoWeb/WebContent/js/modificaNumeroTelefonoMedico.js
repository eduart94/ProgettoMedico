// modifichiamo il numero di telefono del medico
var soggetto = localStorage.getItem('soggetto');
if(soggetto){
	soggetto= JSON.parse(soggetto)
$('#salvaNumeroMedico').click(function(e){
	e.preventDefault();
	var editObj = {
			numeroTelefono: $('#numeroTelefonoMedico').val(),
			email: soggetto.email,
			password: soggetto.password
	};
	console.log('debug funzionalità di myModal' + JSON.stringify(editObj));
	$.ajax({
		url:'ModificaDatiMedico',
		method:'post',
		data:editObj
	})
	.done(function(esito){
		console.log("esito della ajax: " + JSON.stringify(esito));
		if(esito.success){
			localStorage.setItem('soggetto',JSON.stringify(esito.oggettoRisultante))
			alert('numero di telefono modificato con successo')
			window.location=('AreaRiservataMed.html')
		}else{
			alert('modifica non avvenuta')
		}
	})
})
}