package cl.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {

	@RequestMapping("/")
	public String getInicio() {
		return "inicio";
	}
	
	@RequestMapping("/orders")
	public String getEmployees() {
		return "orders";
	}
}
