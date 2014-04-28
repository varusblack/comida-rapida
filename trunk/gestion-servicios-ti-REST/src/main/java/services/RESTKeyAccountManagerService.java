package services;

import incidenceManagement.RESTClient;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import pojos.Request;
import utils.ConstantesGestionIncidencias;
import utils.Utilidades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RESTKeyAccountManagerService {
	
	private static List<Request> peticionesPendientesVip;
	private static Request peticionVip;
	private static Request respuestaTTS;
	
	public Boolean comprobarPeticionesVip() {
		Boolean hayPeticiones = false;
		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put(ConstantesGestionIncidencias.URL_STATE, ConstantesGestionIncidencias.STATE_NEW);
		String peticiones = RESTClient.doGet(parametros);
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
		String systemTicketDate = Utilidades.fechaActual();
		
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
	
	public Boolean comprobarRespuestasTTS() {
		Boolean hayRespuesta = false;
		
		Gson gson = new Gson();
		
		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put(ConstantesGestionIncidencias.URL_STATE, ConstantesGestionIncidencias.STATE_FINISHED_SYSTEM);
		
		Type listType = new TypeToken<ArrayList<Request>>() {}.getType();
		
		String peticiones = RESTClient.doGet(parametros);
		
		peticionesPendientesVip = gson.fromJson(peticiones, listType);
		if (peticionesPendientesVip.size() > 0) {
			respuestaTTS = peticionesPendientesVip.get(0);
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
