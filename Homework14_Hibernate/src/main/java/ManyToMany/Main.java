package ManyToMany;


import ManyToMany.model.Student;
import ManyToMany.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Teacher.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

//            Student student1 = new Student("John Smith",20);
//            Student student2 = new Student("Michael Smith",27);
//            Student student3 = new Student("Oliver Smith",19);
//            Student student4 = new Student("Yan Smith",30);
//            Student student5 = new Student("Obi Van Kenobi ",24);
//            Student student6 = new Student("Batman ",58);
//            Student student7 = new Student("Robin ",10);
//            Student student8 = new Student("John Snow ",49);
//            Student student9 = new Student("Ivan Dubov",33);
//            Student student10 = new Student("Milashka Sju",4);
//            session.persist(student1);
//            session.persist(student2);
//            session.persist(student3);
//            session.persist(student4);
//            session.persist(student5);
//              session.persist(student6);
//              session.persist(student7);
//              session.persist(student8);
//              session.persist(student9);
//              session.persist(student10);
//            Teacher teacher1 = new Teacher("Olga Vasilevna","biology",50);
//            Teacher teacher2 = new Teacher("Guzel Varisovna","mathematics",40);
//            Teacher teacher3 = new Teacher("Daniya Gimaevna","Russian Language",65);
//            session.persist(teacher1);
//            session.persist(teacher2);
//            session.persist(teacher3);

            Teacher teacher1 = session.get(Teacher.class, 1);
            teacher1.setStudents(new ArrayList<>(List.of(
                    (session.get(Student.class, 2)),
                    (session.get(Student.class, 4)),
                    (session.get(Student.class, 12)))));

            session.get(Student.class,2).setTeachers(new ArrayList<>(Collections.singletonList(teacher1)));
            session.get(Student.class,4).setTeachers(new ArrayList<>(Collections.singletonList(teacher1)));
            session.get(Student.class,12).setTeachers(new ArrayList<>(Collections.singletonList(teacher1)));

            System.out.println(teacher1.getStudents());

            Student student5 = session.get(Student.class, 5);
            Teacher teacher2 = session.get(Teacher.class, 2);
            Teacher teacher3 = session.get(Teacher.class, 3);

            session.get(Teacher.class, 2).setStudents(new ArrayList<>(Collections.singletonList(student5)));
            session.get(Teacher.class, 3).setStudents(new ArrayList<>(Collections.singletonList(student5)));

            student5.setTeachers(new ArrayList<>(List.of(teacher1, teacher2, teacher3)));
            teacher1.getStudents().add(student5);

            System.out.println(student5.getTeachers());

            session.getTransaction().commit();
        }
    }
}
