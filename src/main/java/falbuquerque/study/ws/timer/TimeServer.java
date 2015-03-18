package falbuquerque.study.ws.timer;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(name = "ITimeServer")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface TimeServer {

    @WebMethod(operationName = "time_string")
    @WebResult(name = "ts_out", partName = "time_stringResponse")
    String getTimeAsString(@WebParam(name = "clientMessage", mode = Mode.IN) String msg);

    @WebMethod(operationName = "time_elapsed")
    long getTimeAsElapsed();
    
    @WebMethod
    @Oneway
    void acceptInput(String msg);
}
