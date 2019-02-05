package net.itinajero.service;

import java.util.List;

import net.itinajero.app.model.Pelicula;

public interface IPeliculasService {

	public List<Pelicula> buscarTodas();
	
	public Pelicula buscarPorId(int id);
	
}
