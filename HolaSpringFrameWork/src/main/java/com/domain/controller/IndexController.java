package com.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
