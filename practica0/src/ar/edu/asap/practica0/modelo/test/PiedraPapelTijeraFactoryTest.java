package ar.edu.asap.practica0.modelo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.asap.practica0.modelo.Lagarto;
import ar.edu.asap.practica0.modelo.Papel;
import ar.edu.asap.practica0.modelo.Piedra;
import ar.edu.asap.practica0.modelo.PiedraPapelTijeraFactory;
import ar.edu.asap.practica0.modelo.Spock;
import ar.edu.asap.practica0.modelo.Tijera;

class PiedraPapelTijeraFactoryTest {
	//lote de pruebas
	Piedra piedra;
	Papel papel;
	Tijera tijera;
	Lagarto lagarto;
	Spock spock;
	
	
	@BeforeEach
	void setUp() throws Exception {
		//antes de cada test
		piedra = new Piedra();
		papel = new Papel();
		tijera = new Tijera();
		lagarto = new Lagarto();
		spock = new Spock();
	}

	@AfterEach
	void tearDown() throws Exception {
		//despues de cada test
		piedra = null;
		papel = null;
		tijera = null;
		lagarto = null;
		spock = null;
	}
	
	//test piedra
	@Test 
	void testPiedraGanaATijera_comparar(){
		assertEquals(1, piedra.comparar(tijera));
	}
	@Test 
	void testPiedraGanaALagarto_comparar(){
		assertEquals(1, piedra.comparar(lagarto));
	}
	@Test
	void testPiedraPierdeConPapel_comparar() {
		assertEquals(-1, piedra.comparar(papel));
	}
	@Test
	void testPiedraPierdeConSpock_comparar() {
		assertEquals(-1, piedra.comparar(spock));
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
	void testPiedraGanaALagarto_comparar_DescripcionResultad(){
		int result = piedra.comparar(lagarto);
		assertEquals("piedra le gana a lagarto", piedra.getDescripcionResultado());
	}
	void testPiedraPierdeConPapel_comparar_DescripcionResultad(){
		int result = piedra.comparar(papel);
		assertEquals("piedra pierde con tijera", piedra.getDescripcionResultado());
	}
	void testPiedraPierdeConSpock_comparar_DescripcionResultad(){
		int result = piedra.comparar(spock);
		assertEquals("piedra pierde con spock", piedra.getDescripcionResultado());
	}
	void testPiedraEmpataConPiedra_comparar_DescripcionResultad(){
		int result = piedra.comparar(piedra);
		assertEquals("piedra empata con tijera", piedra.getDescripcionResultado());
	}
	//test papel
	@Test 
	void testPapelGanaAPiedra_comparar(){
		assertEquals(1, papel.comparar(piedra));
	}
	void testPapelGanaASpock_comparar(){
		assertEquals(1, papel.comparar(spock));
	}
	@Test
	void testPapelPierdeConTijera_comparar() {
		assertEquals(-1, papel.comparar(tijera));
	}
	@Test
	void testPapelPierdeConLagarto_comparar() {
		assertEquals(-1, papel.comparar(lagarto));
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
	void testPapelGanaASpock_comparar_DescripcionResultad(){
		int result = papel.comparar(spock);
		assertEquals("papel le gana a spock", papel.getDescripcionResultado());
	}
	void testPapelPierdeConTijera_comparar_DescripcionResultad(){
		int result = papel.comparar(tijera);
		assertEquals("papel pierde con tijera", papel.getDescripcionResultado());
	}
	void testPapelPierdeConLagarto_comparar_DescripcionResultad(){
		int result = papel.comparar(lagarto);
		assertEquals("papel pierde con lagarto", papel.getDescripcionResultado());
	}
	void testPiedraEmpataConPapel_comparar_DescripcionResultad(){
		int result = papel.comparar(papel);
		assertEquals("piedra empata con tijera", papel.getDescripcionResultado());
	}
	
	//test tijera
	@Test 
	void testTijeraGanaAPapel_comparar(){
		assertEquals(1, tijera.comparar(papel));
	}
	@Test 
	void testTijeraGanaALagarto_comparar(){
		assertEquals(1, tijera.comparar(lagarto));
	}
	@Test
	void testTijeraPierdeConPiedra_comparar() {
		assertEquals(-1, tijera.comparar(piedra));
	}
	@Test
	void testTijeraPierdeConSpock_comparar() {
		assertEquals(-1, tijera.comparar(spock));
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
	void testTijeraGanaALagarto_comparar_DescripcionResultad(){
		int result = tijera.comparar(lagarto);
		assertEquals("tijera le gana a lagarto", tijera.getDescripcionResultado());
	}
	void testTijeraPierdeConPiedra_comparar_DescripcionResultad(){
		int result = tijera.comparar(piedra);
		assertEquals("tijera pierde con piedra", tijera.getDescripcionResultado());
	}
	void testTijeraPierdeConSpock_comparar_DescripcionResultad(){
		int result = tijera.comparar(spock);
		assertEquals("tijera pierde con spock", tijera.getDescripcionResultado());
	}
	void testTijeraEmpataConTijera_comparar_DescripcionResultad(){
		int result = tijera.comparar(tijera);
		assertEquals("tijera empata con tijera", tijera.getDescripcionResultado());
	}
	
	//test lagarto
	
	@Test 
	void testLagartoGanaAPapel_comparar(){
		assertEquals(1, lagarto.comparar(papel));
	}
	@Test 
	void testLagartoGanaASpock_comparar(){
		assertEquals(1, lagarto.comparar(spock));
	}
	@Test
	void testLagartoPierdeConPiedra_comparar() {
		assertEquals(-1, lagarto.comparar(piedra));
	}
	@Test
	void testLagartoPierdeConTijera_comparar() {
		assertEquals(-1, lagarto.comparar(tijera));
	}
	@Test
	void testLagartoEmpataConLagarto_comparar() {
		assertEquals(0, lagarto.comparar(new Lagarto()));
	}
	@Test
	void testLagartoGanaAPapel_comparar_DescripcionResultad(){
		int result = lagarto.comparar(papel);
		assertEquals("lagarto le gana a papel", lagarto.getDescripcionResultado());
	}
	void testLagartoGanaASpock_comparar_DescripcionResultad(){
		int result = lagarto.comparar(spock);
		assertEquals("lagarto le gana a spock", lagarto.getDescripcionResultado());
	}
	void testLagartoPierdeConPiedra_comparar_DescripcionResultad(){
		int result = lagarto.comparar(piedra);
		assertEquals("lagarto pierde con piedra", lagarto.getDescripcionResultado());
	}
	void testLagartoPierdeConTijera_comparar_DescripcionResultad(){
		int result = lagarto.comparar(tijera);
		assertEquals("lagarto pierde con tijera", lagarto.getDescripcionResultado());
	}
	void testLagartoEmpataConLagarto_comparar_DescripcionResultad(){
		int result = lagarto.comparar(lagarto);
		assertEquals("lagarto empata con lagarto", lagarto.getDescripcionResultado());
	}
	//test spock
	@Test 
	void testSpockGanaATijera_comparar(){
		assertEquals(1, spock.comparar(tijera));
	}
	@Test 
	void testSpockGanaAPiedra_comparar(){
		assertEquals(1, spock.comparar(piedra));
	}
	@Test
	void testSpockPierdeConLagarto_comparar() {
		assertEquals(-1, spock.comparar(lagarto));
	}
	@Test
	void testSpockPierdeConPapel_comparar() {
		assertEquals(-1, spock.comparar(papel));
	}
	@Test
	void testSpockEmpataConSpock_comparar() {
		assertEquals(0, spock.comparar(new Spock()));
	}
	@Test
	void testSpockGanaATijera_comparar_DescripcionResultad(){
		int result = spock.comparar(tijera);
		assertEquals("spock le gana a tijera", spock.getDescripcionResultado());
	}
	void testSpockGanaAPiedra_comparar_DescripcionResultad(){
		int result = spock.comparar(piedra);
		assertEquals("spock le gana a lagrto", spock.getDescripcionResultado());
	}
	void testSpockPierdeConPapel_comparar_DescripcionResultad(){
		int result = spock.comparar(papel);
		assertEquals("spock pierde con papel", spock.getDescripcionResultado());
	}
	void testSpockPierdeConLagarto_comparar_DescripcionResultad(){
		int result = spock.comparar(lagarto);
		assertEquals("spock pierde con lagarto", spock.getDescripcionResultado());
	}
	void testSpockPierdeConSpock_comparar_DescripcionResultad(){
		int result = spock.comparar(spock);
		assertEquals("spock empata con spock", spock.getDescripcionResultado());
	}
	
	

	@Test
	void testGetInstance_piedra() {
		assertEquals("piedra", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.PIEDRA)
							.getNombre());
	}
	@Test
	void testGetInstance_papel() {
		assertEquals("papel", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.PAPEL)
							.getNombre());
	}
	@Test
	void testGetInstance_tijera() {
		assertEquals("tijera", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.TIJERA)
							.getNombre());
	}
	@Test
	void testGetInstance_lagarto() {
		assertEquals("lagarto", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.LAGARTO)
							.getNombre());
	}
	@Test
	void testGetInstance_spock() {
		assertEquals("spock", PiedraPapelTijeraFactory.getInstance(PiedraPapelTijeraFactory.SPOCK)
							.getNombre());
	}

}
