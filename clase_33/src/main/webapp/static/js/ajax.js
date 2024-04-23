const ajaxBody = document.getElementById('ajax');
ajaxBody.style.backgroundColor = '#424242';


function guardarEdicion() {
	let unLegajo = document.getElementById('legajoAlta').value
	let unNombre = document.getElementById('nombre').value
	let unaEdad = document.getElementById('edad').value

	let xhr = new XMLHttpRequest();

	xhr.open("POST", "GuardarAlumnoServlet")
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
	xhr.send("legajo=" + unLegajo + "&" + "nombre=" + unNombre + "&" + "edad=" + unaEdad)
	xhr.onreadystatechange = function() {
		switch (xhr.readyState) {
			case 0:
				console.log("UNSET");
				break;
			case 1:
				console.log("OPENED");
				break;
			case 2:
				console.log("HEADERS_RECEIVED");
				break;
			case 3:
				console.log("LOADING");
				break;
			case 4:
				console.log("DONE");
				if (xhr.status == 200) {
					alert("El Alumno fue agregado correctamente")
				} else if (xhr.status == 500) {
					alert("Se produjo un Error")
				}
				break;

			default:
				console.log("Default");
				break;
		}

	}

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



