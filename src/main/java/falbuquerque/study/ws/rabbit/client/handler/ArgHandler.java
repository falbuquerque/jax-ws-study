package falbuquerque.study.ws.rabbit.client.handler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import falbuquerque.study.ws.rabbit.client.generated.Count;

public class ArgHandler implements LogicalHandler<LogicalMessageContext> {

    @SuppressWarnings("unchecked")
    @Override
    public boolean handleMessage(final LogicalMessageContext context) {
        final Boolean messageOutgoing = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (messageOutgoing) {
            final LogicalMessage message = context.getMessage();

            try {
                final JAXBContext jaxbContext = JAXBContext.newInstance("falbuquerque.study.ws.rabbit.client.generated");
                final Object payload = message.getPayload(jaxbContext);

                if (payload instanceof JAXBElement) {
                    final Count count = ((JAXBElement<Count>) payload).getValue();
                    final int initialNumber = count.getArg0();

                    if (initialNumber < 0) {
                        count.setArg0(Math.abs(initialNumber));
                        ((JAXBElement<Count>) payload).setValue(count);
                        message.setPayload(payload, jaxbContext);
                    }

                }

            } catch (final JAXBException e) {
                e.printStackTrace();
            }

        }

        return true;
    }

    @Override
    public boolean handleFault(final LogicalMessageContext context) {
        return true;
    }

    @Override
    public void close(final MessageContext context) {
    }

}
