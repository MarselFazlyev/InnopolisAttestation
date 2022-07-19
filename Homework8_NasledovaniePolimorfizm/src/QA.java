public class QA extends Worker {
    private final String motto;

    public QA(String name, String surname, String proffesion, String motto) {
        super(name, surname, proffesion);
        this.motto = motto;
    }

    @Override
    public void goToWork() {
        System.out.printf("Hi,my name is %s,last name - %s ,my proffesion is %s. \nour motto?: %s\n",
                this.name, this.surname, this.proffesion, this.motto);
    }

    @Override
    public void goToVacation(int days) {
        System.out.printf("Will be testing  all world around me during %d days ",days);
        System.out.println();
    }

    @Override
    public String toString() {
        return "\nname: " + name +
                "\nsurname: " + surname +
                "\nproffesion: " + proffesion +
                "\nmotto: " + motto;
    }
}

