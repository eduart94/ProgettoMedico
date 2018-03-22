// modifica password del medico

$('#salvaPasswordMedico').click(function(e){
	var emailMedico= document.getElementById('emMedico').value;
	var passwordNuova = document.getElementById('recPassMedico').value;
	var confermaPassword = document.getElementById('recConfPassMed').value;
	
	if((emailMedico=="")||(emailMedico=="undefined")){
		window.alert('compilare il campo email');
		document.modulo.email.focus();
		return false;
	}
	if((passwordNuova=="")||(passwordNuova=="undefined")){
		window.alert('compilare il campo Nuova password');
		document.modulo.passwordNuova.focus();
		return false;
	}
	if((confermaPassword=="")||(confermaPassword=="undefined")){
		window.alert('compilare il campo conferma password');
		document.modulo.confermaPassword.focus();
		return false;
	}
	if(passwordNuova!=confermaPassword){
		alert("La password confermata è diversa da quella scelta, controllare.");
		   document.modulo.confermaPassword.value = "";
		   document.modulo.confermaPassword.focus();
		   return false;
	}
	else{
		// 1. impedire al form HTML di fare submit
		e.preventDefault();
		var medico={
				email: emailMedico,
				password: passwordNuova
				
		}
		$.ajax({
			url: 'RecuperaPassword',
			method: 'post',
			data: medico
		})
		.done(function(esito){
			console.log(esito);
			if(esito.success) {
				window.alert("Il cambio password è fallito!");
			}
			
			else
			
			localStorage.setItem('soggetto', JSON.stringify(esito.oggettoRisultante));
			window.alert("Cambio effettuato con successo");
			location.href ='Login.html';
			localStorage.clear();
		})
		.fail(function() {
			window.alert("qualcosa è andato storto.");
			console.error('qualcosa è andato storto.')
		});
		
		}

})

// modifica password dell' utente
$('#salPassUtente').click(function(e){
	var emailUtente= document.getElementById('EmailUtenteId').value;
	var passwordNuova = document.getElementById('recPassUtenteId').value;
	var confermaPassword = document.getElementById('recConfermaPassUtenteId').value;
	
	if((emailMedico=="")||(emailMedico=="undefined")){
		window.alert('compilare il campo email');
		document.modulo.email.focus();
		return false;
	}
	if((passwordNuova=="")||(passwordNuova=="undefined")){
		window.alert('compilare il campo Nuova password');
		document.modulo.passwordNuova.focus();
		return false;
	}
	if((confermaPassword=="")||(confermaPassword=="undefined")){
		window.alert('compilare il campo conferma password');
		document.modulo.confermaPassword.focus();
		return false;
	}
	if(passwordNuova!=confermaPassword){
		alert("La password confermata è diversa da quella scelta, controllare.");
		   document.modulo.confermaPassword.value = "";
		   document.modulo.confermaPassword.focus();
		   return false;
	}
	else{
		// 1. impedire al form HTML di fare submit
		e.preventDefault();
		var utente={
				email: emailUtente,
				password: passwordNuova
				
		}
		$.ajax({
			url: 'RecuperaPassword',
			method: 'post',
			data: utente
		})
		.done(function(esito){
			console.log(esito);
			if(esito.success) {
				window.alert("Il cambio password è fallito!");
			}
			
			else
			
			localStorage.setItem('utente', JSON.stringify(esito.oggettoRisultante));
			window.alert("Cambio effettuato con successo");
			location.href ='Login.html';
			localStorage.clear();
		})
		.fail(function() {
			window.alert("qualcosa è andato storto.");
			console.error('qualcosa è andato storto.')
		});
		
		}

})