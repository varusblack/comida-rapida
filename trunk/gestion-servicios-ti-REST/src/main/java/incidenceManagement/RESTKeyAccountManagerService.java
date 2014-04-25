package incidenceManagement;

public class RESTKeyAccountManagerService {

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

}
