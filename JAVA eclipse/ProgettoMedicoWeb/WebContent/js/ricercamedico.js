$(function() {
	$('#btnCerca').click(function(){
		$.ajax({
			url: 'elencoSpecialisti?tipologia=' + $('#dlTipologia').val() + '&nomeMedico=' + $('#txtNome').val() + '&citta=' + $('#txtCitta').val() ,
			method: 'get'
		})
		.done(function(specialisti){
			$('#tbldottori').DataTable({
				destroy: true,
				data: specialisti,
				columns: [
					{title: "nome", data: 'nome'},
					{title: "cognome", data: 'cognome'},
					{title: "tipologia", data: 'tipologia'},
					{title: "email", data: 'email'},
					{title: '', 
						render: function(data, type, row) {
							
							return '<span class="btn btn-primary" id="bottonePrenotaMedico" onclick="prenota(\'' + row.email + '\')">Prenota</span>';
						}}
					]
				
			});
		});
		
	});
});

//gestiamo il tasto prenota nella ricerca medico
function prenota(emailMedico) {
	top.location.href = 'index.html';
}




