document.addEventListener('DOMContentLoaded', function() {
	let hora = document.getElementById('hora');

	let horario = new Date();

	let anio = horario.getFullYear();

	hora.innerHTML = anio;

	let botonCompra = document.getElementById('comprar-btn');
	let carrito = document.querySelector('.cart-li');
	let cart = document.querySelector('.cart-ico');
	let count = localStorage.getItem('cartCount') || 0;

	botonCompra.addEventListener('click', () => {
		count++;
		localStorage.setItem('cartCount', count);
		carrito.innerHTML = `<p>${count}</p>`;
	});

	cart.addEventListener('click', (e) => {
		e.preventDefault();
		localStorage.removeItem('cartCount');
		carrito.innerHTML = `<p>0</p>`;
	});

	carrito.innerHTML = `<p>${count}</p>`;

});

let imagenes = [
	"bienvenido.png",
	"bienvenido1.png",
	"bienvenido2.png",
	"bienvenido3.png",
	"bienvenido4.png"
]

document.addEventListener('DOMContentLoaded', function() {

	let imgBienvenida = document.querySelector('.producto');
	let currentIndex = 0;

	imgBienvenida.addEventListener('click', () => {
		currentIndex = (currentIndex + 1) % imagenes.length;
		imgBienvenida.src = 'static/img/' + imagenes[currentIndex];
	});
});



let validar = document.getElementById('validar-btn');
let validado = document.getElementById('validado');

validar.addEventListener('click', (e) => {
    e.preventDefault(); 
    let nombre = document.getElementById('nombre').value;
    let email = document.getElementById('email').value;
    validado.innerHTML = `El Usuario ingresado se llama ${nombre} y su Email es ${email}`;
});




