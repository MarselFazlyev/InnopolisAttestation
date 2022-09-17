package OneToMany;

import OneToMany.model.Director;
import OneToMany.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
// вызов режиссера и его фильмов
  /*          Director director4 = session.get(Director.class, 1);
            System.out.println(director4);
            List<Movie> movies = director4.getMovies();
            for (Movie movie : movies) {
                System.out.println(movie);
            }*/
// получение фильма, затем его режиссера
        /*    Movie movie = session.get(Movie.class, 5);
            System.out.println(movie);
            Director director = movie.getOwner();
            System.out.println(director);*/

//  добавить еще один фильм для любого режиссера
/*            Director director6 = session.get(Director.class,6);
            System.out.println("Before add new movie"+director6.getMovies());
            director6.getMovies().add(session.get(Movie.class,11));
            director6.getMovies().add(session.get(Movie.class,10));
            session.persist(director6);
            System.out.println("After add new movie"+director6.getMovies());*/

//  Создать нового режиссера и новый фильм и связать эти сущности.
   /*         Director director7 = new Director("Timur Bekmambetov",50);
            Movie movie12 = new Movie(director7,"Matrix",2000);
            director7.getMovies().add(0,movie12);
            session.persist(director7);
            session.persist(movie12);*/

//  Смените режиссера у существующего фильма.
     /*       Movie movie7 = session.get(Movie.class, 7);
            movie7.setOwner(session.get(Director.class, 5));
            session.persist(movie7);
            System.out.println(movie7);
            Director director5 = session.get(Director.class, 5);
            System.out.println(director5.getMovies());*/

//  удалите фильм у любого режиссера
      /*      Director director1 = session.get(Director.class,1);
            System.out.println(director1.getMovies());
            session.remove(director1.getMovies().get(1));
            System.out.println(director1.getMovies());*/

            Movie movie = new Movie(session.get(Director.class,1),"Pulp Fiction",1994);
            session.persist(movie);


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
