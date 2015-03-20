package falbuquerque.study.ws.rabbit.handler;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

public class UUIDValidator implements SOAPHandler<SOAPMessageContext> {

    private static final int uuidVariant = 2; // layout
    private static final int uuidVersion = 4; // version

    @Override
    public boolean handleMessage(final SOAPMessageContext context) {
        final Boolean messageOutgoing = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if ((messageOutgoing != null) && !messageOutgoing) {
            final SOAPMessage message = context.getMessage();

            try {
                final SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
                final SOAPHeader header = envelope.getHeader();

                if (header == null) {
                    generateSOAPFault(message, "No message header");
                }

                @SuppressWarnings("unchecked")
                final Iterator<Node> iterator = header.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);

                if ((iterator == null) || !iterator.hasNext()) {
                    generateSOAPFault(message, "No header block for next actor");
                }

                final Node next = iterator.next();
                final String value = (next == null) ? null : next.getValue();

                if (value == null) {
                    generateSOAPFault(message, "No UUID in header block");
                }

                final UUID uuid = UUID.fromString(value.trim());

                if (uuid.variant() != uuidVariant || uuid.version() != uuidVersion) {
                    generateSOAPFault(message, "Bad UUID variant or version");
                }

            } catch (final SOAPException e) {
                e.printStackTrace();
            }

        }

        return true;
    }

    private void generateSOAPFault(final SOAPMessage soapMessage, final String message) {

        try {
            final SOAPBody body = soapMessage.getSOAPPart().getEnvelope().getBody();
            final SOAPFault fault = body.addFault();
            fault.setFaultString(message);
            throw new SOAPFaultException(fault);
        } catch (final SOAPException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean handleFault(final SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(final MessageContext context) {
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

}
