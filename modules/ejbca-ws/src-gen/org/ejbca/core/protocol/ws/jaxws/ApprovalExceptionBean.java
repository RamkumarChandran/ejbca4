
package org.ejbca.core.protocol.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.ejbca.core.ErrorCode;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1.6
 * 
 */
@XmlRootElement(name = "ApprovalException", namespace = "http://ws.protocol.core.ejbca.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApprovalException", namespace = "http://ws.protocol.core.ejbca.org/", propOrder = {
    "errorCode",
    "message"
})
public class ApprovalExceptionBean {

    private ErrorCode errorCode;
    private String message;

    /**
     * 
     * @return
     *     returns ErrorCode
     */
    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    /**
     * 
     * @param errorCode
     *     the value for the errorCode property
     */
    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 
     * @param message
     *     the value for the message property
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
