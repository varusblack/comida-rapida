package services;

import incidenceManagement.RESTClient;

import java.util.UUID;

import pojos.Request;

import com.google.gson.Gson;

import utils.ConstantesGestionIncidencias;
import utils.Fechas;

public class RESTVipCustomerService {
	
	public String enviarPeticion(String ticketType, String ticketIssue, String ticketDescription, String ticketAuthor) {
		
		String ticketId = UUID.randomUUID().toString();
		String ticketDate = Fechas.fechaActual();
		
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

}
