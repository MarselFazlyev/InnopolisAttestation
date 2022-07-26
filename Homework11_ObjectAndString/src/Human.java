import java.util.Objects;

public class Human {
    private String name;
    private String lastName;
    private String patronymic;
    private String city;
    private String street;
    private String house;
    private String flat;
    private String numberPassport;

    public Human(String name, String lastName, String patronymic, String city, String street, String house, String flat,
                 String numberPassport) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.numberPassport = numberPassport;
    }

    public void setNumberPassport(String numberPassport) {
        this.numberPassport = numberPassport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return numberPassport.equals(human.numberPassport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberPassport);
    }

    @Override
    public String toString() {
        return lastName + " " + name + " " + patronymic +
                "\nПаспорт:\n" + numberPassport +
                "\nГород " + city + ",ул." + street + ",дом " + house + ",квартира " + flat + "\n";
    }

    public static void main(String[] args) {
        Human human1 = new Human("Вася", "Пупкин", "Олегович", "Джава", "Космонавтов", "1", "3", "1111 222234");
        Human human2 = new Human("Иван", "Иванов", "Валентинович", "Питон", "Функционалов", "2", "3", "1111 00000");
        System.out.println(human1);
        human2.numberPassport = human1.numberPassport;
        System.out.printf("Сравниваем  два объекта с одинаковыми значениями паспортов: %b\n", human1.equals(human2));
        human2.setNumberPassport("9999 88888");
        System.out.printf("Сравниваем  два объекта с разными  значениями паспортов: %b", human1.equals(human2));
    }


}
