package attestationOneThreadVersion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // создание пустого файла (файл может быть из любого источника и не пустым)
        File file = new File("allUsers.txt");
        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // случайное заполнение файла экземплярами  attestationThreadsVersion.User
        if (isFileEmpty(file)) UsersRepozitoryFileImpl.generateUsers(file);

        // создание экземпляра класса , реализующего интерфейс attestationThreadsVersion.UsersRepozitoryFile
        UsersRepozitoryFileImpl repozitory = new UsersRepozitoryFileImpl(file);

        //тестирование имплементированного метода  create(User user)
        System.out.println("Начало работы   метода create()");
        repozitory.create(new User(620, "Владимир", "Владимиров", 234, true));
        System.out.println("Метод create() завершен");
        System.out.println();

        //тестирование  имплементированного метода update(attestationThreadsVersion.User user)
        System.out.println("Начало работы   метода update()");
        repozitory.update(new User(1, "Петр", "Петров", 15, false));
        System.out.println("Метод update() завершен");
        System.out.println();

        // тестирование  имплементированного метода delete(attestationThreadsVersion.User user)
        System.out.println("Начало работы   метода delete()");
        repozitory.delete(9);
        System.out.println("Метод delete() завершен");

        System.out.println("Начало работы   метода findById(int id)");
        repozitory.findById(5);
        System.out.println("Метод findById(int id)  завершен");

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
