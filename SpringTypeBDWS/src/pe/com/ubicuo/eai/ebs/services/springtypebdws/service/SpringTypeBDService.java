package pe.com.ubicuo.eai.ebs.services.springtypebdws.service;

import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.ConsultarPersonaRequest;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.ConsultarPersonaResponse;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.InsertarPersonaRequest;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.InsertarPersonaResponse;

public interface SpringTypeBDService {
	
	InsertarPersonaResponse insertarPersona(InsertarPersonaRequest request);
	ConsultarPersonaResponse consultarPersona(ConsultarPersonaRequest request);
}
