package com.educacionit.desafio_07.desafiojava2;

import com.educacionit.desafio_07.desafiojava2.clases.Avion;
import com.educacionit.desafio_07.desafiojava2.clases.TorreControl;
import com.educacionit.desafio_07.desafiojava2.excepcion.RespuestaInvalidaException;

public class Main {
    public static void main(String[] args) throws RespuestaInvalidaException {
    	
    	System.out.println("Buenos días Operario!! \n");
        TorreControl torreControl = new TorreControl();

        Avion avion1 = new Avion(false, "Aerolineas Latam - LAT409");
        Avion avion2 = new Avion(true, "Aerolineas Argentinas - ARG026");
        Avion avion3 = new Avion(false, "American Airlines - AA402");

        torreControl.agregarAvion(avion1);
        torreControl.agregarAvion(avion2);
        torreControl.agregarAvion(avion3);

        torreControl.gestionarAterrizaje();
    }
}
