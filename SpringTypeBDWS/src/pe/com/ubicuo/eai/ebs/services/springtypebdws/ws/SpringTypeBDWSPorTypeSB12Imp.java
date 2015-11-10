package pe.com.ubicuo.eai.ebs.services.springtypebdws.ws;

import javax.annotation.PostConstruct;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.com.ubicuo.eai.ebs.services.springtypebdws.service.SpringTypeBDService;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.ConsultarPersonaRequest;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.ConsultarPersonaResponse;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.InsertarPersonaRequest;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.types.InsertarPersonaResponse;

@WebService(serviceName = "SpringTypeBDWSWSService", 
			targetNamespace = "http://ubicuo.com.pe/eai/ebs/services/SpringTypeBDWS/ws", 
			portName = "SpringTypeBDWSPort12SB", 
			endpointInterface = "pe.com.ubicuo.eai.ebs.services.springtypebdws.ws.SpringTypeBDWSPortType",
			wsdlLocation = "/WEB-INF/wsdl/SpringTypeBDWS.wsdl")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class SpringTypeBDWSPorTypeSB12Imp implements SpringTypeBDWSPortType {

	@Autowired
	SpringTypeBDService springTypeBDService;
	
	public SpringTypeBDWSPorTypeSB12Imp(){}
	
	@PostConstruct
//    @WebMethod( exclude = true )
    public void init(){
                SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext( this );
    }
	
	@Override
	public InsertarPersonaResponse insertarPersona(InsertarPersonaRequest request) {
		return springTypeBDService.insertarPersona(request);
	}

	@Override
	public ConsultarPersonaResponse consultarPersona(ConsultarPersonaRequest request) {		
		return springTypeBDService.consultarPersona(request);
	}

}
