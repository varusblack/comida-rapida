package services;

import incidenceManagement.RESTClient;

import java.util.List;

import com.google.gson.Gson;

import pojos.Request;
import utils.ConstantesGestionIncidencias;

public class RESTTroubleTicketSystemService {

	private static List<Request> listaPeticionesKAM;
	private static Request peticionKAM;
	
	public Boolean comprobarPeticiones() {
		Boolean hayPeticiones = false;
		//Buscar por estado
		String peticiones = RESTClient.doGet("");
		Gson gson = new Gson();
		
		listaPeticionesKAM = (List<Request>) gson.fromJson(peticiones, Request.class);
		if(listaPeticionesKAM.size() > 0) {
			hayPeticiones = true;
			peticionKAM = listaPeticionesKAM.get(0);
		}
		return hayPeticiones;
	}
	
	public Boolean actualizarResultado(String systemTicketResults) {
		String url = peticionKAM.getTicketId();
		
		String POSTText = ConstantesGestionIncidencias.TICKET_RESULTS + "=" + systemTicketResults + "&" + 
				ConstantesGestionIncidencias.TICKET_STATE + "=" + ConstantesGestionIncidencias.STATE_FINISHED_SYSTEM;
		
		Boolean resultado = RESTClient.doPut(url, POSTText);
		
		return resultado;
		
	}

	public static List<Request> getListaPeticionesKAM() {
		return listaPeticionesKAM;
	}

	public static void setListaPeticionesKAM(List<Request> listaPeticionesKAM) {
		RESTTroubleTicketSystemService.listaPeticionesKAM = listaPeticionesKAM;
	}

	public static Request getPeticionKAM() {
		return peticionKAM;
	}

	public static void setPeticionKAM(Request peticionKAM) {
		RESTTroubleTicketSystemService.peticionKAM = peticionKAM;
	}
	
	
}
