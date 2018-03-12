var soggetto = localStorage.getItem('soggetto');
var passwordAttuale= soggetto.password;
var passwordNuova = document.getElementById('passwordNuova').value;
var confermaPassword = document.getElementById('passwordNuovaConf').value;

if(passwordAttuale=="" || passwordAttuale=="undefined"){
	window.alert('Scrivere la password')
}
if(soggetto){
	soggetto = JSON.parse(soggetto);
	
}