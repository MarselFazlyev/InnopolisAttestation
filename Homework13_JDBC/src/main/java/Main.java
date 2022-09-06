import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        CrudHumanImpl crudHuman = new CrudHumanImpl();

        Human human = new Human("Jora", "Vartanov", "Arsenovich", "Moscow", "111"
                ,"BakerStreet", "23", "4231456789");

        Human human2 = new Human("Tanya", "Ivanova", "Nikolaevna", "Moscow", "123"
                ,"Kosygina", "44", "000111234");

        crudHuman.createHuman(human2);



        System.out.println(crudHuman.getAllHumans());


//        Human human = new Human("Jora","Vartanov","Arsenovich","Moscow","BakerStreet"
//                ,"111","23","4231 456789");
//        StringBuilder sb = new StringBuilder();
//        sb.append("INSERT INTO humans (name,lastname,patronymic,city,street,house,flat,numberpassport) VALUES (");
//        sb.append(human.getName()).append(",")
//                .append(human.getLastName()).append(",")
//                .append(human.getPatronymic()).append(",")
//                .append(human.getCity()).append(",")
//                .append(human.getHouse()).append(",")
//                .append(human.getStreet()).append(",")
//                .append(human.getFlat()).append(",")
//                .append(human.getNumberpassport()).append(")");
//
//        System.out.println(sb);


    }
}
