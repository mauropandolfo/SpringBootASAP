package ar.edu.asap.practica0.modelo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.asap.practica0.modelo.Papel;
import ar.edu.asap.practica0.modelo.Piedra;
import ar.edu.asap.practica0.modelo.PiedraPapelTijeraFactory;
import ar.edu.asap.practica0.modelo.Tijera;

class PiedraPapelTijeraFactoryTest {
	//lote de pruebas
	Piedra piedra;
	Papel papel;
	Tijera tijera;
	
	
	@BeforeEach
	void setUp() throws Exception {
		//antes de cada test
		piedra = new Piedra();
		papel = new Papel();
		tijera = new Tijera();
	}

	@AfterEach
	void tearDown() throws Exception {
		//despues de cada test
		piedra = null;
		papel = null;
		tijera = null;
	}
	//test piedra
	@Test 
	void testPiedraGanaATijera_comparar(){
		assertEquals(1, piedra.comparar(tijera));
	}
	@Test
	void testPiedraPierdeConPapel_comparar() {
		assertEquals(-1, piedra.comparar(papel));
	}
	@Test
	void testPiedraEmpataConPiedra_comparar() {
		assertEquals(0, piedra.comparar(new Piedra()));
	}
	@Test
	void testPiedraGanaATijera_comparar_DescripcionResultad(){
		int result = piedra.comparar(tijera);
		assertEquals("piedra le gana a tijera", piedra.getDescripcionResultado());
	}
	void testPiedraPierdeConPapel_comparar_DescripcionResultad(){
		int result = piedra.comparar(papel);
		assertEquals("piedra pierde con tijera", piedra.getDescripcionResultado());
	}
	void testPiedraEmpataConTijera_comparar_DescripcionResultad(){
		int result = piedra.comparar(piedra);
		assertEquals("piedra empata con tijera", piedra.getDescripcionResultado());
	}
	//test papel
	@Test 
	void testPapelGanaAPiedra_comparar(){
		assertEquals(1, papel.comparar(piedra));
	}
	@Test
	void testPapelPierdeConTijera_comparar() {
		assertEquals(-1, papel.comparar(tijera));
	}
	@Test
	void testPapelEmpataConPapel_comparar() {
		assertEquals(0, papel.comparar(new Papel()));
	}
	@Test
	void testPapelGanaAPiedra_comparar_DescripcionResultad(){
		int result = papel.comparar(piedra);
		assertEquals("papel le gana a piedra", papel.getDescripcionResultado());
	}
	
	//test tijera
	@Test 
	void testTijeraGanaAPapel_comparar(){
		assertEquals(1, tijera.comparar(papel));
	}
	@Test
	void testTijeraPierdeConPiedra_comparar() {
		assertEquals(-1, tijera.comparar(piedra));
	}
	@Test
	void testTijeraEmpataConTijera_comparar() {
		assertEquals(0, tijera.comparar(new Tijera()));
	}
	@Test
	void testTijeraGanaAPapel_comparar_DescripcionResultad(){
		int result = tijera.comparar(papel);
		assertEquals("tijera le gana a papel", tijera.getDescripcionResultado());
	}

	@Test
	void testGetInstance() {
		assertEquals("piedra", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.PIEDRA)
							.getNombre());
	}

}
