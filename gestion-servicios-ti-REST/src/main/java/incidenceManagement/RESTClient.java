package incidenceManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;

import utils.ConstantesGestionIncidencias;

public class RESTClient {
	
	private static final Logger LOGGER = Logger.getLogger("IncidenceManagement");
	
	public static String doGet(final String url) {
		LOGGER.info("INICIANDO: Peticion GET - Parametros [URL=" + ConstantesGestionIncidencias.URL_API + "]");

		String resultado = null;
		final HttpClient httpClient = new DefaultHttpClient();
		HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 10000);
		HttpGet httpget;
		InputStream instream = null;
		
		try {
			LOGGER.info("EJECUTANDO: Peticion GET - Parametros"  );
			httpget = new HttpGet(ConstantesGestionIncidencias.URL_API + url);
			HttpResponse response = httpClient.execute(httpget);
			HttpEntity entity = response.getEntity();
			instream = entity.getContent();
			resultado = read(instream);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion GET. Motivo: Error de sintaxis en la URI");
		} catch (HttpException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion GET. Motivo: Error en el proceso de envío");
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion GET. Motivo: Error en operación IO");
		}
		LOGGER.info("EXITO: Peticion GET completada"  );
		return resultado;
	}

	public static String doPost(final String url, final String POSTText){
		LOGGER.info("INICIANDO: Peticion POST - Parametros [URL=" + ConstantesGestionIncidencias.URL_API + "]");
		
		String resultado = null;

		final HttpClient httpClient = new DefaultHttpClient();
		HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 10000);

		HttpPost httpPost;
		try {
			LOGGER.info("EJECUTANDO: Peticion POST - Parametros"  );
			httpPost = new HttpPost(ConstantesGestionIncidencias.URL_API + url);
			//Pasando parámetros para la petición
			StringEntity entity = new StringEntity(POSTText, "UTF-8");
			BasicHeader basicHeader = new BasicHeader(HTTP.CONTENT_TYPE, "application/json");
			httpPost.getParams().setBooleanParameter("http.protocol.expect-continue", false);
			entity.setContentType(basicHeader);
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);
			InputStream instream = response.getEntity().getContent();
			resultado = read(instream);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion POST. Motivo: Error de sintaxis en la URI");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion POST. Motivo: El encoding no está soportado");
		} catch (HttpException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion POST. Motivo: Error en el proceso de envío");
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion POST. Motivo: Error en operación IO");
		}
		LOGGER.info("EXITO: Peticion POST completada"  );
		return resultado;
	}

	public static boolean doPut(final String url, final String PUTText) {
		LOGGER.info("INICIANDO: Peticion PUT - Parametros [URL=" + ConstantesGestionIncidencias.URL_API + "]");
		Boolean resultado = null;
		
		final HttpClient httpClient = new DefaultHttpClient();
		HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 10000);

		HttpPut httpPut;
		try {
			LOGGER.info("EJECUTANDO: Peticion PUT - Parametros [URL=" + ConstantesGestionIncidencias.URL_API + "]");
			httpPut = new HttpPut(ConstantesGestionIncidencias.URL_API + url);
			httpPut.addHeader("Accept", "application/json");
			httpPut.addHeader("Content-Type", "application/json");
			//Pasando parámetros para la petición
			StringEntity entity = new StringEntity(PUTText, "UTF-8");
			entity.setContentType("application/json");
			httpPut.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPut);
			int statusCode = response.getStatusLine().getStatusCode();
			resultado = statusCode == 200 ? true : false;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion PUT. Motivo: Error de sintaxis en la URI");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion PUT. Motivo: El encoding no está soportado");
		} catch (HttpException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion PUT. Motivo: Error en el proceso de envío");
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion PUT. Motivo: Error en operación IO");
		}
		LOGGER.info("EXITO: Peticion PUT completada");
		return resultado;
	}

	public static boolean doDelete(final String url) {
		LOGGER.info("INICIANDO: Peticion DELETE - Parametros [URL=" + ConstantesGestionIncidencias.URL_API + "]");
		Boolean resultado = null;
		
		final HttpClient httpClient = new DefaultHttpClient();
		HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 10000);
		

		HttpDelete httpDelete;
		try {
			LOGGER.info("EJECUTANDO: Peticion DELETE - Parametros [URL=" + ConstantesGestionIncidencias.URL_API + "]");
			httpDelete = new HttpDelete(ConstantesGestionIncidencias.URL_API + url);
			httpDelete.addHeader("Accept", "text/html, image/jpeg, *; q=.2, */*; q=.2");
			HttpResponse response = httpClient.execute(httpDelete);
			int statusCode = response.getStatusLine().getStatusCode();
			resultado = statusCode == 200 ? true : false;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion DELETE. Motivo: Error de sintaxis en la URI");
		} catch (HttpException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion DELETE. Motivo: Error en el proceso de envío");
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.info("ERROR AL EJECUTAR: Peticion DELETE. Motivo: Error en operación IO");
		}
		LOGGER.info("EXITO: Peticion DELETE completada");
		return resultado;
	}

	private static String read(InputStream in) throws IOException {
		
		LOGGER.info("EJECUTANDO: Lectura de datos");
		StringBuilder sb = new StringBuilder();
		BufferedReader r = new BufferedReader(new InputStreamReader(in), 1000);
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			sb.append(line);
		}
		in.close();
		LOGGER.info("EXITO: Lectura de datos completada");
		return sb.toString();
	}
}
