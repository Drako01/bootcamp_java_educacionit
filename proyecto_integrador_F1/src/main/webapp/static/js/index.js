/*
	index.js
*/

const empleados = [
	{ id: 1, nombre: 'Martin Gonzalez', sector: 'Administrativo' },
	{ id: 2, nombre: 'Sofia Rodriguez', sector: 'Administrativo' },
	{ id: 3, nombre: 'Juan Perez', sector: 'Administrativo' },
	{ id: 4, nombre: 'Maria Fernandez', sector: 'Administrativo' },
	{ id: 5, nombre: 'Lucas Martinez', sector: 'Administrativo' },
	{ id: 6, nombre: 'Valentina Gomez', sector: 'Administrativo' },
	{ id: 7, nombre: 'Matias Diaz', sector: 'Administrativo' },
	{ id: 8, nombre: 'Camila Lopez', sector: 'Administrativo' },
	{ id: 9, nombre: 'Facundo Sanchez', sector: 'Administrativo' },
	{ id: 10, nombre: 'Julieta Alvarez', sector: 'Administrativo' }	
];


function generarTablaEmpleados() {
	var tablaEmpleados = document.getElementById('tablaEmpleados');


	tablaEmpleados.innerHTML = '';

	
	empleados.forEach(function(empleado) {
		var fila = document.createElement('tr');
		fila.innerHTML = `
                    <td>${empleado.id}</td>
                    <td>${empleado.nombre}</td>
                    <td>${empleado.sector}</td>
                `;
		tablaEmpleados.appendChild(fila);
	});
}

window.onload = function() {
	generarTablaEmpleados();
};