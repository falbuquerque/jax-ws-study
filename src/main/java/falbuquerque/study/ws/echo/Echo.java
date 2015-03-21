package falbuquerque.study.ws.echo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
@HandlerChain(file = "handler-chain-echo.xml")
public class Echo {

    private static final ExecutorService executor = Executors.newWorkStealingPool();

    public static void main(String[] args) {
        final Endpoint endpoint = Endpoint.create(new Echo());
        endpoint.setExecutor(executor);
        endpoint.publish("http://127.0.0.1:9877/echo");
    }

    @Resource
    private WebServiceContext context;

    public String echo(final String message) {
        final MessageContext messageContext = context.getMessageContext();
        MapDump.dump(messageContext, "s: ");
        return "Echoing: " + message;
    }

}
