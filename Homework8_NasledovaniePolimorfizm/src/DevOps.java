public class DevOps extends Worker {
    private final String motto;

    public DevOps(String name, String surname, String proffesion, String motto) {
        super(name, surname, proffesion);
        this.motto = motto;
    }

    @Override
    public void goToWork() {
        System.out.printf("Hi,my name is %s,last name - %s ,my proffesion is %s. \nAll DevOps ingeneers have a motto!: %s\n",
                this.name, this.surname, this.proffesion, this.motto);
    }

    @Override
    public void goToVacation(int days) {
        if (days<7){
            System.out.printf("Server repair will take just %d days",days);
            System.out.println();
        }else System.out.printf("Dream of any DevOps to have so long vacation of %d days!",days);
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
