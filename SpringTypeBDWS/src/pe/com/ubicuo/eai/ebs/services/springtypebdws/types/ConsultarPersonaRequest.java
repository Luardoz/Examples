
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
 *         &lt;element name="parametrosAuditRequest" type="{http://ubicuo.com.pe/eai/ebs/services/SpringTypeBDWS/types}parametrosAuditRequestType"/>
 *         &lt;element name="listaRequestOpcional" type="{http://ubicuo.com.pe/eai/ebs/services/SpringTypeBDWS/types}listaParametrosType"/>
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
    "parametrosAuditRequest",
    "listaRequestOpcional"
})
@XmlRootElement(name = "ConsultarPersonaRequest")
public class ConsultarPersonaRequest {

    @XmlElement(required = true)
    protected ParametrosAuditRequestType parametrosAuditRequest;
    @XmlElement(required = true)
    protected ListaParametrosType listaRequestOpcional;

    /**
     * Obtiene el valor de la propiedad parametrosAuditRequest.
     * 
     * @return
     *     possible object is
     *     {@link ParametrosAuditRequestType }
     *     
     */
    public ParametrosAuditRequestType getParametrosAuditRequest() {
        return parametrosAuditRequest;
    }

    /**
     * Define el valor de la propiedad parametrosAuditRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametrosAuditRequestType }
     *     
     */
    public void setParametrosAuditRequest(ParametrosAuditRequestType value) {
        this.parametrosAuditRequest = value;
    }

    /**
     * Obtiene el valor de la propiedad listaRequestOpcional.
     * 
     * @return
     *     possible object is
     *     {@link ListaParametrosType }
     *     
     */
    public ListaParametrosType getListaRequestOpcional() {
        return listaRequestOpcional;
    }

    /**
     * Define el valor de la propiedad listaRequestOpcional.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaParametrosType }
     *     
     */
    public void setListaRequestOpcional(ListaParametrosType value) {
        this.listaRequestOpcional = value;
    }

}
