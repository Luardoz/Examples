package pe.com.ubicuo.eai.ebs.services.springtypebdws.dao.mapper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.SqlReturnType;

import pe.com.ubicuo.eai.ebs.services.springtypebdws.dao.struct.SQLPersonaStruct;

public class PersonaTypeMapper implements SqlReturnType{
	
	@Override
	public Object getTypeValue(CallableStatement cs,
            int paramIndex, int sqlType, String typeName) throws SQLException {
		Connection connection = cs.getConnection();
        Map<String, Class<?>> typeMap = connection.getTypeMap();
        typeMap.put("PERSON_TYPE", SQLPersonaStruct.class);
        return cs.getObject(paramIndex);
	}

}
