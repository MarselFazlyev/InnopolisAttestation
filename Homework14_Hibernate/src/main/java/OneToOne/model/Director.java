package OneToOne.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;




@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "onetoone",name = "director")
public class Director  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "director")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private School school;

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
