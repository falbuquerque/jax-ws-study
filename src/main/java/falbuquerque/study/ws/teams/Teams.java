package falbuquerque.study.ws.teams;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Teams {
    
    @WebMethod
    Team findByName(String name);
    
    @WebMethod
    Collection<Team> findAll();
}
