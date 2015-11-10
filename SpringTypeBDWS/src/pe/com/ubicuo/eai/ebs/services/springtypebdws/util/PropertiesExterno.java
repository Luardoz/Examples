package pe.com.ubicuo.eai.ebs.services.springtypebdws.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesExterno {

	@Value("${db.test.nombre}")
	public String cDB_TEST_NOMBRE;
	
	@Value("${db.test.jndi}")
	public String cDB_TEST_JNDI;
	
	@Value("${db.test.timeout.conexion}")
	public Integer cDB_TEST_TIMEOUT_CONEXION;
	
	@Value("${db.test.timeout.consulta}")
	public Integer cDB_TEST_TIMEOUT_CONSULTA;
	
	@Value("${db.test.owner}")
	public String cDB_TEST_OWNER;
	
	@Value("${db.test.pkg.mantenimiento.nombre}")
	public String cDB_TEST_PKG_MANTENIMIENTO_NOMBRE;
		
	@Value("${db.test.sp.lst.persona.nombre}")
	public String cDB_TEST_SP_LST_PERSONA_NOMBRE;
	
	@Value("${db.test.sp.lst.persona.type.nombre}")
	public String cDB_TEST_SP_LST_PERSONA_TYPE_NOMBRE;	
	
	@Value("${db.test.sp.mnt.persona.nombre}")
	public String cDB_TEST_SP_MNT_PERSONA_NOMBRE;
	
	@Value("${db.test.type.persona.nombre}")
	public String cDB_TEST_TYPE_PERSONA_NOMBRE;
	
	@Value("${db.test.type.lista.persona.nombre}")
	public String cDB_TEST_TYPE_LISTA_PERSONA_NOMBRE;
	
	@Value("${db.test.codigo.exito}")
	public Integer cDB_TEST_CODIGO_EXITO;
}
