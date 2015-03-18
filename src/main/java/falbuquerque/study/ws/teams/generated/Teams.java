
package falbuquerque.study.ws.teams.generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Teams", targetNamespace = "http://teams.ws.study.falbuquerque/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Teams {


    /**
     * 
     * @param arg0
     * @return
     *     returns falbuquerque.study.ws.teams.generated.Team
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findByName", targetNamespace = "http://teams.ws.study.falbuquerque/", className = "falbuquerque.study.ws.teams.generated.FindByName")
    @ResponseWrapper(localName = "findByNameResponse", targetNamespace = "http://teams.ws.study.falbuquerque/", className = "falbuquerque.study.ws.teams.generated.FindByNameResponse")
    @Action(input = "http://teams.ws.study.falbuquerque/Teams/findByNameRequest", output = "http://teams.ws.study.falbuquerque/Teams/findByNameResponse")
    public Team findByName(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<falbuquerque.study.ws.teams.generated.Team>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://teams.ws.study.falbuquerque/", className = "falbuquerque.study.ws.teams.generated.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://teams.ws.study.falbuquerque/", className = "falbuquerque.study.ws.teams.generated.FindAllResponse")
    @Action(input = "http://teams.ws.study.falbuquerque/Teams/findAllRequest", output = "http://teams.ws.study.falbuquerque/Teams/findAllResponse")
    public List<Team> findAll();

}