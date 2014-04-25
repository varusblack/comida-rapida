package incidenceManagement;

public class RESTVipCustomerService {
	
	public String sendRequest() {
		String url;
		String POSTText;
		
		String resultado = RESTClient.doPost(url, POSTText);
		
		return resultado;
	}

}
