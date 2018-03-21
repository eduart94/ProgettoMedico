$('#salvaPasswordMedico').click(function(e){
	var email= document.getElementById('emMedico').value;
	var passwordNuova = document.getElementById('recPassMedico').value;
	var confermaPassword = document.getElementById('recConfPassMed').value;
	
	if((email=="")||(email=="undefined")){
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
		$.ajax({
			url: 'ModificaDatiMedico',
			method: 'post',
			data: $('#modalContentId').serialize()
		})
		.done(function(esito){
			console.log(esito);
			if(esito.success) {
				localStorage.setItem('soggetto', JSON.stringify(esito.oggettoRisultante));
				window.alert("Password cambiata correttamente");
				location.href ='Login.html';
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

})