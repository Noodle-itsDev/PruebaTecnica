package com.proyecto.prueba.Services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.prueba.dao.PruebaRepository;
import com.proyecto.prueba.dto.Prueba;


@Service
public class PruebaServiceImpl implements PruebaService{
	
	@Autowired
	public PruebaRepository pruebaRepository;
	Logger logger = LoggerFactory.getLogger(PruebaServiceImpl.class);
	
	
	@Override
	public List<Prueba> getAllPruebas() {
		
		List<Prueba> prueba = pruebaRepository.findAll();
		
		return prueba;
	}

	@Override
	public Optional<Prueba> getPruebasById(Long id) {
		
		Optional<Prueba> prueba = pruebaRepository.findById(id);
		
		if(prueba.isPresent()) {
			
			logger.info("Artículo con " + id + " encontrado.");
			return prueba;
			
		} else {
			
			logger.error("Artículo con " + id + " no encontrado");
			throw new NoSuchElementException("Artículo incorrecto.");
		}

	}

	@Override
	public Optional<Prueba> createPruebas(Prueba prueba) {
		
		Optional<Prueba> optPrueba = Optional.of(prueba);
		
		if(optPrueba.isPresent()) {
			
			pruebaRepository.save(prueba);
			logger.info("Artículo con creado con éxito.");
			return optPrueba;
			
		}else {
			
			logger.error("No se pudo crear el artículo");
			throw new NoSuchElementException("No se pudo crear el artículo.");
		}

	}

	@Override
	public Prueba updatePrueba(Long id, Prueba prueba) {
		
		Optional<Prueba> optPrueba = pruebaRepository.findById(id);
		
		if(optPrueba.isPresent()) {
			
			Prueba pruebaUpd = optPrueba.get();
			pruebaUpd.setTitular(prueba.getTitular());
			pruebaUpd.setContenido(prueba.getContenido());
			pruebaRepository.save(pruebaUpd);
			logger.info("Artículo modificado correctamente.");
			return pruebaUpd;
			
		} else {
			
			logger.error("Artículo a modificar no .");
			throw new NoSuchElementException("Artículo a modificar no encontrado.");
		}

	}

	@Override
	public void deletePruebaById(Long id) {
		
		Optional<Prueba> deletePrueba = pruebaRepository.findById(id);
		
		if(deletePrueba.isPresent()) {
			Prueba optPrueba = deletePrueba.get();
			pruebaRepository.deleteById(optPrueba.getId());
			logger.info("Artículo con id " + id + " eliminado de forma satisfactoria.");
		} else {
			logger.error("Artículo a eliminar no extistente.");
		}
	}
	
}
