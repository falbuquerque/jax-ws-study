package falbuquerque.study.ws.echo.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import falbuquerque.study.ws.echo.MapDump;
import falbuquerque.study.ws.echo.client.generated.Echo;
import falbuquerque.study.ws.echo.client.generated.EchoService;

public class EchoClient {

    public static void main(String[] args) {
        final EchoService service = new EchoService();
        final Echo port = service.getEchoPort();
        
        final Map<String, List<String>> myHeader = new HashMap<String, List<String>>(2);
        myHeader.put("Accept-Encoding", Collections.singletonList("gzip"));
        myHeader.put("Greeting", Collections.singletonList("Hello, world!"));
        
        final Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:9877/echo/echo");
        requestContext.put(BindingProvider.SOAPACTION_URI_PROPERTY, "echo");
        requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, myHeader);
        
        MapDump.dump(requestContext, "c_req: ");
        System.out.println("\n\nRequest above, response below\n\n");
        System.out.println(port.echo("Have a nice day :)\n\n"));
        
        final Map<String, Object> responseContext = ((BindingProvider) port).getResponseContext();
        MapDump.dump(responseContext, "c_res: ");
    }
    
}
