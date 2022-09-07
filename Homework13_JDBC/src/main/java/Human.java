public class Human {
    private int id;
    private String name;
    private String lastName;
    private String patronymic;
    private String city;
    private String street;
    private String house;
    private String flat;
    private String numberpassport;

    public Human(String name, String lastName, String patronymic, String city, String street, String house, String flat, String numberpassport) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.numberpassport = numberpassport;

    }

    public Human(int id, String name, String lastName, String patronymic, String city, String street, String house, String flat, String numberpassport) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.numberpassport = numberpassport;
    }

    public Human() {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getNumberpassport() {
        return numberpassport;
    }

    public void setNumberPassport(String numberpassport) {
        this.numberpassport = numberpassport;
    }

    @Override
    public String toString() {
        return
                "id " + id + "|" +
                        " name " + name + "|" +
                        " lastName " + lastName + "|" +
                        " patronymic " + patronymic + "|" +
                        " city " + city + "|" +
                        " street " + street + "|" +
                        " house " + house + "|" +
                        " flat " + flat + "|" +
                        " numberpassport " + numberpassport + "|" + "\n"
                ;
    }
}
