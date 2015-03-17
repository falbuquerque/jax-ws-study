package falbuquerque.study.ws.teams;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class TeamsRepository {

    private final Map<String, Team> teams = new HashMap<>(1);

    TeamsRepository() {
        fill();
    }

    Team findByName(final String name) {
        return teams.get(name);
    }

    Collection<Team> findAll() {
        return teams.values();
    }

    private final void fill() {
        final Player chico = new Player("Leonard Marx", "Chico");
        final Player groucho = new Player("Julius Marx", "Groucho");
        final Player harpo = new Player("Adolph Marx", "Harpo");
        final Team marxBrothers = new Team("Marx Brothers", chico, groucho, harpo);

        teams.put(marxBrothers.getName(), marxBrothers);
    }

}
