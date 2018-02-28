$(function () {
    $( '#table' ).searchable({
        striped: true,
        oddRow: { 'background-color': '#f5f5f5' },
        evenRow: { 'background-color': '#fff' },
        searchType: 'fuzzy'
    });
    
    $('#search').keyup(function() {
    	if ($('#search').val() == '')
    		$('#table').hide();
    	else
    		$('#table').show();
    });
    
});