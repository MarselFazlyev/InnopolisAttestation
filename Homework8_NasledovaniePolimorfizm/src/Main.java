public class Main {
    public static void main(String[] args) {
        Worker developer = new Developer("Марсель","Фазлыев", "Developer", "JavaDevelopers are Best!!!");
        Worker QAengineer = new QA("Джон","Джонов", "QAengineer", "JUnit top!!!");
        Worker devops = new DevOps("Майкл","Джексон", "DevOps", "iiiiiihaaaaa");
        Worker projectManager  = new ProjectManager("Сергей","Пушкин","ProjectManager","PM and only PM!");

        Worker[] workers = {developer,devops,QAengineer,projectManager};
        for (Worker worker:workers) {
            System.out.printf("****************%s.goToWork ****************\n",worker.proffesion);
            worker.goToWork();
            System.out.println("**********************************************************");
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (Worker worker:workers) {
            System.out.printf("****************%s.goToVacation ****************\n",worker.proffesion);
            worker.goToVacation(6);
            worker.goToVacation(14);
            System.out.println("**********************************************************");
            System.out.println();
        }




    }
}
