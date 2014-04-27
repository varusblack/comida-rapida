package clases;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RunningREST {

	public static void main(String[] args) {
		// GET
//		String respuestaJSON = RESTClient.doGet();
//		System.out.println(respuestaJSON);
		
		Map<String, String> parametros = new HashMap<String,String>();
		parametros.put("state", "Nueva");
		
		String respuestaJSON = RESTClient.doGet(parametros);
//		System.out.println(respuestaJSON);
		Gson gson = new Gson();
		Request[] arrayRequest = gson.fromJson(respuestaJSON, Request[].class);
		Type listType = new TypeToken<ArrayList<Request>>() {}.getType();
//		List<Request> requests = Arrays.asList(arrayRequest);
		List<Request> requests = gson.fromJson(respuestaJSON, listType);
		System.out.println(requests.get(0).getId());
		
		
		// POST
//		Request requestToPost = new Request();
//		requestToPost.setId("0097900");
//		requestToPost.setIssue("Probando+desde+JAVA");
//		requestToPost.setDate("rabano+verde");
//		requestToPost.setState("Pendiente+pa+probar");
//		requestToPost.setAuthor("varouski");
//		requestToPost.setType("putada");
//		
//		String respuesta = "";
//		try {
//			respuesta = RESTClient.doPost("", requestToPost);
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		} catch (HttpException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(respuesta);
		
		// PUT
//		Boolean seHizo = null;
//		String tmpTit = "Un titulito para probar";
//		String titulo = tmpTit.replace(" ", "+");
//		String idRequest = "874682457";
//		
//		try {
//			seHizo = RESTClient.doPut(idRequest, titulo);
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		} catch (HttpException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(seHizo);
		
		// DELETE
//		Boolean seHizo = null;
//		String idRequest = "874682457";
//		
//		try {
//			seHizo = RESTClient.doDelete(idRequest);
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		} catch (HttpException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(seHizo);
	}
}
