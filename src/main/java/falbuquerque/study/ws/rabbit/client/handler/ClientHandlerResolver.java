package falbuquerque.study.ws.rabbit.client.handler;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class ClientHandlerResolver implements HandlerResolver {

    @SuppressWarnings("rawtypes")
    @Override
    public List<Handler> getHandlerChain(final PortInfo portInfo) {
        return Arrays.asList(new UUIDHandler(), new ArgHandler());
    }

}
