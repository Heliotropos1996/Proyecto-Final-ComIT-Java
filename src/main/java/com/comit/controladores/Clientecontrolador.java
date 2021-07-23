package com.comit.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comit.repositorios.VendedorRepositorio;

@Controller
@RequestMapping ("/clientes")
public class Clientecontrolador {
@Autowired	
 private VendedorRepositorio clienteRepositorio;
@GetMapping
public String listarClientes(Model model) { 
	 model.addAttribute("clientes", clienteRepositorio.findAll());
	 return "listadoClientes";
	 
 }
}
