package falbuquerque.study.ws.rabbit.client;

import java.net.MalformedURLException;

import falbuquerque.study.ws.rabbit.client.generated.FibException_Exception;
import falbuquerque.study.ws.rabbit.client.generated.RabbitCounter;
import falbuquerque.study.ws.rabbit.client.generated.RabbitCounterService;

public class FibClientHR {

    public static void main(String[] args) throws MalformedURLException {
        final RabbitCounterService service = new RabbitCounterService();
        // service.setHandlerResolver(new ClientHandlerResolver());

        final RabbitCounter counter = service.getRabbitCounterPort();

        try {
            System.out.printf("Count: %d%n", counter.count(-1));
        } catch (final FibException_Exception e) {
            e.printStackTrace();
        }

    }

}
