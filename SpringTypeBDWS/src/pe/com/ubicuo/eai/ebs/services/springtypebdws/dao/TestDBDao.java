package pe.com.ubicuo.eai.ebs.services.springtypebdws.dao;

import java.util.List;

import pe.com.ubicuo.eai.ebs.services.springtypebdws.bean.PersonaBean;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.bean.RespuestaBean;

public interface TestDBDao {

	RespuestaBean insertarPersonas(String cadenaTrazabilidad, PersonaBean[] personas);
	List<PersonaBean> consultarPersonas(String cadenaTrazabilidad);
	PersonaBean[] consultarPersonasType(String cadenaTrazabilidad);
}
