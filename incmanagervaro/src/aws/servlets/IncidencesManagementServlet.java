package aws.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aws.models.Incidence;
import aws.utilities.SystemDate;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.gson.Gson;

/**
 * Controlador de incidencias REST. Crea un servlet y redirecciona las
 * peticiones REST.
 * 
 * @author Alberto Salido
 * @author Alvaro Tristancho
 * @author Nicolas Sanchez
 * 
 */
@SuppressWarnings("serial")
public class IncidencesManagementServlet extends HttpServlet {

	// Persistencia
	private DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();

	/**
	 * Peticiones GET. Muestra una o varias incidencias.
	 * 
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setContentType("application/json");

		String path = req.getPathInfo();
		logMessage("Accessing to '" + path + "' via GET.");

		// GET /incidences/
		if ((path == null) || (path.equals("/"))) {
			// Obtiene las incidencias de datastore
			Collection<Incidence> incidences = getIncidencesFromDS();
			String json = getJson(incidences);
			resp.getWriter().println(json);
		}
		else {
			// GET /incidences/{code}
			path = path.substring(1);
			if (!path.contains("=")) {
				// Obtiene la Incidence por su ID de Datastore
				path = path.substring(1); // Elimina el caracter '/'
				Incidence i = getIncidenceFromDS(path);
				String json = getJson(i);
				resp.getWriter().println(json);
			} else {
				// Se obtienen los parámetros por los cuales filtrar
				String[] params = path.split("&");
				Map<String,String> paramsMap = new HashMap<String,String>();
				// Se llena el mapa con los parámetros recogidos
				for (int i = 0 ; i < params.length ; i++) {
					String[] keyValue = params[i].split("=");
					paramsMap.put(keyValue[0], keyValue[1]);
				}
				// Se filtra solo por un parámetro, según el que llegue
				if (paramsMap.containsKey("state")) {
					Collection<Incidence> incidences = getEntitiesByParam("state",paramsMap.get("state"));
					String json = getJson(incidences);
					resp.getWriter().println(json);
				}
			}
		}
	}

	/**
	 * Peticiones POST. Crea una nueva Incidencia
	 * 
	 * @throws ServletException
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		resp.setContentType("application/json");

		String path = req.getPathInfo();
		logMessage("Accessing to '" + path + "' via POST.");

		Incidence i = null;
		String id = req.getParameter("id");
		String type = req.getParameter("type");
		String issue = req.getParameter("issue");
		String description = req.getParameter("description");
		String author = req.getParameter("author");
		String date = req.getParameter("date");
		String solution = req.getParameter("solution");
		String state = req.getParameter("state");

		// Crea la incidecia
		// POST /Incidences
		i = new Incidence();
		if (id != null) {
			i.setId(id);
		}

		i.setTicketType(type);
		i.setTicketIssue(issue);
		i.setTicketDescription(description);
		i.setTicketAuthor(author);
		i.setState(state);
		i.setTicketSolution(solution);

		if (date != null) {
			i.setDate(date);
		}

		// Almacena la entidd en DataStore.
		storeInDataStore(i);
		logMessage("New Incidence registered: " + i.toString());

		resp.getWriter().println(getJson(i));
	}

	/**
	 * Peticiones PUT para actulizar elementos. Estas peticiones solo son
	 * accesibles desde un cliente REST (Advanced Rest Client en Chrome).
	 */
	public void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		resp.setContentType("application/json");

		// Obtiene el ID de la incidencia a actualizar.
		String id = req.getPathInfo().substring(1); // Elimina el caracter '/'

		String state = req.getParameter("state");

		Incidence i = getIncidenceFromDS(id);
		if (i != null) {
			i.setState(state);
			updateIncidenceInDataStore(i);
			logMessage("Incidence " + i.toString() + " updated.");
			resp.getWriter().println(getJson(i));
		} else {
			logMessage("Incidence with code " + id + " not found.");
			resp.getWriter().println("{}");
		}
	}

	/**
	 * Peticiones DELETE. Elimina una instancia. Estas peticiones solo son
	 * accesibles desde un cliente REST (Advanced Rest Client en Chrome).
	 * 
	 * @throws IOException
	 */
	public void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("application/json");

		// Obtiene el ID de la incidencia a actualizar.
		String id = req.getPathInfo().substring(1); // Elimina el caracter '/'

		Incidence i = getIncidenceFromDS(id);
		if (i != null) {
			deleteIncidenceFromDS(i);
			logMessage("Incidence " + i.toString() + " deleted.");
			resp.getWriter().println(getJson(getIncidencesFromDS()));
		} else {
			logMessage("Incidence with code" + id + " not found.");
			resp.getWriter().println("{}");
		}
	}

	/**
	 * Guarda la entidad en DataStore
	 * 
	 * @param i
	 *            Incidencia a almacenar.
	 */
	private void storeInDataStore(Incidence i) {
		Entity e = new Entity("Incidence");
		e.setProperty("id", i.getId());
		e.setProperty("type", i.getTicketType());
		e.setProperty("issue", i.getTicketIssue());
		e.setProperty("description", i.getTicketDescription());
		e.setProperty("date", i.getDate());
		e.setProperty("state", i.getState());
		e.setProperty("author", i.getTicketAuthor());
		e.setProperty("solution", i.getTicketSolution());
		datastore.put(e);
	}

	/**
	 * Obtiene una coleccion de Incidencias desde Datastore
	 * 
	 * @return Collection con las Incidencias.
	 */
	private Collection<Incidence> getIncidencesFromDS() {
		Collection<Incidence> result = new HashSet<Incidence>();
		Query q = new Query("Incidence");
		PreparedQuery pq = datastore.prepare(q);
		Iterator<Entity> it = pq.asIterator();
		while (it.hasNext()) {
			Entity e = it.next();
			Incidence i = setIncidenceFromEntity(e);
			result.add(i);
		}
		return result;
	}

	/**
	 * Obtine una Incidencia.
	 * 
	 * @param id
	 *            Identificador de la Incidencia
	 * @return Incidencia encontrada o null
	 */
	private Incidence getIncidenceFromDS(String id) {
		Incidence result = null;
		Entity e = getEntity(id);
		if (e != null) {
			result = setIncidenceFromEntity(e);
		}
		return result;
	}

	/**
	 * Elimina una Incidencia de dataStore
	 * 
	 * @param i
	 *            Incidencia a eliminar.
	 */
	private void deleteIncidenceFromDS(Incidence i) {
		Entity e = getEntity(i.getId());
		datastore.delete(e.getKey());
	}

	/**
	 * Actualiza una incicencia en datastore.Solo actualizara los atributos
	 * solution y state.
	 * 
	 * @param i
	 *            Incidencia a actualizar.
	 */
	private void updateIncidenceInDataStore(Incidence i) {
		Entity e = getEntity(i.getId());
		e.setProperty("state", i.getState());
		e.setProperty("solution", i.getTicketSolution());
		datastore.put(e);
	}

	/**
	 * Obtiene una entidad de datastore.
	 * 
	 * @param id
	 *            Identificador de la entidad a obtener
	 * @return Entidad de datastore.
	 */
	private Entity getEntity(String id) {
		Query q = new Query("Incidence").setFilter(new FilterPredicate("id",
				Query.FilterOperator.EQUAL, id));
		PreparedQuery pq = datastore.prepare(q);
		Entity e = pq.asSingleEntity();
		return e;
	}
	
	/**
	 * Obtiene una lista de entidades del datastore según un parámetro con un valor.
	 * 
	 * @param paramKey 
	 *            Nombre del atributo por el que buscar
	 * @param paramValue
	 * 			  Valor del atributo por el que buscar
	 * @return Entidad de datastore.
	 */
	private Collection<Incidence> getEntitiesByParam(String paramKey, String paramValue) {
		Collection<Incidence> result = new HashSet<Incidence>();
		Query q = new Query("Incidence").setFilter(new FilterPredicate(paramKey,
				Query.FilterOperator.EQUAL, paramValue));
		PreparedQuery pq = datastore.prepare(q);

		Iterator<Entity> it = pq.asIterator();
		while (it.hasNext()) {
			Entity e = it.next();
			Incidence i = setIncidenceFromEntity(e);
			result.add(i);
		}
		return result;
	}

	/**
	 * Data una entidad e, genera la incidencia correspondiente.
	 * 
	 * @param e
	 *            Entidad
	 * @return Incidencia
	 */
	private Incidence setIncidenceFromEntity(Entity e) {
		Incidence i = new Incidence();
		i.setId((String) e.getProperty("id"));
		i.setTicketType((String) e.getProperty("type"));
		i.setTicketIssue((String) e.getProperty("issue"));
		i.setTicketDescription((String) e.getProperty("description"));
		i.setDate((String) e.getProperty("date"));
		i.setTicketAuthor((String) e.getProperty("author"));
		i.setState((String) e.getProperty("state"));
		i.setTicketSolution((String) e.getProperty("solution"));
		return i;
	}

	/**
	 * Convierte una Incidencia a JSON
	 * 
	 * @param i
	 *            Incidencia a convertir
	 * @return String JSON
	 */
	private String getJson(Incidence i) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(i);
		return jsonString;
	}

	/**
	 * Convierte una coleccion de Incidencias a JSON
	 * 
	 * @param Incidences
	 *            Coleccion a convertir
	 * @return String JSON.
	 */
	private String getJson(Collection<Incidence> Incidences) {
		Iterator<Incidence> it = Incidences.iterator();
		String jsonString = "[";
		while (it.hasNext()) {
			Incidence inc = (Incidence) it.next();
			jsonString += getJson(inc) + ",";
		}

		if (jsonString.length() > 1) {
			jsonString = (String) jsonString.subSequence(0,
					jsonString.length() - 1);
		}

		jsonString += "]";

		return jsonString;
	}

	/**
	 * Muestra un mensaje de Log en la consola. Solo para fines de depuración.
	 * 
	 * @param message
	 *            Mensaje a mostrar
	 */
	private void logMessage(String message) {
		String fecha = SystemDate.getCurrentDate();
		System.out.println("[" + fecha + "] INFO: " + message);
	}
}
