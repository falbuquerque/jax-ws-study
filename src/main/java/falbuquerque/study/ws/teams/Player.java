package falbuquerque.study.ws.teams;

public class Player {

    private String name;
    private String nick;

    public Player() {
        super();
    }

    Player(final String name, final String nick) {
        this.name = name;
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

}
