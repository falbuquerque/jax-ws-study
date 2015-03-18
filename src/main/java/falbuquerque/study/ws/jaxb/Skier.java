package falbuquerque.study.ws.jaxb;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AmericanSkier")
public class Skier {

    private Person person;
    private String nationalTeam;
    private Collection<String> achievements;

    public Skier() {
        super();
    }

    Skier(final Person person, final String nationalTeam, final Collection<String> achievements) {
        this.person = person;
        this.nationalTeam = nationalTeam;
        this.achievements = achievements;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }

    public String getNationalTeam() {
        return nationalTeam;
    }

    public void setNationalTeam(final String nationalTeam) {
        this.nationalTeam = nationalTeam;
    }

    public Collection<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(final Collection<String> achievements) {
        this.achievements = achievements;
    }

}
