package services;

import pojos.Request;
import incidenceManagement.RESTClient;



import com.google.gson.Gson;

import utils.ConstantesGestionIncidencias;

public class RESTVipCustomerService {
	
	private static Request respuestaKAM = null;
	
	public String enviarPeticion(String ticketId, String ticketType, String ticketIssue, String ticketDescription, String ticketAuthor, String ticketDate) {
		
		Request request = new Request();
		Gson gson = new Gson();
		
		request.setTicketId(ticketId);
		request.setTicketType(ticketType);;
		request.setTicketIssue(ticketIssue);
		request.setTicketDescription(ticketDescription);
		request.setTicketAuthor(ticketAuthor);
		request.setTicketDate(ticketDate);
		request.setTicketSolution("");
		request.setTicketState(ConstantesGestionIncidencias.STATE_NEW);
		
		String POSTText = gson.toJson(request);
		String resultado = RESTClient.doPost("", POSTText);
		
		return resultado;
	}
	
	public Boolean comprobarRespuestasDeKAW(String ticketId) {
		Boolean haySolucion = false;
		
		String peticion = RESTClient.doGet(ticketId);
		Gson gson = new Gson();
		
		respuestaKAM = gson.fromJson(peticion, Request.class);
		if (respuestaKAM != null) {
			haySolucion = true;
		}
		
		return haySolucion;
	}

	public static Request getRespuestaKAM() {
		return respuestaKAM;
	}

	public static void setRespuestaKAM(Request respuestaKAM) {
		RESTVipCustomerService.respuestaKAM = respuestaKAM;
	}
	
	

}
