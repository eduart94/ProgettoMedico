var utente = localStorage.getItem('utente');
if(utente){
	utente = JSON.parse(utente);
$('#salvaPasswordUtente').click(function(e){

var passwordAttuale= document.getElementById('passwordAttualeUtente').value;
var passwordNuova = document.getElementById('passwordNuovaUtente').value;
var confermaPassword = document.getElementById('passwordNuovaConfUtente').value;

if((passwordAttuale=="")||(passwordAttuale!=utente.password)){
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
			email: utente.email,
			numeroTelefono: utente.numeroTelefono,
			password: $('#passwordNuovaUtente').val()
	};
	console.log('debug funzionalità di myModal' + JSON.stringify(oggetto));
	$.ajax({
		url: 'ModificaDatiUtente',
		method: 'post',
		data: oggetto
	})
	.done(function(esito){
		console.log(esito);
		if(esito.success) {
			localStorage.setItem('utente', JSON.stringify(esito.oggettoRisultante));
			window.alert("Password cambiata correttamente");
			location.href ='ProfiloUtente1.html';
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