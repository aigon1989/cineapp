package net.itinajero.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;

@Service
public class PeliculasServiceImpl implements IPeliculasService {

	private List<Pelicula> lista  = null;
	
	public PeliculasServiceImpl() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		try {

			lista = new LinkedList<Pelicula>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Terminator");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Acción");
			pelicula1.setFechaEstreno(formatter.parse("22-01-2019"));
			pelicula1.setImagen("terminator.jpg");
			pelicula1.setEstatus("Activa");

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Batman");
			pelicula2.setDuracion(130);
			pelicula2.setClasificacion("C");
			pelicula2.setGenero("Superheroes");
			pelicula2.setFechaEstreno(formatter.parse("23-01-2019"));
			pelicula2.setImagen("batman.jpg");
			pelicula2.setEstatus("Activa");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Ghost");
			pelicula3.setDuracion(140);
			pelicula3.setClasificacion("D");
			pelicula3.setGenero("Romantica");
			pelicula3.setFechaEstreno(formatter.parse("24-01-2019"));
			pelicula3.setImagen("ghost.jpg");
			pelicula3.setEstatus("Activa");

			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Robocop");
			pelicula4.setDuracion(150);
			pelicula4.setClasificacion("E");
			pelicula4.setGenero("Acción Ciencia Ficcion");
			pelicula4.setFechaEstreno(formatter.parse("25-01-2019"));
			pelicula4.setImagen("robocop.jpg");
			pelicula4.setEstatus("Inactiva");

			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: Vida Inteligente");
			pelicula5.setDuracion(150);
			pelicula5.setClasificacion("E");
			pelicula5.setGenero("Acción Ciencia Ficcion");
			pelicula5.setFechaEstreno(formatter.parse("25-01-2019"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Inactiva");

			this.lista.add(pelicula1);
			this.lista.add(pelicula2);
			this.lista.add(pelicula3);
			this.lista.add(pelicula4);
			this.lista.add(pelicula5);

		} catch (ParseException e) {
			System.out.println("Error:" + e.getMessage());
		}

	}

	@Override
	public List<Pelicula> buscarTodas() {
		// TODO Auto-generated method stub
		return this.lista;
	}

	@Override
	public Pelicula buscarPorId(int id) {
		return this.lista.stream().filter( pelicula -> pelicula.getId() == id).findAny().orElse(null);
	}

}
