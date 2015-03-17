package falbuquerque.study.ws.teams;

public class Team {

    private String name;
    private Player[] players;

    public Team() {
        super();
    }

    Team(final String name, final Player... players) {
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

}
