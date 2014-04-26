package services;

import incidenceManagement.RESTClient;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

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
	
	public Boolean comprobarPeticiones() {
		Boolean hayPeticiones = false;
		String peticiones = RESTClient.doGet("");
		Gson gson = new Gson();
		
		peticionesPendientesVip = (List<Request>) gson.fromJson(peticiones, Request.class);
		if(peticionesPendientesVip.size() > 0) {
			hayPeticiones = true;
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
	
	public Boolean modificarPeticion() {
		String url;
		String POSTText;
		
		Boolean resultado = RESTClient.doPut(url, POSTText);
		
		return resultado;
	}
	
	public Boolean borrarPeticion() {
		String url;
		
		Boolean resultado = RESTClient.doDelete(url);
		
		return resultado;
	}

	public static List<Request> getPeticionesPendientesVip() {
		return peticionesPendientesVip;
	}

	public static void setPeticionesPendientesVip(List<Request> peticionesPendientesVip) {
		RESTKeyAccountManagerService.peticionesPendientesVip = peticionesPendientesVip;
	}

	
}
