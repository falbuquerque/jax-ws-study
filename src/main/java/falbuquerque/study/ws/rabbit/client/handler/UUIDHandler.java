package falbuquerque.study.ws.rabbit.client.handler;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class UUIDHandler implements SOAPHandler<SOAPMessageContext> {

    private final Logger logger = Logger.getLogger("ClientSideLogger");

    @Override
    public boolean handleMessage(final SOAPMessageContext context) {
        logger.info("message");

        final Boolean messageOutgoing = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if ((messageOutgoing != null) && messageOutgoing) {

            try {
                final SOAPMessage message = context.getMessage();
                final SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
                final SOAPHeader header = (envelope.getHeader() == null) ? envelope.addHeader() : envelope.getHeader();

                final QName uuidHeader = new QName("http://ws.handler.study.falbuquerque/", "uuid");
                final SOAPHeaderElement uuidHeaderElement = header.addHeaderElement(uuidHeader);
                uuidHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
                uuidHeaderElement.setMustUnderstand(true);
                uuidHeaderElement.addTextNode(UUID.randomUUID().toString());

                // message.saveChanges(); // apparently unnecessary, even when writeTo is not called
                message.writeTo(System.out);
            } catch (final SOAPException | IOException e) {
                e.printStackTrace();
            }

        }

        return true;
    }

    @Override
    public boolean handleFault(final SOAPMessageContext context) {
        logger.info("fault");

        try {
            context.getMessage().writeTo(System.out);
        } catch (final SOAPException | IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void close(final MessageContext context) {
        logger.info("close");
    }

    @Override
    public Set<QName> getHeaders() {
        logger.info("headers");
        return null;
    }

}
