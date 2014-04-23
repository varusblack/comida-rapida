package utils;

import java.util.Calendar;
import java.util.Date;

public class Fechas {
	
	public static Date fechaActual() {
		Calendar calendar = Calendar.getInstance();
		Date fecha = new Date(calendar.getTimeInMillis());
		return fecha;
	}

}
