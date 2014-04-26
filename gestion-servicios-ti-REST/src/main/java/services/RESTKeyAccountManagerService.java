package services;

import incidenceManagement.RESTClient;

import java.util.LinkedList;
import java.util.List;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;

import pojos.Request;
import utils.ConstantesGestionIncidencias;

import com.google.gson.Gson;

public class RESTKeyAccountManagerService {
	
	@Autowired
	private static RuntimeService runtimeService; 
	
	private static List<Request> peticionesPendientes = new LinkedList<Request>();
	
	public Boolean comprobarPeticiones() {
		Boolean hayPeticiones = false;
		String peticiones = RESTClient.doGet("");
		Gson gson = new Gson();
		
		peticionesPendientes = (List<Request>) gson.fromJson(peticiones, Request.class);
		if(peticionesPendientes.size() > 0) {
			hayPeticiones = true;
		}
		return hayPeticiones;
	}
	
	public String enviarPeticion() {
		String url;
		String POSTText;
		
		String resultado = RESTClient.doPost(url, POSTText);
		
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

	public static List<Request> getPeticionespendientes() {
		return peticionesPendientes;
	}

	public static void setPeticionesPendientes(List<Request> peticionesPendientes) {
		RESTKeyAccountManagerService.peticionesPendientes = peticionesPendientes;
	}

	
}
