package attestationOneThreadVersion;

public class User {
    private int id;
    private String name;
    private String surname;
    private int age;
    private boolean hasAJob;

    public User(int id, String name, String surname, int age, boolean hasAJob) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.hasAJob = hasAJob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isHasAJob() {
        return hasAJob;
    }

    public void setHasAJob(boolean hasAJob) {
        this.hasAJob = hasAJob;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + surname + "|" + age + "|" + hasAJob + "\n";
    }
}
