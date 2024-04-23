const ajaxBody = document.getElementById('ajax');
ajaxBody.style.backgroundColor = '#414141';

function guardarEdicion() {
	let unLegajo = document.getElementById('legajoAlta').value;
	let unNombre = document.getElementById('nombre').value;
	let unaEdad = document.getElementById('edad').value;

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			switch (xhr.status) {
				case 200:
					let tablaAlumnos = document.getElementById('tablaAlumnos');
					let fila = tablaAlumnos.insertRow(-1);
					let celdaLegajo = fila.insertCell(0);
					let celdaNombre = fila.insertCell(1);
					let celdaEdad = fila.insertCell(2);

					celdaLegajo.innerHTML = unLegajo;
					celdaNombre.innerHTML = unNombre;
					celdaEdad.innerHTML = unaEdad;

					// Limpiar campos de entrada
					document.getElementById('legajoAlta').value = '';
					document.getElementById('nombre').value = '';
					document.getElementById('edad').value = '';

					break;
				case 500:
					alert("Se produjo un Error");
					break;
				default:
					console.log("El servlet devolvió un Error");
			}
		}
	};

	xhr.open("POST", "GuardarAlumnoServlet");
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("legajo=" + unLegajo + "&" + "nombre=" + unNombre + "&" + "edad=" + unaEdad);
}


function buscarAlumno() {
	let unLegajo = document.getElementById('legajo').value

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			switch (xhr.status) {
				case 200:
					console.log(xhr.responseText);
					console.log(xhr.getAllResponseHeaders);
					let alumno = JSON.parse(xhr.responseText)

					document.getElementById('legajoAlta').value = alumno.Legajo
					document.getElementById('nombre').value = alumno.Nombre
					document.getElementById('edad').value = alumno.Edad

					let tablaAlumnos = document.getElementById('tablaAlumnos')

					tablaAlumnos.innerHTML =
						`
							 <thead>
						        <tr>
						            <th>Legajo</th>
						            <th>Nombre</th>
						            <th>Edad</th>
						        </tr>
						    </thead>
						    <tbody>
						        <tr>
						            <td>${alumno.Legajo}</td>
						            <td>${alumno.Nombre}</td>
						            <td>${alumno.Edad}</td>
						        </tr>
						    </tbody>			
							`
						// Limpiar campos de entrada
						document.getElementById('legajoAlta').value = '';
						document.getElementById('nombre').value = '';
						document.getElementById('edad').value = '';
						
					break;
				case 404:
					console.log("Error 404")
					break;
				case 500:
					console.log("Error 500")
					break;
				default:
					console.log("El servlet alumnos devolvio un Error")

			}
		}
	}
	xhr.open("GET", "BuscarAlumnoServlet?legajo=" + unLegajo, false)

	xhr.send();
}



