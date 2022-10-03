package OneToMany.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {

    @Id
    @Column(name = "director_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int director_id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany (mappedBy = "owner",cascade = CascadeType.PERSIST)
    private List<Movie> movies = new ArrayList<>();

    public Director(){}

    public Director(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Director(int director_id, String name, int age) {
        this.director_id = director_id;
        this.name = name;
        this.age = age;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "  director_id  " + director_id +
                " name  " + name +
                " age  " + age + "\n";
    }
}
