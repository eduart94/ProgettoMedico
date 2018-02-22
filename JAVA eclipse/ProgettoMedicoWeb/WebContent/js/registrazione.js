$('#btnRegistrazionePaziente').click(function(e){
	e.preventDefault();
	doRegistrazione($('#frmRegistrazionePaziente').serialize(), false);
});

$('#btnRegistrazioneMedico').click(function(e){
	e.preventDefault();
	doRegistrazione($('#frmRegistrazioneMedico').serialize(), true);
});

function doRegistrazione(formData, isMedico) {
	$.ajax({
		url: 'registrazione',
		method: 'post',
		data: formData
	})
	.done(function(esito){
		console.log(esito);
		if(esito.success){
			localStorage.setItem('utente', JSON.stringify(esito.oggettoRisultante));
			if (isMedico) {
				location.href= 'profilepage.html';
			} else {
				location.href= 'profilepage.html';
			}
		}else{
			$('#pnlErrRegistrazione').show('fast').delay(2000).hide('fast');
		}
	})
	.fail(function(){
		console.error('qualcosa è andato storto')
	});
}