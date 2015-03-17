package falbuquerque.study.ws.timer;

import javax.xml.ws.Endpoint;

class TimeServerPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:9877/ts", new TimeServerSOAPImpl());
    }
    
}
