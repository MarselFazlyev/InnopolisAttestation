package OneToOne;

import OneToOne.model.Director;
import OneToOne.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneMain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(School.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        Director director6 = Director.builder()
//                .name("Misha")
//                .age(34)
//                .build();
//        School school47 = School.builder()
//                .number(47)
//                .build();
//        director6.setSchool(school47);
//        school47.setDirector(director6);
//        session.persist(director6);

        //3)получить школу, а затем ее директора
        School school18 = session.get(School.class, 7);
        Director director = school18.getDirector();
        System.out.println(school18);
        System.out.println(director);

        //2)получить директора , а затем его школу.
        Director director4 = session.get(Director.class, 4);
        School schoolBydirector4 = director4.getSchool();
        System.out.println(director4);
        System.out.println(schoolBydirector4);

        Director director5 = Director.builder()
                .name("Misha")
                .age(34)
                .build();

        School school47 = School.builder()
                .number(47)
                .build();

        //4)Создайте нового директора и новую школу и свяжите эти сущности.
//        director5.setSchool(school47);
//        school47.setDirector(director5);
//        session.persist(director5);

        //5)Смените директора у существующей школы.
//        School school7 = session.get(School.class,5);
//        System.out.println("Прежний директор школы 7:"+school7.getDirector());
//        Director director6 = session.get(Director.class,11);
//        director6.setSchool(school7);
//        school7.setDirector(director6);
//        System.out.println("Новый директор школы 131:"+school7.getDirector());

        //6)Попробуйте добавить вторую школу для существующего директора и
        //изучите возникающую ошибку.
//        School school131 = session.get(School.class,6);
//        school131.setDirector(session.get(Director.class,2));
//        System.out.println(school131.getDirector());

        //Ответ
        //ERROR: duplicate key value violates unique constraint "school_director_id_key"
        //Подробности: Key (director_id)=(2) already exists.

        session.getTransaction().commit();
        sessionFactory.close();


    }
}
