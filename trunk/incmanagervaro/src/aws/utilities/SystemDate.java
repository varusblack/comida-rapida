package aws.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase Fecha. Representa fechas del sistema.
 * 
 * @author Alberto Salido
 * @author Alvaro Tristancho
 * @author Nicolas Sanchez
 * 
 */
public class SystemDate {

	/**
	 * Obtiene la fecha actual en el formato yyyy/MM/dd HH:mm:ss
	 * 
	 * @return String con la fecha.
	 */
	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(new Date());
	}
}
