package com.proyecto.prueba.Services;

import java.util.List;
import java.util.Optional;

import com.proyecto.prueba.dto.Prueba;

public interface PruebaService {
	
	//Obtiene todos los objetos "pruebas" de la lista "Prueba"
	List<Prueba> getAllPruebas();
	
	//Obtiene un objeto "prueba" de la lista "Prueba" mediante el id  y comprueba si está o no en "Prueba"
	Optional<Prueba> getPruebasById(Long id);
	
	//Crea un objeto "prueba" tipo clase "Prueba" y comprueba si está o no en "Prueba"
	Optional<Prueba> createPruebas(Prueba prueba);
	
	//Actualiza el objeto "prueba" del tipo clase "Prueba" mediante su id
	Prueba updatePrueba(Long id, Prueba prueba);
	
	//No devuelve un resultado de la función, elimina el objeto "prueba" mediante un id
	void deletePruebaById(Long id);
	
}
