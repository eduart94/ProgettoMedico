$('#btnLoginPaziente').click(function(e){
	e.preventDefault();
	doLogin($('#frmLoginPaziente').serialize(), false);
});

$('#btnLoginMedico').click(function(e){
	e.preventDefault();
	doLogin($('#frmLoginMedico').serialize(), true);
});

function doLogin(formData, isMedico) {
	$.ajax({
		url: 'login',
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
			$('#pnlErrLogin').show('fast').delay(2000).hide('fast');
		}
	})
	.fail(function(){
		console.error('qualcosa è andato storto')
	});
}