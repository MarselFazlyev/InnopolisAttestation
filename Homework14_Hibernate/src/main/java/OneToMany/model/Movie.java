package OneToMany.model;

import jakarta.persistence.*;

@Entity
@Table(name ="movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;


    @JoinColumn (name = "director_id",referencedColumnName = "director_id")
    @ManyToOne
    private Director owner;

    @Column (name = "name")
    private String movie_name;

    @Column (name = "year_of_production")
    private int year;

    public Movie(){}

    public Movie(String movie_name, int year) {
        this.movie_name = movie_name;
        this.year = year;
    }

    public Movie(Director owner, String movie_name, int year) {
        this.owner = owner;
        this.movie_name = movie_name;
        this.year = year;
    }

    public Movie(Integer id, Director owner, String movie_name, int year) {
        this.id = id;
        this.owner = owner;
        this.movie_name = movie_name;
        this.year = year;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Director getOwner() {
        return owner;
    }

    public void setOwner(Director owner) {
        this.owner = owner;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return
                "\n id " + id +"\n"+
                " owner " + owner +
                " movie_name " + movie_name +"\n"+
                " year  " + year +"\n";
    }
}
