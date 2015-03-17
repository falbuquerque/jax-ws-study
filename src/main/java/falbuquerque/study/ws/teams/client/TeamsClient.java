package falbuquerque.study.ws.teams.client;

import falbuquerque.study.ws.teams.generated.Teams;
import falbuquerque.study.ws.teams.generated.TeamsSOAPImplService;

public class TeamsClient {

    public static void main(String[] args) {
        final TeamsSOAPImplService service = new TeamsSOAPImplService();
        final Teams port = service.getTeamsSOAPImplPort();
        port.findAll().forEach(team -> {
            System.out.println("Team: " + team.getName());
            team.getPlayers().forEach(player -> System.out.println("\tPlayer: " + player.getNick()));
        });
    }
    
}
