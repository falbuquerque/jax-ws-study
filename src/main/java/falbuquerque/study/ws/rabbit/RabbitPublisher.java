package falbuquerque.study.ws.rabbit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.ws.Endpoint;

public class RabbitPublisher {

    private static final ExecutorService executor = Executors.newWorkStealingPool();
    
    public static void main(String[] args) {
        final Endpoint endpoint = Endpoint.create(new RabbitCounter());
        endpoint.setExecutor(executor);
        endpoint.publish("http://127.0.0.1:9877/rabbit");
    }
    
}
