var soggetto = localStorage.getItem('soggetto');
if(soggetto){
	soggetto = JSON.parse(soggetto);
$('#salvaNuovaPassword').click(function(e){

var passwordAttuale= soggetto.password;
var passwordNuova = document.getElementById('passwordNuova').value;
var confermaPassword = document.getElementById('passwordNuovaConf').value;

if((passwordAttuale=="")|| (passwordAttuale!=soggetto.password)){
	window.alert('password errata');
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
	$.ajax({
		url: 'ModificaDatiMedico',
		method: 'post',
		data: $('#modalRegistraPassword').serialize()
	})
	.done(function(esito){
		console.log(esito);
		if(esito.success) {
			localStorage.setItem('soggetto', JSON.stringify(esito.oggettoRisultante));
			window.alert("Password cambiata correttamente");
			location.href ='AreaPersonaleMed.html';
			localStorage.clear();
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