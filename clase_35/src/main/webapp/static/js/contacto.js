/**
 * 
 */

let validar = document.getElementById('validar-btn');
let validado = document.getElementById('validado');

validar.addEventListener('click', (e) => {
	e.preventDefault();
	let nombre = document.getElementById('nombre').value;
	let email = document.getElementById('email').value;
	if (nombre != "" && email != "") {
		validado.innerHTML = `El Usuario ingresado se llama ${nombre} y su Email es ${email}`;
	} else {
		validado.innerHTML = `Debe completar todos los Campos del Formulario!`;
	}
});