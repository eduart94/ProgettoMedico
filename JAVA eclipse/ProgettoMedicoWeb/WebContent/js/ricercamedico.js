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
							
							return '<span class="btn btn-primary" onclick="prenota(\'' + row.email + '\')">Prenota</span>';
						}}
					]
		  });
			$('#tuttiDottori').append('<span><h1>La tua ricerca</h1></span><br>')
		});
		
	});
});


function prenota(emailMedico) {
	console.log(emailMedico);
}
