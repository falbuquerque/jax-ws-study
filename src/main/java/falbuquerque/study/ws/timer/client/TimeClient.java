package falbuquerque.study.ws.timer.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import falbuquerque.study.ws.timer.TimeServer;

public class TimeClient {

    public static void main(String[] args) throws MalformedURLException {
        System.setProperty("sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        
        final URL wsdl = new URL("http://127.0.0.1:9877/ts?wsdl");
        final QName implName = new QName("http://timer.ws.study.falbuquerque/", "TimeServerSOAPImplService");
        final Service service = Service.create(wsdl, implName);
        final TimeServer timeServer = service.getPort(TimeServer.class);
        
        System.out.println(timeServer.getTimeAsString());
        System.out.println(timeServer.getTimeAsElapsed());
    }
    
}
