package services;

import pojos.Request;
import incidenceManagement.RESTClient;




import com.google.gson.Gson;

import utils.ConstantesGestionIncidencias;

public class RESTVipCustomerService {
	
	private static Request respuestaKAM;
	
	public String enviarPeticion(String ticketId, String ticketType, String ticketIssue, String ticketDescription, String ticketAuthor, String ticketDate) {
		
		Request request = new Request();
		request.setId(ticketId);
		request.setType(ticketType);;
		request.setIssue(ticketIssue);
		request.setDescription(ticketDescription);
		request.setAuthor(ticketAuthor);
		request.setDate(ticketDate);
		request.setState(ConstantesGestionIncidencias.STATE_NEW);
		
		String resultado = RESTClient.doPost("", request);
		
		return resultado;
	}
	
	public Boolean comprobarRespuestasDeKAW(String ticketId) {
		
		Boolean haySolucion = false;
		//TODO
		String peticion = RESTClient.doGet(ticketId);
		Gson gson = new Gson();
		
		respuestaKAM = gson.fromJson(peticion, Request.class);
		if (respuestaKAM != null) {
			System.out.println(respuestaKAM.toString());
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
