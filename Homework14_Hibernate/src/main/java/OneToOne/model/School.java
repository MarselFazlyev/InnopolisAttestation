package OneToOne.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(schema ="onetoone", name = "school")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="number")
    private int number;

    @JoinColumn(name = "director_id",referencedColumnName = "id")
    @OneToOne
    private Director director;

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
