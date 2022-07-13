public class Developer extends Worker {
    private final String motto;

    public Developer(String name, String surname, String proffesion, String motto) {
        super(name, surname, proffesion);
        this.motto = motto;
    }

    @Override
    public void goToWork() {
        System.out.printf("Hi,my name is %s,last name - %s ,my proffesion is %s. \nDo you know our motto?: %s\n",
                this.name, this.surname, this.proffesion, this.motto);
    }

    @Override
    public void goToVacation(int days) {
        if (days < 7) {
            System.out.printf("I`m just a trainy, will study to become a good Junior Developer all of %d days!", days);
            System.out.println();
        } else {
            System.out.printf("It will be a long vacation %d long, all the developers drink beer at sea",days);
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "\nname: " + name +
                "\nsurname: " + surname +
                "\nproffesion: " + proffesion +
                "\nmotto: " + motto;
    }
}
