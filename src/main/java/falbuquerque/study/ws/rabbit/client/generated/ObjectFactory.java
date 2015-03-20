
package falbuquerque.study.ws.rabbit.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the falbuquerque.study.ws.rabbit.client.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Count_QNAME = new QName("http://rabbit.ws.study.falbuquerque/", "count");
    private final static QName _CountResponse_QNAME = new QName("http://rabbit.ws.study.falbuquerque/", "countResponse");
    private final static QName _FibException_QNAME = new QName("http://rabbit.ws.study.falbuquerque/", "FibException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: falbuquerque.study.ws.rabbit.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Count }
     * 
     */
    public Count createCount() {
        return new Count();
    }

    /**
     * Create an instance of {@link CountResponse }
     * 
     */
    public CountResponse createCountResponse() {
        return new CountResponse();
    }

    /**
     * Create an instance of {@link FibException }
     * 
     */
    public FibException createFibException() {
        return new FibException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Count }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rabbit.ws.study.falbuquerque/", name = "count")
    public JAXBElement<Count> createCount(Count value) {
        return new JAXBElement<Count>(_Count_QNAME, Count.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rabbit.ws.study.falbuquerque/", name = "countResponse")
    public JAXBElement<CountResponse> createCountResponse(CountResponse value) {
        return new JAXBElement<CountResponse>(_CountResponse_QNAME, CountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FibException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://rabbit.ws.study.falbuquerque/", name = "FibException")
    public JAXBElement<FibException> createFibException(FibException value) {
        return new JAXBElement<FibException>(_FibException_QNAME, FibException.class, null, value);
    }

}
