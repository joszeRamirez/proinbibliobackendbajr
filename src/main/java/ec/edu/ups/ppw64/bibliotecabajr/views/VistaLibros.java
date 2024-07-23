package ec.edu.ups.ppw64.bibliotecabajr.views;

import java.util.List;

import ec.edu.ups.ppw64.bibliotecabajr.busines.GestionLibros;
import ec.edu.ups.ppw64.bibliotecabajr.model.Libro;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("libros")
@RequestScoped
public class VistaLibros {
	@Inject
	private GestionLibros gLibros;

	private Libro libro = new Libro();

	private List<Libro> listado;

	@PostConstruct
	public void init() {
		listado = gLibros.getLibros();
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public List<Libro> getListado() {
		return listado;
	}

	public void setListado(List<Libro> listado) {
		this.listado = listado;
	}

	public String guardar() {
		System.out.println(this.libro);
		try {
			gLibros.guardarLibro(libro);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}
}
