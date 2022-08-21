import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        UsersRepozitoryFileImpl repozitory = new UsersRepozitoryFileImpl("allUsers.txt");
        System.out.println(UsersRepozitoryFileImpl.generateUsers());
        


    }


}
