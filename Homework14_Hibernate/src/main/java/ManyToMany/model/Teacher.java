package ManyToMany.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "ManyToMany",name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "discipline")
    private String discipline;

    @Column(name = "age")
    private int age;

    @ManyToMany
    @JoinTable(schema ="ManyToMany",name = "teacher_student",
    joinColumns = @JoinColumn(name = "teacher_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public Teacher(){}

    public Teacher(String name,String discipline,int age){
        this.name= name;
        this.discipline = discipline;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discipline='" + discipline + '\'' +
                ", age=" + age +
                '}';
    }
}
