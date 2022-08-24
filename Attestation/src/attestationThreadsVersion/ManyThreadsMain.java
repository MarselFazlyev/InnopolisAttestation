package attestationThreadsVersion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // случайное заполнение файла экземплярами  attestationThreadsVersion.User
                if (isFileEmpty(file)) {
                    System.out.println("****************************************");
                    System.out.println("Работает 1 поток: выполняется рандомная  генерация экземпляров класса attestationThreadsVersion.User... ");
                    UsersRepozitoryFileImpl.generateUsers(file);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Генерация успешно завершена!");
                    System.out.println("****************************************");
                }
            }
        });

        thread1.start();
        thread1.join();

        // создание экземпляра класса , реализующего интерфейс attestationThreadsVersion.UsersRepozitoryFile
        UsersRepozitoryFileImpl repozitory = new UsersRepozitoryFileImpl(file);

        // запуск методов,имплементированных с интерфейса UserRepozitoryFile
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                repozitory.getLock().lock();
                System.out.println("****************************************");
                System.out.println("Работает 2 поток: тестирование имплементированных методов интерфейса " +
                        "attestationThreadsVersion.UsersRepozitoryFileImpl ...");
                System.out.println("Начало работы   метода create()");
                //тестирование имплементированного метода  create(attestationThreadsVersion.User user)
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
                System.out.println("****************************************");
                repozitory.getLock().unlock();
            }
        });


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<User> future = executorService.submit(new Callable<User>() {
            @Override
            public User call() throws Exception {
                Thread.sleep(1000);
                System.out.println("****************************************");
                System.out.println("Работает пулл потоков : тестирование имплементированного метода интерфейса " +
                        "attestationThreadsVersion.UsersRepozitoryFileImpl findByID ...");
                System.out.println("Метод findById() завершен");
                System.out.println("****************************************");
                return repozitory.findById(5);
            }
        });

        thread2.start();
        executorService.shutdown();

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
