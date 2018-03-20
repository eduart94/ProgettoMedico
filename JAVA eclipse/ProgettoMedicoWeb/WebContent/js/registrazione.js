$('#btnRegistrazioneMedico').click(function(e){
	$('#frmRegistrazioneMedico').submit(function(e) {
		e.preventDefault();
		if ($('#pwdDoc').val() != $('#pwdConfDoc').val()) {
			$('#lblPwdNoMatch').show('fast').delay(2000).hide('fast');
		} else {
			doRegistrazione($('#frmRegistrazioneMedico').serialize(), true);
		}
	});
});

function doRegistrazione(formData, isMedico) {
	$.ajax({
		url: (isMedico ? 'registrazionemedico' : 'registrazione'),
		method: 'post',
		data: formData
	})
	.done(function(esito){
		console.log(esito);
		if(esito.success){
			
			if (isMedico) {
				alert('registrazione effettuata con successo')
				location.href= 'Login.html';
			} 
		}else{
			$('#pnlErrRegistrazione').show('fast').delay(2000).hide('fast');
		}
	})
	.fail(function(){
		console.error('qualcosa è andato storto')
	});

}

$('#btnRegistrazionePaziente').click(function(e){
	$('#frmRegistrazionePaziente').submit(function(e) {
		e.preventDefault();
		if ($('#pwdPz').val() != $('#pwdConfPz').val()) {
			$('#lblPwdNoMatch').show('fast').delay(2000).hide('fast');
		} else {
			doRegistrazionePz($('#frmRegistrazionePaziente').serialize(), true);
		}
	});
});

function doRegistrazionePz(formData, isPaziente){
$.ajax({
	url: (isPaziente ? 'registrazione' : 'registrazionemedico'),
	method: 'post',
	data: formData
})
.done(function(esito){
		console.log(esito);
		if(esito.success){
			localStorage.setItem('soggetto', JSON.stringify(esito.oggettoRisultante));
			localStorage.setItem('isPaziente', JSON.stringify(isPaziente));
			if (isPaziente) {
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
