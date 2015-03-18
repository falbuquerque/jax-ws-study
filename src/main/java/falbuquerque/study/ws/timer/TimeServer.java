package falbuquerque.study.ws.timer;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface TimeServer {

    @WebMethod
    @WebResult(partName = "time_response")
    String getTimeAsString();

    @WebMethod
    @WebResult(partName = "time_response")
    long getTimeAsElapsed();
}
