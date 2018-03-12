var soggetto = localStorage.getItem('soggetto');
if(soggetto){
	soggetto = JSON.parse(soggetto);
$('#salvaNuovaPassword').click(function(e){

var passwordAttuale= document.getElementById('passwordAttuale').value;
var passwordNuova = document.getElementById('passwordNuova').value;
var confermaPassword = document.getElementById('passwordNuovaConf').value;

if((passwordAttuale=="")||(passwordAttuale!=soggetto.password)){
	window.alert('La password da modificare non è corretta!');
	document.modulo.pw.focus();
	return false;
}
if((passwordNuova=="")||(passwordNuova=="undefined")){
	window.alert('Completare il campo con la nuova password');
	document.modulo.pw.focus();
	return false;
}
if((confermaPassword=="")||(confermaPassword=="undefined")){
	window.alert('Confermare la nuova password');
	document.modulo.focus();
	return false;
}

if(passwordNuova!=confermaPassword){
	window.alert('Nuova password e conferma password non corrispondono');
	 document.modulo.passwordNuovaConf.value = "";
	   document.modulo.passwordNuovaConf.focus();
	   return false;
}
else{
	e.preventDefault();
	var oggetto = {
			email: soggetto.email,
			numeroTelefono: soggetto.numeroTelefono,
			password: $('#passwordNuova').val()
	};
	console.log('debug funzionalità di myModal' + JSON.stringify(oggetto));
	$.ajax({
		url: 'ModificaDatiMedico',
		method: 'post',
		data: oggetto
	})
	.done(function(esito){
		console.log(esito);
		if(esito.success) {
			localStorage.setItem('soggetto', JSON.stringify(esito.oggettoRisultante));
			window.alert("Password cambiata correttamente");
			location.href ='AreaRiservataMed.html';
	}
		
		else
			window.alert("Cambio Password fallito");
	})
	.fail(function() {
		window.alert("qualcosa è andato storto.");
		console.error('qualcosa è andato storto.')
	});
	
	}

	

});
}