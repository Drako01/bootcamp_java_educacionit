/**
 * Promesas
 */

const miPromesa = new Promise((resolve, reject) => {
	let exito = true

	if (exito) {
		resolve("La Operacion fue exitosa")
	} else {
		reject("La Operacion fue rechazada")
	}
})

miPromesa
	.then((resolve) => {
		console.log(resolve)
	})
	.catch((error) => {
		console.error(error)
	})


/*
	Ejemplo
*/

const url = "AlumnoManagerServlet";

const consultarAlumno = async () => {
	const miLegajo = document.getElementById('inputLegajo').value;
	const response = await fetch(`${url}?legajo=${miLegajo}`)
	const data = await response.json()
	document.getElementById('resultadoConsulta').innerHTML = `Legajo: ${data.legajo} - 
				Nombre: ${data.nombre} - Edad: ${data.edad} `

}