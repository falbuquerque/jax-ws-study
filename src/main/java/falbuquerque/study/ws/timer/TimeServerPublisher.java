package falbuquerque.study.ws.timer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.ws.Endpoint;

import falbuquerque.study.ws.teams.TeamsSOAPImpl;

class TimeServerPublisher {

    private static final ExecutorService executor = Executors.newWorkStealingPool();
    
    public static void main(String[] args) {
        final Endpoint endpoint = Endpoint.create(new TeamsSOAPImpl());
        endpoint.setExecutor(executor);
        endpoint.publish("http://127.0.0.1:9877/ts");
    }
    
}
