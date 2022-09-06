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
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public List<Human> getAllHumans() {
        if (CONNECTION != null) {
            System.out.println("Начало работы метода getAllHumans()");
        }
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
        return null;
    }

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

    @Override
    public void createHuman(Human human) {
        try {
            PreparedStatement  preparedStatement = CONNECTION.prepareStatement("INSERT INTO humans (" +
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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateHuman(Human human) {

    }

    @Override
    public void deleteHuman(Human human) {


    }
}
