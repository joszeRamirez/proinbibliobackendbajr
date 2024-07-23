package ec.edu.ups.ppw64.bibliotecabajr.busines;

import java.util.List;

import ec.edu.ups.ppw64.bibliotecabajr.dao.LibroDAO;
import ec.edu.ups.ppw64.bibliotecabajr.model.Libro;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionLibros {
	@Inject
	private LibroDAO daoLibro;

	public void guardarLibro(Libro libro) {
		Libro cli = daoLibro.read(libro.getCodigo());
		if (cli != null) {
			daoLibro.update(libro);
		} else {
			daoLibro.insert(libro);
		}
	}

	public void actualizarLibro(Libro libro) throws Exception {
		Libro cli = daoLibro.read(libro.getCodigo());
		if (cli != null) {
			daoLibro.update(libro);
		} else {
			throw new Exception("Libro no existe");
		}
	}

	public void borrarLibro(int codigo) {
		daoLibro.delete(codigo);
	}

	public Libro getLibro(int codigo) {
		Libro libro = daoLibro.read(codigo);
		return libro;
	}

	public List<Libro> getLibros() {
		return daoLibro.getAll();
	}
}
