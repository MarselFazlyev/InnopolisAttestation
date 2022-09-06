import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CrudHumanImpl implements CrudHuman {
    private static Connection CONNECTION;

    public CrudHumanImpl() {
        getConnection();
        restartAllId();
    }

    private void getConnection() {
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream("src/main/resources/db_human.properties")) {
            properties.load(in);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (CONNECTION == null) {
            try {
                CONNECTION = DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties.getProperty("user"),
                        properties.getProperty("password"));
                if (!CONNECTION.isClosed()) System.out.println("Соединение установлено!");
            } catch (SQLException e) {
                throw new RuntimeException("Проблемы с подключением к базе данных...");
            }
        }

    }

    @Override
    public List<Human> getAllHumans() {
        List<Human> humans = new ArrayList<>();
        try {
            ResultSet resultSet = CONNECTION.createStatement()
                    .executeQuery("SELECT * from humans");
            while (resultSet.next()) {
                humans.add(new Human(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getString("patronymic"),
                        resultSet.getString("city"),
                        resultSet.getString("house"),
                        resultSet.getString("street"),
                        resultSet.getString("flat"),
                        resultSet.getString("numberpassport")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return humans;
    }

    @Override
    public Human getHumanById(int id) {
        if (id <= 0) throw new RuntimeException("id должно быть положительным числом!");
        Human human = new Human();
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("select * from humans where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                human.setId(resultSet.getInt("id"));
                human.setName(resultSet.getString("name"));
                human.setLastName(resultSet.getString("lastname"));
                human.setPatronymic(resultSet.getString("patronymic"));
                human.setCity(resultSet.getString("city"));
                human.setStreet(resultSet.getString("street"));
                human.setHouse(resultSet.getString("house"));
                human.setFlat(resultSet.getString("flat"));
                human.setNumberPassport(resultSet.getString("numberpassport"));
                System.out.println("Результаты поиска по id= " + id + "\n" + human);
                return human;
            } else System.out.printf("Человек с id = %d не найден\n", id);
            return new Human();// не знаю, что вернуть, кроме null!!!
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось выполнить запрос метода getHumanById(int id)");
        }

    }

    @Override
    public void updateHuman(Human human) {
        if (human == null)
            throw new NullPointerException("В метод updateHuman(Human human) переданы некорректные значения! ");
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("UPDATE humans" +
                    " set name = ?,lastname = ?,patronymic = ?,city=?,street = ?," +
                    "house = ?,flat = ?,numberpassport = ?  where id = ?");
            preparedStatement.setInt(9, human.getId());
            preparedStatement.setString(1, human.getName());
            preparedStatement.setString(2, human.getLastName());
            preparedStatement.setString(3, human.getPatronymic());
            preparedStatement.setString(4, human.getCity());
            preparedStatement.setString(5, human.getStreet());
            preparedStatement.setString(6, human.getHouse());
            preparedStatement.setString(7, human.getFlat());
            preparedStatement.setString(8, human.getNumberpassport());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Обновление данных по человеку " + human.getName() + " " + human.getLastName()
                    + "  не осуществилось ");
        }

    }

    @Override
    public void deleteHuman(Human human) {
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(
                    "DELETE  from humans where id = ? ");
            preparedStatement.setInt(1, human.getId());
            preparedStatement.executeUpdate();
            System.out.printf("Человек с id= %d успешно удален из базы данных!!\n", human.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void createHuman(Human human) {
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement("INSERT INTO humans (" +
                    "name,lastname,patronymic,city,street,house,flat,numberpassport) VALUES (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, human.getName());
            preparedStatement.setString(2, human.getLastName());
            preparedStatement.setString(3, human.getPatronymic());
            preparedStatement.setString(4, human.getCity());
            preparedStatement.setString(5, human.getStreet());
            preparedStatement.setString(6, human.getHouse());
            preparedStatement.setString(7, human.getFlat());
            preparedStatement.setString(8, human.getNumberpassport());
            preparedStatement.executeUpdate();
            System.out.println(human.getName() + " " + human.getLastName() + " успешно добавлен в БД !!!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // При каждом запуске экземпляра СrudHmanImpl позволяет обновить все id в базе данных с 1 по порядку!
    private void restartAllId() {
        try {
            CONNECTION.createStatement().executeUpdate("ALTER SEQUENCE humans_id_seq RESTART");
            CONNECTION.createStatement().executeUpdate("UPDATE humans SET id = DEFAULT");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Альтернативный метод createHuman(Human human) через сборку строки через StringBuilder
//    @Override
//    public void createHuman(Human human) {
//        StringBuilder sb = new StringBuilder("INSERT INTO humans (name,lastname,patronymic,city,street,house,flat,numberpassport) VALUES (");
//        sb.append("'" + human.getName() + "'").append(",")
//                .append("'" + human.getLastName() + "'").append(",")
//                .append("'" + human.getPatronymic() + "'").append(",")
//                .append("'" + human.getCity() + "'").append(",")
//                .append("'" + human.getHouse() + "'").append(",")
//                .append("'" + human.getStreet() + "'").append(",")
//                .append("'" + human.getFlat() + "'").append(",")
//                .append("'" + human.getNumberpassport() + "'").append(")");
//
//        try {
//            CONNECTION.prepareStatement(sb.toString())
//                    .executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
