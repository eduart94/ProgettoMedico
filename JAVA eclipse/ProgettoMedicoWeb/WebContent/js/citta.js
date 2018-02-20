
$.ajax({
	url : 'elencoCitta',
	method : 'get'
})  
.done(function (citta){
	$('#tblcitta').DataTable({
		data: citta,
		columns: [
			{ title: "Nome", data: 'nome' },
			{ title: "Paese", data: 'paese' }
		]
	});
});