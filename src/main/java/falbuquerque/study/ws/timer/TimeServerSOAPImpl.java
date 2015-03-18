package falbuquerque.study.ws.timer;

import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface = "falbuquerque.study.ws.timer.TimeServer", serviceName = "TimeServerService")
public class TimeServerSOAPImpl implements TimeServer {

    @Override
    public String getTimeAsString(final String msg) {
        return msg + " at " + new Date();
    }
    
    @Override
    public long getTimeAsElapsed() {
        return new Date().getTime();
    }

    @Override
    public void acceptInput(final String msg) {
        System.out.println(msg);
    }
    
}
