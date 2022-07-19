public  abstract class Worker {
    protected String name;
    protected String surname;
    protected String proffesion;

    public Worker(String name, String surname, String proffesion) {
        this.name = name;
        this.surname = surname;
        this.proffesion = proffesion;
    }

    public abstract void goToWork();
    public abstract void goToVacation(int days);

}
