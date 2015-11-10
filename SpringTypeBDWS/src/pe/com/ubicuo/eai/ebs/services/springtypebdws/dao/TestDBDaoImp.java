package pe.com.ubicuo.eai.ebs.services.springtypebdws.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.data.jdbc.support.oracle.BeanPropertyStructMapper;
import org.springframework.data.jdbc.support.oracle.SqlStructArrayValue;
import org.springframework.data.jdbc.support.oracle.StructMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import pe.com.ubicuo.eai.ebs.services.springtypebdws.bean.PersonaBean;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.bean.RespuestaBean;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.dao.mapper.PersonaMapper;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.dao.mapper.PersonaTypeMapper;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.dao.struct.SQLPersonaStruct;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.util.JAXBUtil;
import pe.com.ubicuo.eai.ebs.services.springtypebdws.util.PropertiesExterno;

@Repository
public class TestDBDaoImp implements TestDBDao {

	@Autowired
	DataSource testDB;
	
	@Autowired
	private PropertiesExterno properties;
	
	private final Logger logger = Logger.getLogger( this.getClass().getName() );
	
	@Override
	public RespuestaBean insertarPersonas(String cadenaTrazabilidad, PersonaBean[] personas) {
		
		String cadenaTraza = cadenaTrazabilidad + "[insertarPersonas]";
		RespuestaBean respuesta = new RespuestaBean();
		logger.info(cadenaTraza + "<---------- Inicio metodo insertarPersonas ---------->");				
		
		try{
			logger.info(cadenaTraza + "Consultando BD: " + properties.cDB_TEST_NOMBRE);
			logger.info(cadenaTraza + "JNDI destino: " + properties.cDB_TEST_JNDI);
			logger.info(cadenaTraza + "Tiempo límite de conexión: " + properties.cDB_TEST_TIMEOUT_CONEXION);			
			logger.info(cadenaTraza + "Owner de BD: " + properties.cDB_TEST_OWNER);
			logger.info(cadenaTraza + "Paquete: " + properties.cDB_TEST_PKG_MANTENIMIENTO_NOMBRE);
			logger.info(cadenaTraza + "Procedimiento almacenado: " + properties.cDB_TEST_SP_MNT_PERSONA_NOMBRE);
			logger.info(cadenaTraza + "[INPUT]: PERSONAS");
			for(PersonaBean persona: personas)
				logger.info(cadenaTraza + JAXBUtil.anyObjectToXmlText(persona));			
			
			testDB.setLoginTimeout(properties.cDB_TEST_TIMEOUT_CONEXION);
			
			SimpleJdbcCall objSimpleJdbcCall = new SimpleJdbcCall(testDB)
											.withoutProcedureColumnMetaDataAccess()											
											.withSchemaName(properties.cDB_TEST_OWNER)
											.withCatalogName(properties.cDB_TEST_PKG_MANTENIMIENTO_NOMBRE)
											.withProcedureName(properties.cDB_TEST_SP_MNT_PERSONA_NOMBRE)
											.declareParameters(
														new SqlParameter("PERSONAS", OracleTypes.ARRAY, "PERSONS"),
														new SqlOutParameter("COD_RESP", OracleTypes.INTEGER),
														new SqlOutParameter("MSJ_RESP", OracleTypes.VARCHAR));
			
			StructMapper<PersonaBean> mapper = new BeanPropertyStructMapper<PersonaBean>(PersonaBean.class);
			
			SqlParameterSource objParametrosIn = new MapSqlParameterSource()
											.addValue("PERSONAS", new SqlStructArrayValue<PersonaBean>(personas, mapper,properties.cDB_TEST_OWNER+".PERSON_TYPE", properties.cDB_TEST_OWNER+".PERSONS"));			
			
			Map<String, Object> out = objSimpleJdbcCall.execute(objParametrosIn);
			
			respuesta.setCodResp((Integer) out.get("COD_RESP"));
			respuesta.setMsjResp((String) out.get("MSJ_RESP"));
			
		}catch(NestedRuntimeException e){
			logger.error(cadenaTraza + "Error: " + e.getMessage(), e);
			respuesta.setCodResp(1);
			respuesta.setMsjResp(e.getMessage());
		}catch(Throwable e){
			logger.error(cadenaTraza + "Error: " + e.getMessage(), e);
			respuesta.setCodResp(2);
			respuesta.setMsjResp(e.toString());
		}finally{
			logger.info(cadenaTraza + "<---------- Fin metodo insertarPersonas ---------->");
		}
		return respuesta;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PersonaBean> consultarPersonas(String cadenaTrazabilidad) {

		String cadenaTraza = cadenaTrazabilidad + "[consultarPersonas]";
		logger.info(cadenaTraza + "<---------- Inicio metodo consultarPersonas ---------->");
		
		List<PersonaBean> personas = new ArrayList<PersonaBean>();
		try{
			logger.info(cadenaTraza + "Consultando BD: " + properties.cDB_TEST_NOMBRE);
			logger.info(cadenaTraza + "JNDI destino: " + properties.cDB_TEST_JNDI);
			logger.info(cadenaTraza + "Tiempo límite de conexión: " + properties.cDB_TEST_TIMEOUT_CONEXION);
			logger.info(cadenaTraza + "Tiempo límite de consulta: " + properties.cDB_TEST_TIMEOUT_CONSULTA);
			logger.info(cadenaTraza + "Owner de BD: " + properties.cDB_TEST_OWNER);
			logger.info(cadenaTraza + "Paquete: " + properties.cDB_TEST_PKG_MANTENIMIENTO_NOMBRE);
			logger.info(cadenaTraza + "Procedimiento almacenado: " + properties.cDB_TEST_SP_LST_PERSONA_NOMBRE);
			logger.info(cadenaTraza + "[INPUT]: Sin Input");
			
			testDB.setLoginTimeout(properties.cDB_TEST_TIMEOUT_CONEXION);
			
			JdbcTemplate objJdbcTemplate = new JdbcTemplate(testDB);
			objJdbcTemplate.setQueryTimeout(properties.cDB_TEST_TIMEOUT_CONSULTA);
			
			SimpleJdbcCall objSimpleJdbcCall = new SimpleJdbcCall(objJdbcTemplate)
											.withoutProcedureColumnMetaDataAccess()											
											.withSchemaName(properties.cDB_TEST_OWNER)
											.withCatalogName(properties.cDB_TEST_PKG_MANTENIMIENTO_NOMBRE)
											.withProcedureName(properties.cDB_TEST_SP_LST_PERSONA_NOMBRE)
											.declareParameters(
														new SqlOutParameter("P_CURSOR", OracleTypes.CURSOR,null,new PersonaMapper()));
			
			Map<String, Object> out = objSimpleJdbcCall.execute();
			
			personas = (List<PersonaBean>) out.get("P_CURSOR");
			
		}catch(NestedRuntimeException e){
			logger.error(cadenaTraza + "Error: " + e.getMessage(), e);
		}catch(Exception e){
			logger.error(cadenaTraza + "Error: " + e.getMessage(), e);
		}finally{
			logger.info(cadenaTraza + "<---------- Fin metodo consultarPersonas ---------->");
		}
		return personas;
	}
	
	@Override
	public PersonaBean[] consultarPersonasType(String cadenaTrazabilidad){
		
		String cadenaTraza = cadenaTrazabilidad + "[consultarPersonasType]";
		logger.info(cadenaTraza + "<---------- Inicio metodo consultarPersonasType ---------->");
		
		PersonaBean[] personas = null;
		try{
			logger.info(cadenaTraza + "Consultando BD: " + properties.cDB_TEST_NOMBRE);
			logger.info(cadenaTraza + "JNDI destino: " + properties.cDB_TEST_JNDI);
			logger.info(cadenaTraza + "Tiempo límite de conexión: " + properties.cDB_TEST_TIMEOUT_CONEXION);
			logger.info(cadenaTraza + "Tiempo límite de consulta: " + properties.cDB_TEST_TIMEOUT_CONSULTA);
			logger.info(cadenaTraza + "Owner de BD: " + properties.cDB_TEST_OWNER);
			logger.info(cadenaTraza + "Paquete: " + properties.cDB_TEST_PKG_MANTENIMIENTO_NOMBRE);
			logger.info(cadenaTraza + "Procedimiento almacenado: " + properties.cDB_TEST_SP_LST_PERSONA_TYPE_NOMBRE);
			logger.info(cadenaTraza + "[INPUT]: Sin Input");
			
			testDB.setLoginTimeout(properties.cDB_TEST_TIMEOUT_CONEXION);
			
			JdbcTemplate objJdbcTemplate = new JdbcTemplate(testDB);
			objJdbcTemplate.setQueryTimeout(properties.cDB_TEST_TIMEOUT_CONSULTA);
			
			SimpleJdbcCall objSimpleJdbcCall = new SimpleJdbcCall(objJdbcTemplate)
											.withoutProcedureColumnMetaDataAccess()											
											.withSchemaName(properties.cDB_TEST_OWNER)
											.withCatalogName(properties.cDB_TEST_PKG_MANTENIMIENTO_NOMBRE)
											.withProcedureName(properties.cDB_TEST_SP_LST_PERSONA_TYPE_NOMBRE)
											.declareParameters(
														new SqlOutParameter("PERSONAS", OracleTypes.ARRAY,"PERSONS", new PersonaTypeMapper()										                
																));
			
			Map<String, Object> out = objSimpleJdbcCall.execute();
			
			Object[] resultArray = (Object[]) ((ARRAY) out.get("PERSONAS")).getArray();
 
            personas = Arrays.copyOf(resultArray, resultArray.length, SQLPersonaStruct[].class);

		}catch(NestedRuntimeException e){
			logger.error(cadenaTraza + "Error: " + e.getMessage(), e);
		}catch(Exception e){
			logger.error(cadenaTraza + "Error: " + e.getMessage(), e);
		}finally{
			logger.info(cadenaTraza + "<---------- Fin metodo consultarPersonasType ---------->");
		}
		return personas;
	}

}
