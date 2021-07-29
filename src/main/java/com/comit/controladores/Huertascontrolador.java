package com.comit.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;


import com.comit.modelo.Huerta;
import com.comit.repositorios.HuertasRepositorio;


@Controller
@RequestMapping ("/huertas")
public class Huertascontrolador {
@Autowired	
 private HuertasRepositorio huertasRepositorio;

	@GetMapping
	public String listarClientes(Model model) { 
		 model.addAttribute("huertas", huertasRepositorio.findByBorrado(false));
		 model.addAttribute("huertasBorradas", huertasRepositorio.findByBorrado(true));
		 return "listadoHuertas";	 
	 }
	
	@GetMapping("/nueva")
	public String nuevaHuerta(Model model) {
		model.addAttribute("huerta", new Huerta());
		return "nuevaHuerta";
	}

	@GetMapping(path = "/{id}")
	public String editarHuerta(@PathVariable(name = "id", required = true) Long id, Model model) {
		Optional<Huerta> huertaOp = huertasRepositorio.findById(id);
		if (!huertaOp.isPresent())
			return "redirect:/error";
		
		model.addAttribute("huerta", huertaOp.get());
		return "editarHuerta";
	}

	
	@PostMapping("/{id}")
	public String actualizarHuerta(@PathVariable(name = "id", required = true) Long id, @ModelAttribute(name = "huerta") Huerta huerta) {
		Optional<Huerta> huertaOp = huertasRepositorio.findById(id);
		if (!huertaOp.isPresent() || huerta == null)
			return "redirect:/error";
		
		Huerta huertaRepo = huertaOp.get();
		
		huertaRepo.setContacto(huerta.getContacto());
		huertaRepo.setDireccion(huerta.getDireccion());
		huertaRepo.setNombre(huerta.getNombre());
		
		huertasRepositorio.save(huertaRepo);
		return "redirect:/huertas";
	}
	
	
	@PostMapping("/crear")
	public String crearHuerta(@ModelAttribute(name = "huerta") Huerta huerta) {
		huerta = huertasRepositorio.save(huerta);
		return "redirect:/huertas";
	}

	
	@PostMapping(path = "/{id}/borrar")
	public String deleteHuerta(@PathVariable(name = "id", required = true) Long id) {
		Optional<Huerta> huertaOp = huertasRepositorio.findById(id);
		if (!huertaOp.isPresent())
			return "redirect:/error";
		
		Huerta huerta = huertaOp.get();
		huerta.setBorrado(true);
		huertasRepositorio.save(huerta);
		return "redirect:/huertas";
	}

	
	@GetMapping(path = "/{id}/mostrar")
	public String mostrarHuerta(@PathVariable(name = "id", required = true) Long id) {
		Optional<Huerta> huertaOp = huertasRepositorio.findById(id);
		if (!huertaOp.isPresent())
			return "redirect:/error";
		
		Huerta huerta = huertaOp.get();
		huerta.setBorrado(false);
		huertasRepositorio.save(huerta);
		return "redirect:/huertas";
	}
}
