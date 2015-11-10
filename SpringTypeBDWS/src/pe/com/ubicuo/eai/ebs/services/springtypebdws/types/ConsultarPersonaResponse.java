
package pe.com.ubicuo.eai.ebs.services.springtypebdws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="parametrosAuditResponse" type="{http://ubicuo.com.pe/eai/ebs/services/SpringTypeBDWS/types}parametrosAuditResponseType"/>
 *         &lt;element name="fechaOperacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="listaPersona" type="{http://ubicuo.com.pe/eai/ebs/services/SpringTypeBDWS/types}listaPersonaType"/>
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
    "parametrosAuditResponse",
    "fechaOperacion",
    "listaPersona"
})
@XmlRootElement(name = "ConsultarPersonaResponse")
public class ConsultarPersonaResponse {

    @XmlElement(required = true)
    protected ParametrosAuditResponseType parametrosAuditResponse;
    @XmlElement(required = true)
    protected String fechaOperacion;
    @XmlElement(required = true)
    protected ListaPersonaType listaPersona;

    /**
     * Obtiene el valor de la propiedad parametrosAuditResponse.
     * 
     * @return
     *     possible object is
     *     {@link ParametrosAuditResponseType }
     *     
     */
    public ParametrosAuditResponseType getParametrosAuditResponse() {
        return parametrosAuditResponse;
    }

    /**
     * Define el valor de la propiedad parametrosAuditResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametrosAuditResponseType }
     *     
     */
    public void setParametrosAuditResponse(ParametrosAuditResponseType value) {
        this.parametrosAuditResponse = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaOperacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaOperacion() {
        return fechaOperacion;
    }

    /**
     * Define el valor de la propiedad fechaOperacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaOperacion(String value) {
        this.fechaOperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad listaPersona.
     * 
     * @return
     *     possible object is
     *     {@link ListaPersonaType }
     *     
     */
    public ListaPersonaType getListaPersona() {
        return listaPersona;
    }

    /**
     * Define el valor de la propiedad listaPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaPersonaType }
     *     
     */
    public void setListaPersona(ListaPersonaType value) {
        this.listaPersona = value;
    }

}
