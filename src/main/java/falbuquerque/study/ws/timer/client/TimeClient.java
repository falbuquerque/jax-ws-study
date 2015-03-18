package falbuquerque.study.ws.timer.client;

import java.net.MalformedURLException;

import falbuquerque.study.ws.timer.client.generated.ITimeServer;
import falbuquerque.study.ws.timer.client.generated.TimeServerService;

public class TimeClient {

    public static void main(String[] args) throws MalformedURLException {
        final TimeServerService service = new TimeServerService();
        final ITimeServer timeServer = service.getTimeServerSOAPImplPort();
        
        System.out.println(timeServer.timeString("Hi!"));
        System.out.println(timeServer.timeElapsed());
        timeServer.acceptInput("Hi!");
    }
    
}
