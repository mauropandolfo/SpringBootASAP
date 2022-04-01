package com.domain.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.asap.practica0.modelo.Lagarto;
import ar.edu.asap.practica0.modelo.Papel;
import ar.edu.asap.practica0.modelo.Piedra;
import ar.edu.asap.practica0.modelo.PiedraPapelTijeraFactory;
import ar.edu.asap.practica0.modelo.Spock;
import ar.edu.asap.practica0.modelo.Tijera;

@Controller
public class IndexController {
	@RequestMapping("/home")
	public String goIndex() {
		return "Index";
	}
	@RequestMapping("/")
	public String goPresentacion() {
		return "Presentacion";
	}
	@RequestMapping("/listado")
	public String goListado(Model model){
		List<String> alumnos = new ArrayList<String>();
		
		alumnos.add("Juan");
		alumnos.add("Pedro");
		alumnos.add("Maria");
		alumnos.add("Susana");
		
		model.addAttribute("titulo", "Listado de alumnos");
		model.addAttribute("profesor", "Gabriel Casas");
		model.addAttribute("alumnos", alumnos);
		
		return "Listado";
		
	}
	@RequestMapping("/juego")
	public String goJuego(Model model) {
		List<PiedraPapelTijeraFactory> opciones = new ArrayList<PiedraPapelTijeraFactory>();
		
		for(int i =1; i < 6 ; i++) {
			opciones.add(PiedraPapelTijeraFactory.getInstance(i));
		}
		model.addAttribute("opciones", opciones);
		return "PiedraPapelTijera";
	}
	@RequestMapping("/resolverJuego")
	public String goResolverJuego(@RequestParam(required = false) Integer selOpcion, Model model) {
		
		PiedraPapelTijeraFactory jugador = PiedraPapelTijeraFactory.getInstance(selOpcion);
		PiedraPapelTijeraFactory computadora = PiedraPapelTijeraFactory.getInstance((int)(Math.random()*5+1));
		int result = jugador.comparar(computadora);
		
		model.addAttribute("numero", selOpcion);
		model.addAttribute("jugador", jugador);
		model.addAttribute("computadora", computadora);
		model.addAttribute("resultado", jugador.getDescripcionResultado());
		
		
		return "Resultado";
	}
}



