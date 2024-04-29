package com.educacionit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ApiTest {
		
	private static final Logger logger = LoggerFactory.getLogger(ApiTest.class);

	@Test
	void testSumaOk() {
		Api api = new Api();		
		Integer resultado = api.suma(1, 1);		
		assertEquals(1+1, resultado);
	}
	
	@Test
	void testSumaPrimerParametroNull() {
		Api api = new Api();		
		Integer resultado = api.suma( null, 1);		
		assertEquals(-1, resultado);
	}
	
	@Test
	void testSumaSegundoParametroNull() {
		Api api = new Api();		
		Integer resultado = api.suma(1, null);
		assertNull(resultado, "El resultado debería ser null");
	}
	

	@Test
	void testContieneOk() {
		Api api = new Api();		
		List<Integer> lista = Arrays.asList(1, 2, 3);		
		Boolean resultado = api.contiene(lista, 2);	
		
		assertNotNull(resultado, "El resultado no debe ser null");
		assertTrue(resultado, "El resultado debería ser TRUE, pero contiene() devolvio un FALSE");
		assertFalse( ! resultado, "El resultado debería ser TRUE, pero contiene() devolvio un FALSE");
	}

	@Test
	void testContieneNoContiene() {
		Api api = new Api();		
		List<Integer> lista = Arrays.asList(1, 2, 3);		
		Boolean resultado = api.contiene(lista, 1000);	
		
		assertNotNull(resultado, "El resultado no debe ser null");
		assertFalse( resultado, "El resultado debería ser TRUE, pero contiene() devolvio un FALSE");
	}
	
	@Test
	void testContieneConListaVacia() {
		Api api = new Api();		
		Boolean resultado = api.contiene(null, 1);	
		
		assertNull(resultado, "El resultado debería haber sido NULL");
	}
	
	@Test
	void testConcatOk() {
		Api api = new Api();		
		String resultado = api.concat("Hola", " Mundo");
		
		assertNotNull(resultado);
		assertEquals("Hola Mundo", resultado);
		
		//fail("Not yet implemented");
	}
	
	@Test
	void testConcatSegundoParamtroNull() {
		Api api = new Api();
		
		try {
			String resultado = api.concat("Hola", null);
			fail("El metodo concat con el segundo prametro en null debería lanzar una Exception");
			
		} catch(Exception ex) {
			logger.info("El metodo concat anduvo perfecto!!!. Devolvio la Exception {}", ex.getMessage());
		}
	}
	
	@Test
	void agregarElementoTestOk() {
		Api api = new Api();		
		List<Integer> lista = new ArrayList<>();
		Integer elemento = 1;
		
		List<Integer> resultado = api.agregarElemento(lista, elemento);
		
		assertNotNull(resultado);
		assertEquals(1, resultado.size());
	}

}
