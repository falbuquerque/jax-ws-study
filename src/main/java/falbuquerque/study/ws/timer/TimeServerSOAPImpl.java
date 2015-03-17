package falbuquerque.study.ws.timer;

import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface = "falbuquerque.study.ws.timer.TimeServer")
public class TimeServerSOAPImpl implements TimeServer {

    public String getTimeAsString() {
        return new Date().toString();
    }

    public long getTimeAsElapsed() {
        return new Date().getTime();
    }
    
}
