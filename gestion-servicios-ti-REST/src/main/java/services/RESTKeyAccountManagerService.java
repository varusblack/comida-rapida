package services;

import incidenceManagement.RESTClient;

import java.util.LinkedList;
import java.util.List;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;

import pojos.Request;
import utils.ConstantesGestionIncidencias;
import utils.Fechas;

import com.google.gson.Gson;

public class RESTKeyAccountManagerService {
	
	@Autowired
	private static RuntimeService runtimeService; 
	
	private static List<Request> peticionesPendientesVip = new LinkedList<Request>();
	private static Request peticionVip = null;
	private static Request respuestaTTS = null;
	
	public Boolean comprobarPeticionesVip() {
		Boolean hayPeticiones = false;
		String peticiones = RESTClient.doGet("");
		Gson gson = new Gson();
		
		peticionesPendientesVip = (List<Request>) gson.fromJson(peticiones, Request.class);
		if(peticionesPendientesVip.size() > 0) {
			hayPeticiones = true;
			peticionVip = peticionesPendientesVip.get(0);
		}
		return hayPeticiones;
	}
	
	public String enviarPeticion(String ticketId, String systemTicketIssue, String systemTicketDescription, String systemTicketAuthor) {
		String systemTicketDate = Fechas.fechaActual();
		
		Request request = new Request();
		Gson gson = new Gson();
		
		request.setTicketId(ticketId);
		request.setTicketType("");
		request.setTicketIssue(systemTicketIssue);
		request.setTicketDescription(systemTicketDescription);
		request.setTicketAuthor(systemTicketAuthor);
		request.setTicketDate(systemTicketDate);
		request.setTicketSolution("");
		request.setTicketState(ConstantesGestionIncidencias.STATE_NEW_SYSTEM);
		
		String POSTText = gson.toJson(request);
		String resultado = RESTClient.doPost("", POSTText);
		
		return resultado;
	}
	
	public Boolean comprobarRespuestasTTS(String ticketId) {
		Boolean hayRespuesta = false;
		
		String peticion = RESTClient.doGet(ticketId);
		Gson gson = new Gson();
		
		respuestaTTS = gson.fromJson(peticion, Request.class);
		if (respuestaTTS != null) {
			hayRespuesta = true;
		}
		
		return hayRespuesta;
	}
	
	public Boolean modificarPeticion(String ticketResults) {
		String url = peticionVip.getTicketId();
		
		String POSTText = ConstantesGestionIncidencias.TICKET_RESULTS + "=" + ticketResults + "&" + 
				ConstantesGestionIncidencias.TICKET_STATE + "=" + ConstantesGestionIncidencias.STATE_FINISHED;
		
		Boolean resultado = RESTClient.doPut(url, POSTText);
		
		return resultado;
	}
	
	public static List<Request> getPeticionesPendientesVip() {
		return peticionesPendientesVip;
	}

	public static void setPeticionesPendientesVip(List<Request> peticionesPendientesVip) {
		RESTKeyAccountManagerService.peticionesPendientesVip = peticionesPendientesVip;
	}

	public static Request getPeticionVip() {
		return peticionVip;
	}

	public static void setPeticionVip(Request peticionVip) {
		RESTKeyAccountManagerService.peticionVip = peticionVip;
	}

	public static Request getRespuestaTTS() {
		return respuestaTTS;
	}

	public static void setRespuestaTTS(Request respuestaTTS) {
		RESTKeyAccountManagerService.respuestaTTS = respuestaTTS;
	}

	
}
