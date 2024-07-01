package com.proyecto.prueba.dto;	

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "articulos")
public class Prueba {
	
	
	/*Atributos*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titular")
	private String titular;
	
	@Column(name = "contenido")
	private String contenido;
	
	
	
	/*Constructores*/
	
	public Prueba() {
	}
	
	
	public Prueba(Long id, String titular, String contenido) {
		
		this.id = id;
		this.titular = titular;
		this.contenido = contenido;
		
	}

	/*Getters*/
	
	public Long getId() {
		return id;
	}
	
	public String getTitular() {
		return titular;
	}

	public String getContenido() {
		return contenido;
	}
	
	
	/*Setters*/
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	
	/*ToString*/
	
	@Override
	public String toString() {
		return "Prueba [id=" + id + ", titular=" + titular + ", contenido=" + contenido + "]";
	}


	
	
}	
