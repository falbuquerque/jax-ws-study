package falbuquerque.study.ws.teams;

import java.util.Collection;

import javax.jws.WebService;

@WebService(endpointInterface = "falbuquerque.study.ws.teams.Teams")
public class TeamsSOAPImpl implements Teams {

    private final TeamsRepository repository = new TeamsRepository();
    
    @Override
    public Team findByName(final String name) {
        return repository.findByName(name);
    }

    @Override
    public Collection<Team> findAll() {
        return repository.findAll();
    }

}
