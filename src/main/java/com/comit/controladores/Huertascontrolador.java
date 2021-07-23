package com.comit.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comit.repositorios.HuertasRepositorio;


@Controller
@RequestMapping ("/huertas")
public class Huertascontrolador {
@Autowired	
 private HuertasRepositorio huertasRepositorio;
@GetMapping
public String listarClientes(Model model) { 
	 model.addAttribute("huertas", huertasRepositorio.findAll());
	 return "listadoHuertas";
	 
 }
}
