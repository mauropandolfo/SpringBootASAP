package es.edu.alter.practica0.modelo.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.asap.practica0.modelo.Jugada;
import ar.edu.asap.practica0.modelo.Jugador;
import ar.edu.asap.practica0.modelo.Papel;
import ar.edu.asap.practica0.modelo.Piedra;

class JugadaTest {
     Jugada jugada = null;
     
     @BeforeEach
     void setUp() throws Exception {
    	 Jugador jug1 = new Jugador(1, "Mauro", "pandolfo", new Piedra());
    	 Jugador jug2 = new Jugador(2, "Dario", "pandolfo", new Papel());
    	 jugada = new Jugada(1, new Date(), jug1,jug2);
     }
     
     @AfterEach
     void tearDown() throws Exception {
    	 jugada = null;
     }
     
	@Test
	void testGetDescripcionResultado() {
		assertEquals("piedra pierde con papel", jugada.getDescripcionDelresultado());
	}

}
