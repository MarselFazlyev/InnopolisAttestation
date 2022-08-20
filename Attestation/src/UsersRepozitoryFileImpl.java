import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UsersRepozitoryFileImpl implements UsersRepozitoryFile {
    private String path;
    private File file;
    private Map<Integer, User> userAutentification = new HashMap<>();


    public UsersRepozitoryFileImpl(String path) {
        this.path = path;
        this.file = new File(path);
        dataCaching();
    }

    @Override
    public User findById(int id) {
        return userAutentification.getOrDefault(id, null);
    }

    @Override
    public void create(User user) {
        // TODO: 20.08.2022 сделать тернарным оператором  userInfoRepository.containsKey(user.getId())?
        //  allUsers.add(user):System.out.println(" Данный пользователь уже существует");
        if (userAutentification.containsKey(user.getId())) {
            System.out.println("Данный пользователь уже существует");
        } else {
            userAutentification.put(user.getId(), user);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))) {
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
        // TODO: 20.08.2022 сделать тернарным оператором  userInfoRepository.containsKey(id)?
        //  userAutentification.remove(id):System.out.println(" Данный пользователь не существует в репозитории");
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

}
