package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Noticia;
import net.itinajero.service.INoticiaService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	@Autowired
	private INoticiaService noticiaService;
	
	@GetMapping(value="/create")
	public String crear() {
		return "noticias/formNoticia";
	}
	
	@PostMapping(value="/save")
	public String guardar(@RequestParam(value="titulo") String titulo, @RequestParam(value="estatus") String estatus, @RequestParam(value="detalle") String detalle) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo(titulo);
		noticia.setEstatus(estatus);
		noticia.setDetalle(detalle);
		
		//TODO: Guardar en Base de datos
		
		this.noticiaService.guardar(noticia);
		
		return "noticias/formNoticia";
	}
}
