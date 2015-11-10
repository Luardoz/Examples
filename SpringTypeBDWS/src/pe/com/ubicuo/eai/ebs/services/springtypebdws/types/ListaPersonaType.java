
package pe.com.ubicuo.eai.ebs.services.springtypebdws.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaPersonaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaPersonaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="persona" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="idpersona" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="estadoCivil" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sexo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaPersonaType", propOrder = {
    "persona"
})
public class ListaPersonaType {

    @XmlElement(required = true)
    protected List<ListaPersonaType.Persona> persona;

    /**
     * Gets the value of the persona property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the persona property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersona().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaPersonaType.Persona }
     * 
     * 
     */
    public List<ListaPersonaType.Persona> getPersona() {
        if (persona == null) {
            persona = new ArrayList<ListaPersonaType.Persona>();
        }
        return this.persona;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="idpersona" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="fechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="estadoCivil" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="sexo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "idpersona",
        "nombre",
        "apellido",
        "fechaNacimiento",
        "telefono",
        "email",
        "estadoCivil",
        "sexo"
    })
    public static class Persona {

        @XmlElement(required = true)
        protected String idpersona;
        @XmlElement(required = true)
        protected String nombre;
        @XmlElement(required = true)
        protected String apellido;
        @XmlElement(required = true)
        protected String fechaNacimiento;
        @XmlElement(required = true)
        protected String telefono;
        @XmlElement(required = true)
        protected String email;
        @XmlElement(required = true)
        protected String estadoCivil;
        @XmlElement(required = true)
        protected String sexo;

        /**
         * Obtiene el valor de la propiedad idpersona.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdpersona() {
            return idpersona;
        }

        /**
         * Define el valor de la propiedad idpersona.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdpersona(String value) {
            this.idpersona = value;
        }

        /**
         * Obtiene el valor de la propiedad nombre.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Define el valor de la propiedad nombre.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombre(String value) {
            this.nombre = value;
        }

        /**
         * Obtiene el valor de la propiedad apellido.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApellido() {
            return apellido;
        }

        /**
         * Define el valor de la propiedad apellido.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApellido(String value) {
            this.apellido = value;
        }

        /**
         * Obtiene el valor de la propiedad fechaNacimiento.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaNacimiento() {
            return fechaNacimiento;
        }

        /**
         * Define el valor de la propiedad fechaNacimiento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaNacimiento(String value) {
            this.fechaNacimiento = value;
        }

        /**
         * Obtiene el valor de la propiedad telefono.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTelefono() {
            return telefono;
        }

        /**
         * Define el valor de la propiedad telefono.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTelefono(String value) {
            this.telefono = value;
        }

        /**
         * Obtiene el valor de la propiedad email.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmail() {
            return email;
        }

        /**
         * Define el valor de la propiedad email.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEmail(String value) {
            this.email = value;
        }

        /**
         * Obtiene el valor de la propiedad estadoCivil.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEstadoCivil() {
            return estadoCivil;
        }

        /**
         * Define el valor de la propiedad estadoCivil.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEstadoCivil(String value) {
            this.estadoCivil = value;
        }

        /**
         * Obtiene el valor de la propiedad sexo.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSexo() {
            return sexo;
        }

        /**
         * Define el valor de la propiedad sexo.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSexo(String value) {
            this.sexo = value;
        }

    }

}
