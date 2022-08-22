import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // создание пустого файла (файл может быть из любого источника и не пустым)
        File file = new File("allUsers.txt");
        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // случайное заполнение файла экземплярами  User
        if (isFileEmpty(file)) {
            UsersRepozitoryFileImpl.generateUsers(file);
        }

        // создание экземпляра класса , реализующего интерфейс UsersRepozitoryFile
        UsersRepozitoryFileImpl repozitory = new UsersRepozitoryFileImpl(file);

        //тест имплементированного метода  findById(int id)
        repozitory.findById(2);

        //тестирование имплементированного метода  create(User user)
        repozitory.create(new User(620,"Владимир","Владимиров",234,true));

        //тестирование  имплементированного метода update(User user)
        repozitory.update(new User(1,"Петр","Петров",15,false));

        // тестирование  имплементированного метода delete(User user)
        repozitory.delete(9);
    }

    private static boolean isFileEmpty(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String temp;
            if ((temp = reader.readLine()) != null) return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
