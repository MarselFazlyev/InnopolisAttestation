public class Main {
    public static void main(String[] args) {

        UsersRepozitoryFileImpl repozitory = new UsersRepozitoryFileImpl("allUsers.txt");

        repozitory.update(new User(23, "AFF", "FWEF", 67, true));

        // TODO: 21.08.2022 оптимизировать метод findById
        System.out.println(repozitory.findById(22));

        repozitory.create(new User(12, "safaf", "afaf", 12, false));

        repozitory.delete(12);


    }
}
