package com.comit.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/info", method = RequestMethod.GET)

public class InfoControlador {
	@RequestMapping (value = "/quienesSomos", method = RequestMethod.GET)
public String quienesSomos() {
return "quienesSomos";
}
	@GetMapping("/proveedores")
	public String proveedores() {
		return "proveedores";
	}
}