public class ProjectManager extends Worker {
    private final String motto;

    public ProjectManager(String name, String surname, String proffesion, String motto) {
        super(name, surname, proffesion);
        this.motto = motto;
    }

    @Override
    public void goToWork() {
        System.out.printf("Hi,my name is %s,last name - %s ,my proffesion is %s.\n Motto of PM: %s\n",
                this.name, this.surname, this.proffesion, this.motto);
    }

    @Override
    public void goToVacation(int days) {
        if (days<7){
            System.out.println("Too little vacation for PM!(");
            System.out.println();
        }else System.out.printf("I will hide, %d days should be enough to PM",days);
    }

    @Override
    public String toString() {
        return "\nname: " + name +
                "\nsurname: " + surname +
                "\nproffesion: " + proffesion +
                "\nmotto: " + motto;
    }
}
