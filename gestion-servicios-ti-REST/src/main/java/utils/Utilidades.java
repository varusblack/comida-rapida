package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {
	
	public static String fechaActual() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		String date = dateFormat.format(new Date());
 		
		return date;
	}
	
	public static String traducirStringAUrl(String string) {
		String resultado = string.replace(" ", "%20");
		return resultado;
	}

}
