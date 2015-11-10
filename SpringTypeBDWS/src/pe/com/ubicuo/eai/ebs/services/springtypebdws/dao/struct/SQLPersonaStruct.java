package pe.com.ubicuo.eai.ebs.services.springtypebdws.dao.struct;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

import pe.com.ubicuo.eai.ebs.services.springtypebdws.bean.PersonaBean;

public class SQLPersonaStruct extends PersonaBean implements SQLData{

	@Override
	public String getSQLTypeName() throws SQLException {
		return "PERSON_TYPE";
	}
	
	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		setIdpersona(Long.valueOf(stream.readLong()));
		setNombre(stream.readString());
		setApellido(stream.readString());
		setFechaNac(stream.readString());
		setTelefono(stream.readString());
		setEmail(stream.readString());
		setEstadoCivil(stream.readString());
		setSexo(stream.readString());
	}
	
	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		stream.writeLong(getIdpersona().longValue());
		stream.writeString(getNombre());
		stream.writeString(getApellido());
		stream.writeString(getFechaNac());
		stream.writeString(getTelefono());
		stream.writeString(getEmail());
		stream.writeString(getEstadoCivil());
		stream.writeString(getSexo());
	}

}
