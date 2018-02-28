$('#btnRegistrazionePaziente').click(function(e){
	e.preventDefault();
	doRegistrazione($('#frmRegistrazionePaziente').serialize(), false);
});

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
			localStorage.setItem('soggetto', JSON.stringify(esito.oggettoRisultante));
			localStorage.setItem('isMedico', JSON.stringify(isMedico));
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