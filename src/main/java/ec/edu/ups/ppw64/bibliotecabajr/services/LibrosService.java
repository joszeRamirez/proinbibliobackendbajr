package ec.edu.ups.ppw64.bibliotecabajr.services;

import java.util.List;

import ec.edu.ups.ppw64.bibliotecabajr.busines.GestionLibros;
import ec.edu.ups.ppw64.bibliotecabajr.model.Libro;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/libros")
public class LibrosService {
	@Inject
	private GestionLibros gLibros;

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Libro libro) {

		try {
			gLibros.guardarLibro(libro);
			return Response.ok(libro).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}

	}

	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Libro libro) {
		try {
			gLibros.actualizarLibro(libro);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
	}

	@DELETE
	@Path("/borra")
	public Response delete(@QueryParam("id") int id) {
		try {
			gLibros.borrarLibro(id);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}

	}

//	@GET
//	@Path("/search")
//	@Produces("application/json")
//	public Libro get(@QueryParam("id") int id) {
//		Libro libro;
//		libro = gLibros.getLibro(id);
//		return libro;
//	}

	@GET
	@Path("/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Libro getone(@PathParam("code") int id) {
		Libro libro;
		libro = gLibros.getLibro(id);
		return libro;
	}

	@GET
	@Produces("application/json")
	public List<Libro> list() {
		List<Libro> libros = gLibros.getLibros();

		return libros;
	}
}
