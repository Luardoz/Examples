package pe.com.ubicuo.eai.ebs.services.springtypebdws.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ubicuo.eai.ebs.services.springtypebdws.bean.PersonaBean;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.bean.RespuestaBean;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.dao.TestDBDao;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.ConsultarPersonaRequest;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.ConsultarPersonaResponse;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.InsertarPersonaRequest;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.InsertarPersonaResponse;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.ListaPersonaType;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.ParametrosAuditResponseType;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.ListaPersonaType.Persona;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.util.JAXBUtil;

@Service
public class SpringTypeBDServiceImp implements SpringTypeBDService {

	private final Logger logger = Logger.getLogger( this.getClass().getName() );
	
	@Autowired
	TestDBDao testDBDao;
	
	@Override
	public InsertarPersonaResponse insertarPersona(InsertarPersonaRequest request) {
		
		String cadenaTrazabilidad = "[insertarPersona]";
		long timeStart = System.currentTimeMillis();
		logger.info(cadenaTrazabilidad + "<<---------------- Inicio metodo insertarPersona ---------------->>");
		logger.info(cadenaTrazabilidad + "Input Servicio:\n" + JAXBUtil.anyObjectToXmlText(request));
		
		InsertarPersonaResponse response = new InsertarPersonaResponse();
		response.setParametrosAuditResponse(new ParametrosAuditResponseType());
		response.getParametrosAuditResponse().setIdTransaccion(request.getParametrosAuditRequest().getIdTransaccion());
		try{
			
			PersonaBean[] personas = new PersonaBean[request.getListaPersona().getPersona().size()];
			for(int i=0; i<request.getListaPersona().getPersona().size(); i++){
				Persona persona = request.getListaPersona().getPersona().get(i);
				
				PersonaBean personaBean = new PersonaBean();
				personaBean.setApellido(persona.getApellido());
				personaBean.setEmail(persona.getEmail());
				personaBean.setEstadoCivil(persona.getEstadoCivil());
				personaBean.setFechaNac(persona.getFechaNacimiento());
				personaBean.setNombre(persona.getNombre());
				personaBean.setSexo(persona.getSexo());
				personaBean.setTelefono(persona.getTelefono());
				
				personas[i] = personaBean;
			}
			
			RespuestaBean resTestDB = testDBDao.insertarPersonas(cadenaTrazabilidad, personas);
			
			if(null != resTestDB){
				response.getParametrosAuditResponse().setCodigoRespuesta(resTestDB.getCodResp()+"");
				response.getParametrosAuditResponse().setMensajeRespuesta(resTestDB.getMsjResp());
				response.setFechaOperacion(new Date().toString());			
			}
						
			
		}catch(Exception e){
			logger.error(cadenaTrazabilidad + "Error: " + e.getMessage(), e);
		}catch(Throwable e){
			logger.error(cadenaTrazabilidad + "Error: " + e.getMessage(), e);
		}finally{
			logger.info(cadenaTrazabilidad + "Output Servicio:\n" + JAXBUtil.anyObjectToXmlText(response));
			logger.info(cadenaTrazabilidad + "Tiempo total transcurrido(ms): " + (System.currentTimeMillis() - timeStart));
			logger.info(cadenaTrazabilidad + "<<---------------- Fin metodo insertarPersona ---------------->>");
		}
		
		return response;
	}

//	@Override
//	public ConsultarPersonaResponse consultarPersona(ConsultarPersonaRequest request) {
//		
//		String cadenaTrazabilidad = "[consultarPersona]";
//		long timeStart = System.currentTimeMillis();
//		logger.info(cadenaTrazabilidad + "<<---------------- Inicio metodo consultarPersona ---------------->>");
//		logger.info(cadenaTrazabilidad + "Input Servicio:\n" + JAXBUtil.anyObjectToXmlText(request));
//		
//		ConsultarPersonaResponse response = new ConsultarPersonaResponse();
//		response.setParametrosAuditResponse(new ParametrosAuditResponseType());			
//		response.getParametrosAuditResponse().setIdTransaccion(request.getParametrosAuditRequest().getIdTransaccion());
//		try{
//			ListaPersonaType personas = new ListaPersonaType();
//			List<PersonaBean> personasList = testDBDao.consultarPersonas(cadenaTrazabilidad);
//			
//			if(null != personasList && personasList.size()>0){
//				for(PersonaBean personaBean: personasList){
//					Persona persona = new Persona();
//					persona.setApellido(personaBean.getApellido());
//					persona.setEmail(personaBean.getEmail());
//					persona.setEstadoCivil(personaBean.getEstadoCivil());
//					persona.setFechaNacimiento(personaBean.getFechaNac().toString());
//					persona.setIdpersona(personaBean.getIdpersona()+"");
//					persona.setNombre(personaBean.getNombre());
//					persona.setSexo(personaBean.getSexo());
//					persona.setTelefono(personaBean.getTelefono());
//					
//					personas.getPersona().add(persona);
//				}
//				
//				response.setListaPersona(personas);	
//				response.getParametrosAuditResponse().setCodigoRespuesta("0");
//				response.getParametrosAuditResponse().setMensajeRespuesta("Operación exitosa");
//				response.setFechaOperacion(new Date().toString());
//			}else{				
//				response.getParametrosAuditResponse().setCodigoRespuesta("1");
//				response.getParametrosAuditResponse().setMensajeRespuesta("No hay personas en la BD");
//				response.setFechaOperacion(new Date().toString());										
//			}
//					
//			
//		}catch(Exception e){
//			logger.error(cadenaTrazabilidad + "Error: " + e.getMessage(), e);
//		}catch(Throwable e){
//			logger.error(cadenaTrazabilidad + "Error: " + e.getMessage(), e);
//		}finally{
//			logger.info(cadenaTrazabilidad + "Output Servicio:\n" + JAXBUtil.anyObjectToXmlText(response));
//			logger.info(cadenaTrazabilidad + "Tiempo total transcurrido(ms): " + (System.currentTimeMillis() - timeStart));
//			logger.info(cadenaTrazabilidad + "<<---------------- Fin metodo consultarPersona ---------------->>");
//		}
//		return response;
//	}
	
	@Override
	public ConsultarPersonaResponse consultarPersona(ConsultarPersonaRequest request) {
		
		String cadenaTrazabilidad = "[consultarPersona]";
		long timeStart = System.currentTimeMillis();
		logger.info(cadenaTrazabilidad + "<<---------------- Inicio metodo consultarPersona ---------------->>");
		logger.info(cadenaTrazabilidad + "Input Servicio:\n" + JAXBUtil.anyObjectToXmlText(request));
		
		ConsultarPersonaResponse response = new ConsultarPersonaResponse();
		response.setParametrosAuditResponse(new ParametrosAuditResponseType());			
		response.getParametrosAuditResponse().setIdTransaccion(request.getParametrosAuditRequest().getIdTransaccion());
		try{
			ListaPersonaType personas = new ListaPersonaType();
			PersonaBean[] personasList = testDBDao.consultarPersonasType(cadenaTrazabilidad);
			
			if(null != personasList && personasList.length>0){
				for(PersonaBean personaBean: personasList){
					Persona persona = new Persona();
					persona.setApellido(personaBean.getApellido());
					persona.setEmail(personaBean.getEmail());
					persona.setEstadoCivil(personaBean.getEstadoCivil());
					persona.setFechaNacimiento(personaBean.getFechaNac().toString());
					persona.setIdpersona(personaBean.getIdpersona()+"");
					persona.setNombre(personaBean.getNombre());
					persona.setSexo(personaBean.getSexo());
					persona.setTelefono(personaBean.getTelefono());
					
					personas.getPersona().add(persona);
				}
				
				response.setListaPersona(personas);	
				response.getParametrosAuditResponse().setCodigoRespuesta("0");
				response.getParametrosAuditResponse().setMensajeRespuesta("Operación exitosa");
				response.setFechaOperacion(new Date().toString());
			}else{				
				response.getParametrosAuditResponse().setCodigoRespuesta("1");
				response.getParametrosAuditResponse().setMensajeRespuesta("No hay personas en la BD");
				response.setFechaOperacion(new Date().toString());										
			}
					
			
		}catch(Exception e){
			logger.error(cadenaTrazabilidad + "Error: " + e.getMessage(), e);
		}catch(Throwable e){
			logger.error(cadenaTrazabilidad + "Error: " + e.getMessage(), e);
		}finally{
			logger.info(cadenaTrazabilidad + "Output Servicio:\n" + JAXBUtil.anyObjectToXmlText(response));
			logger.info(cadenaTrazabilidad + "Tiempo total transcurrido(ms): " + (System.currentTimeMillis() - timeStart));
			logger.info(cadenaTrazabilidad + "<<---------------- Fin metodo consultarPersona ---------------->>");
		}
		return response;
	}

}
