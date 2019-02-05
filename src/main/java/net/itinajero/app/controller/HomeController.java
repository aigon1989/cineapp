package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.service.IPeliculasService;
import net.itinajero.utils.Utils;


@Controller
public class HomeController {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private IPeliculasService peliculaService;

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/search" , method=RequestMethod.POST)
	public String Buscar(@RequestParam("fecha") String fecha, Model model) {
		
		System.out.println(fecha);
		
		List<String> listaFechas = Utils.getNextDays(4);
		System.out.println(listaFechas);
		
		model.addAttribute("peliculas", this.peliculaService.buscarTodas());
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("listaFechas", listaFechas);
		
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> listaFechas = Utils.getNextDays(4);
		System.out.println(listaFechas);
		
		model.addAttribute("peliculas", this.peliculaService.buscarTodas());
		model.addAttribute("fechaBusqueda", this.dateFormat.format(new Date()));
		model.addAttribute("listaFechas", listaFechas);
		return "home";
	}
	
	//@RequestMapping(value="/detail/{id}/{fechaBusqueda}", method=RequestMethod.GET)
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	//public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fechaBusqueda") String fechaBusqueda) {
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fechaBusqueda") String fechaBusqueda) {
		
		model.addAttribute("pelicula", this.peliculaService.buscarPorId(idPelicula));
		return "detalle";
	}
}
