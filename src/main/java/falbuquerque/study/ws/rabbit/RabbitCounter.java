package falbuquerque.study.ws.rabbit;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService
@HandlerChain(file = "handler-chain-server.xml")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class RabbitCounter {

    @WebMethod
    public long count(final int initialNumber) throws FibException {

        if (initialNumber < 0) {
            throw new FibException("Neg. arg not allowed", initialNumber + " < 0");
        }

        if (initialNumber <= 1) {
            return (long) initialNumber;

        }

        Long fNLess1 = 1L;
        Long fNLess2 = 0L;
        Long fN = 0L;

        for (int i = 2; i <= initialNumber; i++) {
            fN = fNLess1 + fNLess2;
            fNLess2 = fNLess1;
            fNLess1 = fN;
        }

        return fN;
    }

}
