package falbuquerque.study.ws.rabbit.client;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import falbuquerque.study.ws.rabbit.client.handler.ArgHandler;
import falbuquerque.study.ws.rabbit.client.handler.UUIDHandler;

public class ClientHandlerResolver implements HandlerResolver {

    @SuppressWarnings("rawtypes")
    @Override
    public List<Handler> getHandlerChain(final PortInfo portInfo) {
        return Arrays.asList(new UUIDHandler(), new ArgHandler());
    }

}
