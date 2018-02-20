$.ajax({
	url: 'elencoSpecialisti',
	method: 'get'
})
.done(function(specialisti){
	$('#tbldottori').DataTable({
		data: specialisti,
		columns: [
			{title: "nome", data: 'nomeMedico'},
			{title: "cognome", data: 'cognomeMedico'},
			{title: "tipologia", data: 'tipologia'},
			{title: "email", data: 'emailMedico'},
			
			]
	});
});