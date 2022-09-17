import model.Director;
import model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            session.beginTransaction();

//            Director director4 = session.get(Director.class, 4);
//            System.out.println(director4);
            Movie movie = session.get(Movie.class,3);


                System.out.println(movie);


            session.getTransaction().commit();

        }


//      ResultSet resultSet =  DriverManager
//              .getConnection("jdbc:postgresql://localhost:5432/HIbernatePetProject", "postgres", "postgres")
//              .createStatement()
//              .executeQuery("select * from  director");
//      while (resultSet.next()){
//          System.out.println(new Director(resultSet.getInt("director_id"), resultSet.getString("name"),resultSet.getInt("age")));
//
//      }






    }

}
