import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class UsersRepozitoryFileImpl implements UsersRepozitoryFile {

    private final static int RANDOM_MAX_USER_SIZE = new Random().nextInt(1000);
    private static File file;

    private String path;


    private Map<Integer, User> userAutentification = new HashMap<>();


    public UsersRepozitoryFileImpl(String path) {
        this.path = path;
        file = new File(path);
        dataCaching();
    }

    @Override
    public User findById(int id) {
        //  изящный return
        //  return userAutentification.getOrDefault(id, null);
        if (userAutentification.containsKey(id)) {
            System.out.println("Данные пользователя по запрашиваемому id :\n" + userAutentification.get(id));
            return userAutentification.get(id);
        } else {
            System.out.println("Пользователь с id: " + id + " не найден");
            return null;
        }
    }

    @Override
    public void create(User user) {
        if (userAutentification.containsKey(user.getId())) {
            System.out.println("Данный пользователь уже существует");
        } else {
            userAutentification.put(user.getId(), user);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(String.valueOf(user));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(User user) {
        userAutentification.put(user.getId(), user);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<Integer, User> userEntry : userAutentification.entrySet()) {
                writer.write(String.valueOf(userEntry.getValue()));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        userAutentification.remove(id);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<Integer, User> userEntry : userAutentification.entrySet()) {
                writer.write(String.valueOf(userEntry.getValue()));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dataCaching() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.file))) {
            if (!(this.file.createNewFile())) {
                System.out.println("Файл с адресом пути: " + "\"" + path + "\"" + " уже существует!" +
                        "\nОсуществляю кэширование текущих данных\n");
            }
            String temp;
            while ((temp = reader.readLine()) != null) {
                String[] userParts = temp.split("\\|");
                User user = new User(Integer.parseInt(userParts[0].trim()), userParts[1].trim(), userParts[2].trim(),
                        Integer.parseInt(userParts[3].trim()), Boolean.parseBoolean(userParts[4].trim()));
                userAutentification.put(user.getId(), user);
            }
            System.out.println("Кэширование данных успешно завершено!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException ee) {
            System.out.println("В файле введено некорректное значение поля, необходима корректировка данных в файле," +
                    "после чего необходимо обновить репозиторий (метод updateRepository()) " +
                    " !");
        }
    }

    protected static Map<Integer,User> generateUsers() {
        Map<Integer, User> generatedMap = new HashMap<>();

        String[] randomNames = {"Cергей", "Олег", "Дмитрий", "Максим", "Марсель", "Ренат", "Джон", "Майк", "Оливер", "Борис"};
        String[] randomSurnames = {"Иванов", "Петров", "Сидоров", "Кузнецов", "Прищепкин", "Самигулин", "Крайков", "Джордан",
                "Роналдо", "Отстойников"};
        for (int i = 0; i < RANDOM_MAX_USER_SIZE; i++) {
            generatedMap.put(i,new User(i, randomNames[new Random().nextInt(randomNames.length)],
                    randomSurnames[new Random().nextInt(randomSurnames.length)],new Random().nextInt(60), new Random().nextBoolean()));
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<Integer, User> userEntry : generatedMap.entrySet()) {
                writer.write(String.valueOf(userEntry.getValue()));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return generatedMap;
    }

}
