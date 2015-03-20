package falbuquerque.study.ws.rabbit;

public class FibException extends Exception {

    private static final long serialVersionUID = -1162180150856391845L;
    
    private final String details;
    
    public FibException(final String message, final String details) {
        super(message);
        this.details = details;
    }

    public String getFaultInfo() {
        return details;
    }
    
}
