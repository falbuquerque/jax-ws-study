
package falbuquerque.study.ws.timer.client.generated;

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
@WebServiceClient(name = "TimeServerService", targetNamespace = "http://timer.ws.study.falbuquerque/", wsdlLocation = "http://127.0.0.1:9877/ts?wsdl")
public class TimeServerService
    extends Service
{

    private final static URL TIMESERVERSERVICE_WSDL_LOCATION;
    private final static WebServiceException TIMESERVERSERVICE_EXCEPTION;
    private final static QName TIMESERVERSERVICE_QNAME = new QName("http://timer.ws.study.falbuquerque/", "TimeServerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:9877/ts?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TIMESERVERSERVICE_WSDL_LOCATION = url;
        TIMESERVERSERVICE_EXCEPTION = e;
    }

    public TimeServerService() {
        super(__getWsdlLocation(), TIMESERVERSERVICE_QNAME);
    }

    public TimeServerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TIMESERVERSERVICE_QNAME, features);
    }

    public TimeServerService(URL wsdlLocation) {
        super(wsdlLocation, TIMESERVERSERVICE_QNAME);
    }

    public TimeServerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TIMESERVERSERVICE_QNAME, features);
    }

    public TimeServerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TimeServerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ITimeServer
     */
    @WebEndpoint(name = "TimeServerSOAPImplPort")
    public ITimeServer getTimeServerSOAPImplPort() {
        return super.getPort(new QName("http://timer.ws.study.falbuquerque/", "TimeServerSOAPImplPort"), ITimeServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ITimeServer
     */
    @WebEndpoint(name = "TimeServerSOAPImplPort")
    public ITimeServer getTimeServerSOAPImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://timer.ws.study.falbuquerque/", "TimeServerSOAPImplPort"), ITimeServer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TIMESERVERSERVICE_EXCEPTION!= null) {
            throw TIMESERVERSERVICE_EXCEPTION;
        }
        return TIMESERVERSERVICE_WSDL_LOCATION;
    }

}
