package pe.com.ubicuo.eai.ebs.services.springtypebdws.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class FechaUtil {

	private static final Logger LOGGER = Logger.getLogger(FechaUtil.class);
	
	public static Date stringToDate(String fecha, String formato){
		
		Date fechaDate = null;
		try{
			SimpleDateFormat formatter = new SimpleDateFormat(formato);
			
			fechaDate = formatter.parse(fecha);
		}catch(Exception e){
			LOGGER.error("Error parseando fecha: " + fecha);
		}
		
		return fechaDate;
	}
}
