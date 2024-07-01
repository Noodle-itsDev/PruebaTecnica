package com.proyecto.prueba.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.prueba.Services.PruebaServiceImpl;
import com.proyecto.prueba.dto.Prueba;


@RestController
@RequestMapping("/api/articulo")
@CrossOrigin(origins = "*")

public class PruebaController {
	
	@Autowired
	public PruebaServiceImpl pruebaServiceImpl;
	
	
	@GetMapping("/all")
	public List<Prueba> getAllPruebas(){
		return pruebaServiceImpl.getAllPruebas();
	}
	
	
	@GetMapping("/{id}")
	public Prueba getPruebaById(@PathVariable(name = "id") Long id) {
		
		Optional<Prueba> prueba = pruebaServiceImpl.getPruebasById(id);
		
		if(prueba.isPresent()) {
			return prueba.get();
		} else {
			throw new NoSuchElementException();
		}
		
	}
	
	
	@GetMapping("/create")
	public Optional<Prueba> createPrueba(@RequestBody Prueba prueba){
		Optional<Prueba> newPrueba = pruebaServiceImpl.createPruebas(prueba);
		if(newPrueba.isPresent()) {
			return newPrueba;
		} else {
		
			throw new NoSuchElementException();
		}

	}
	
	
	@PutMapping("/update/{id}")
	public Prueba updatePruebas(@PathVariable(name="id")Long id, @RequestBody Prueba prueba) {
		Prueba updatePrueba = pruebaServiceImpl.updatePrueba(id, prueba);
		return updatePrueba;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deletePrueba(@PathVariable(name="id") Long id) {
		pruebaServiceImpl.deletePruebaById(id);
	}
	
	
}
