package ec.edu.ups.ppw64.bibliotecabajr.dao;

import java.util.List;

import ec.edu.ups.ppw64.bibliotecabajr.model.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class LibroDAO {
	@PersistenceContext
	private EntityManager es;

	public void insert(Libro libro) {
		es.persist(libro);
	}

	public void update(Libro libro) {
		es.merge(libro);
	}

	public void delete(int codigo) {
		Libro libro = es.find(Libro.class, codigo);
		es.remove(libro);
	}

	public Libro read(int codigo) {
		Libro libro = es.find(Libro.class, codigo);
		return libro;
	}

	@SuppressWarnings("unchecked")
	public List<Libro> getAll() {
		String jpql = "SELECT l FROM Libro l";
		Query q = es.createQuery(jpql, Libro.class);
		return q.getResultList();
	}
}
