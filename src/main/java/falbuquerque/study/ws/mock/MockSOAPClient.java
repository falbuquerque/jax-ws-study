package falbuquerque.study.ws.mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

public class MockSOAPClient {

    public static void main(String[] args) throws SOAPException, IOException {
        new MockSOAPClient().request();
    }

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private ByteArrayInputStream in;
    
    public void request() throws SOAPException, IOException {
        final SOAPMessage message = createSOAPMessage();
        final SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        final SOAPHeader header = envelope.getHeader();
        
        final Name lookupName = createQName(message);
        header.addHeaderElement(lookupName).addTextNode("time_request");
        
        message.writeTo(out);
        
        final SOAPMessage response = processRequest();
        extractContentsAndPrint(response);
    }

    private SOAPMessage processRequest() throws SOAPException, IOException {
        processIncomingSOAP();
        coordinateStreams();
        return createSOAPMessage(in);
    }
    
    private void processIncomingSOAP() throws SOAPException, IOException {
        coordinateStreams();
        
        final SOAPMessage message = createSOAPMessage(in);
        final Name lookupName = createQName(message);
        final SOAPHeader header = message.getSOAPHeader();
        final Node next = (Node) header.getChildElements(lookupName).next();
        final String value = next.getValue();
        
        if (value.toLowerCase().contains("time_request")) {
            final String now = new Date().toString();
            final SOAPBody body = message.getSOAPBody();
            body.addBodyElement(lookupName).addTextNode(now);
            message.saveChanges();
            message.writeTo(out);
        }
        
    }

    private void extractContentsAndPrint(final SOAPMessage message) throws SOAPException {
        final SOAPBody body = message.getSOAPBody();
        final Name lookupName = createQName(message);
        final Node next = (Node) body.getChildElements(lookupName).next();
        System.out.println("Returned: " + next.getValue());
    }
    
    private SOAPMessage createSOAPMessage() throws SOAPException {
        return MessageFactory.newInstance().createMessage();
    }

    private SOAPMessage createSOAPMessage(final InputStream in) throws SOAPException, IOException {
        return MessageFactory.newInstance().createMessage(null, in);
    }

    private Name createQName(final SOAPMessage message) throws SOAPException {
        final SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        return envelope.createName("TimeRequest", "ms", "http://ws.study.falbuquerque");
    }
    
    private void coordinateStreams() {
        in = new ByteArrayInputStream(out.toByteArray());
        out.reset();
    }

}
