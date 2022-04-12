package es.edu.alter.practica0.modelo.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.edu.alter.practica0.modelo.Autoria;
import es.edu.alter.practica0.modelo.Jugada;
import es.edu.alter.practica0.modelo.Jugador;
import es.edu.alter.practica0.modelo.spring.test.*;
class JugadorTest {
  
	ClassPathXmlApplicationContext context = null, context2 = null, context3 = null;
	Jugador jug1 = null; 
	Jugador jug2= null;
	Jugada jugada = null;
	Autoria auditoria = null;
	
	@BeforeEach
	void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("META-INF/juego/Jugador.xml");
		context2 = new ClassPathXmlApplicationContext("META-INF/juego/Jugador2.xml");
		context3 = new ClassPathXmlApplicationContext("META-INF/juego/Jugada.xml");
		
		jug1 = context.getBean(Jugador.class);
		jug2 = context2.getBean(Jugador.class);
		jugada = context3.getBean(Jugada.class);
		auditoria = context3.getBean(Autoria.class);
	}

	@AfterEach
	void tearDown() throws Exception {
		context = null;
		
		jug1 = null;
		jug2 = null;
		
		context2= null;
		context3= null;
		auditoria= null;
		jugada = null;
	}

	@Test
	void testGetBeanAttributes() {
		assertEquals(1, jug1.getCodigo());
		assertEquals("Gabriel", jug1.getNombre());
		assertEquals("papacho", jug1.getNickname());
		assertEquals("piedra", jug1.getJugadaElegida().getNombre());
	}
	
	@Test
	void testGetBeanAttributes2() {
		assertEquals(2, jug2.getCodigo());
		assertEquals("Maria", jug2.getNombre());
		assertEquals("mamasa", jug2.getNickname());
		assertEquals("spock", jug2.getJugadaElegida().getNombre());
	}
	
	@Test
	void testAuditoriaGetCantidad() {
		jugada.getDescripcionDelResultado();
		jugada.getDescripcionDelResultado();
		jugada.getDescripcionDelResultado();
		assertEquals(0, auditoria.getCantidadJugadas());
	}

}

