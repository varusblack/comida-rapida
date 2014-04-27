package services;

import incidenceManagement.RESTClient;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;

import pojos.Request;
import utils.ConstantesGestionIncidencias;
import utils.Fechas;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
		
		Type listType = new TypeToken<ArrayList<Request>>() {}.getType();
		peticionesPendientesVip = gson.fromJson(peticiones, listType);
		if(peticionesPendientesVip.size() > 0) {
			hayPeticiones = true;
			peticionVip = peticionesPendientesVip.get(0);
		}
		return hayPeticiones;
	}
	
	public String enviarPeticion(String ticketId, String systemTicketIssue, String systemTicketDescription, String systemTicketAuthor) {
		String systemTicketDate = Fechas.fechaActual();
		
		Request request = new Request();
		
		request.setId(ticketId);
		request.setIssue(systemTicketIssue);
		request.setDescription(systemTicketDescription);
		request.setAuthor(systemTicketAuthor);
		request.setDate(systemTicketDate);
		request.setState(ConstantesGestionIncidencias.STATE_NEW_SYSTEM);
		
		String resultado = RESTClient.doPost("", request);
		
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
		peticionVip.setSolution(ticketResults);
		peticionVip.setState(ConstantesGestionIncidencias.STATE_FINISHED);
		
		
		Boolean resultado = RESTClient.doPut(peticionVip.getId(), peticionVip);
		
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
