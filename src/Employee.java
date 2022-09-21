import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String surname;
    private int age;
    private String workplace;
    private String job;

    public Employee(String name, String surname, int age, String workplace, String job) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workplace = workplace;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", job='" + job + '\'';
    }
}
