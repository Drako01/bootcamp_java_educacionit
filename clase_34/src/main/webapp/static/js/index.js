
let imagenes = [
	"bienvenido.png",
	"bienvenido1.png",
	"bienvenido2.png",
	"bienvenido3.png",
	"bienvenido4.png"
];

let imgBienvenida = document.querySelector('.producto');
let currentIndex = 0;

imgBienvenida.addEventListener('click', () => {
	currentIndex = (currentIndex + 1) % imagenes.length;
	imgBienvenida.src = 'static/img/' + imagenes[currentIndex];
});

