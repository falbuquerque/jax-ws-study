package falbuquerque.study.ws.jaxb;

public class Person {

    private String name;
    private String gender;
    private Short age;

    public Person() {
        super();
    }

    Person(final String name, final String gender, final Short age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(final Short age) {
        this.age = age;
    }

}
