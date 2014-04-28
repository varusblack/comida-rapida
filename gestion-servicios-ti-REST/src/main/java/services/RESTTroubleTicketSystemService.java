package services;

import incidenceManagement.RESTClient;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
		
		Type listType = new TypeToken<ArrayList<Request>>() {}.getType();
		listaPeticionesKAM = gson.fromJson(peticiones,listType);
		if(listaPeticionesKAM.size() > 0) {
			hayPeticiones = true;
			peticionKAM = listaPeticionesKAM.get(0);
		}
		return hayPeticiones;
	}
	
	public Boolean actualizarResultado(String systemTicketResults) {
		peticionKAM.setSolution(systemTicketResults);
		peticionKAM.setState(ConstantesGestionIncidencias.STATE_FINISHED_SYSTEM);
		
		Boolean resultado = RESTClient.doPut(peticionKAM.getId(), peticionKAM);
		
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