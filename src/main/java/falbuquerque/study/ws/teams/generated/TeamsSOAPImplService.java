
package falbuquerque.study.ws.teams.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TeamsSOAPImplService", targetNamespace = "http://teams.ws.study.falbuquerque/", wsdlLocation = "http://127.0.0.1:9877/teams?wsdl")
public class TeamsSOAPImplService
    extends Service
{

    private final static URL TEAMSSOAPIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException TEAMSSOAPIMPLSERVICE_EXCEPTION;
    private final static QName TEAMSSOAPIMPLSERVICE_QNAME = new QName("http://teams.ws.study.falbuquerque/", "TeamsSOAPImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:9877/teams?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TEAMSSOAPIMPLSERVICE_WSDL_LOCATION = url;
        TEAMSSOAPIMPLSERVICE_EXCEPTION = e;
    }

    public TeamsSOAPImplService() {
        super(__getWsdlLocation(), TEAMSSOAPIMPLSERVICE_QNAME);
    }

    public TeamsSOAPImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TEAMSSOAPIMPLSERVICE_QNAME, features);
    }

    public TeamsSOAPImplService(URL wsdlLocation) {
        super(wsdlLocation, TEAMSSOAPIMPLSERVICE_QNAME);
    }

    public TeamsSOAPImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TEAMSSOAPIMPLSERVICE_QNAME, features);
    }

    public TeamsSOAPImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TeamsSOAPImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Teams
     */
    @WebEndpoint(name = "TeamsSOAPImplPort")
    public Teams getTeamsSOAPImplPort() {
        return super.getPort(new QName("http://teams.ws.study.falbuquerque/", "TeamsSOAPImplPort"), Teams.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Teams
     */
    @WebEndpoint(name = "TeamsSOAPImplPort")
    public Teams getTeamsSOAPImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://teams.ws.study.falbuquerque/", "TeamsSOAPImplPort"), Teams.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TEAMSSOAPIMPLSERVICE_EXCEPTION!= null) {
            throw TEAMSSOAPIMPLSERVICE_EXCEPTION;
        }
        return TEAMSSOAPIMPLSERVICE_WSDL_LOCATION;
    }

}
