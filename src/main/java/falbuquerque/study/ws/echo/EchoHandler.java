package falbuquerque.study.ws.echo;

import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class EchoHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(final SOAPMessageContext context) {
        final Boolean messageOutgoing = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if ((messageOutgoing != null) && !messageOutgoing) {
            MapDump.dump((Map<?, ?>) context, "h: ");
        }

        return true;
    }

    @Override
    public boolean handleFault(final SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(final MessageContext context) {

    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

}
