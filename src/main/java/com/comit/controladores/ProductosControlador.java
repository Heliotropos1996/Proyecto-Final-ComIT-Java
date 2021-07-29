package com.comit.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/productos")
public class ProductosControlador {

	@RequestMapping (value = "/comprar", method = RequestMethod.GET)
	
	public String comprarProducto() {
	return "comprarProducto";

}
}