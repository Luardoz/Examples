package pe.com.ubicuo.eai.ebs.services.springtypebdws.dao.mapper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlReturnType;

import pe.com.ubicuo.eai.ebs.services.springtypebdws.bean.PersonaBean;

public class PersonaMapper implements SqlReturnType{

	private final Logger logger = Logger.getLogger( this.getClass().getName() );
	
	@SuppressWarnings( "rawtypes" )
	private RowMapper rowMapper = new RowMapper<PersonaBean>(){

			public PersonaBean mapRow( ResultSet rs, int numeroFila ) throws SQLException{

				PersonaBean bean = new PersonaBean();
				bean.setApellido(rs.getString("apellido"));
				bean.setEmail(rs.getString("email"));
				bean.setEstadoCivil(rs.getString("estadocivil"));
				bean.setFechaNac(rs.getString("fechanac"));
				bean.setIdpersona(rs.getLong("idpersona"));
				bean.setNombre(rs.getString("nombre"));
				bean.setSexo(rs.getString("sexo"));
				bean.setTelefono(rs.getString("telefono"));
				
				return bean;
				
			   }
			};
	
	@Override
	@SuppressWarnings( {"rawtypes","unchecked"} )
	public Object getTypeValue(CallableStatement cs, int ix, int sqlType, String typeName) throws SQLException {
		ResultSet rs = null;
		List lista = null;

		try{
			rs = (ResultSet)cs.getObject( ix );
			lista = new ArrayList();

			for( int i = 0; rs.next(); i++ ){
				lista.add( rowMapper.mapRow( rs, i ) );
			}

			return lista;
		}
		catch( SQLException e ){
			logger.info( "ERROR [SQLException]: " + e.getMessage() );

			if( ( e.getMessage() != null ) && ( e.getMessage().startsWith( "Cursor is closed" ) ) ){
				logger.info( "[Cursor is closed]: " );

				return new ArrayList();
			}
			else{
				throw e;
			}
		}
		finally{
			if( rs != null ){
				rs.close();
			}
		}
	}

}
