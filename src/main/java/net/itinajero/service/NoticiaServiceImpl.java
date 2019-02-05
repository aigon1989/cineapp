package net.itinajero.service;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;

@Service
public class NoticiaServiceImpl implements INoticiaService {

	@Override
	public void guardar(Noticia noticia) {
		System.out.println(noticia);

	}

}
