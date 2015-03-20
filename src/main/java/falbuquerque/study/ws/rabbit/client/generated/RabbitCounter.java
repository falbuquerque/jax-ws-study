
package falbuquerque.study.ws.rabbit.client.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RabbitCounter", targetNamespace = "http://rabbit.ws.study.falbuquerque/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RabbitCounter {


    /**
     * 
     * @param arg0
     * @return
     *     returns long
     * @throws FibException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "count", targetNamespace = "http://rabbit.ws.study.falbuquerque/", className = "falbuquerque.study.ws.rabbit.client.generated.Count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://rabbit.ws.study.falbuquerque/", className = "falbuquerque.study.ws.rabbit.client.generated.CountResponse")
    @Action(input = "http://rabbit.ws.study.falbuquerque/RabbitCounter/countRequest", output = "http://rabbit.ws.study.falbuquerque/RabbitCounter/countResponse", fault = {
        @FaultAction(className = FibException_Exception.class, value = "http://rabbit.ws.study.falbuquerque/RabbitCounter/count/Fault/FibException")
    })
    public long count(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws FibException_Exception
    ;

}
