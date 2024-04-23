/**
 * 
 */


let botonCompra = document.getElementById('comprar-btn');
let carrito = document.querySelector('.cart-li');
let cart = document.querySelector('.cart-ico');
let count = localStorage.getItem('cartCount') || 0;


function actualizarCarrito() {
	carrito.innerHTML = `<p>${count}</p>`;
}



botonCompra.addEventListener('click', () => {
	count++;
	localStorage.setItem('cartCount', count);
	actualizarCarrito();
});

cart.addEventListener('click', (e) => {
	e.preventDefault();
	localStorage.removeItem('cartCount');
	count = 0;
	actualizarCarrito();
});

actualizarCarrito(); 