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
		url: (isMedico ? 'loginMedico' : 'login'),
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
			$('#pnlErrLogin').show('fast').delay(2000).hide('fast');
		}
	})
	.fail(function(){
		console.error('qualcosa è andato storto')
	});
}