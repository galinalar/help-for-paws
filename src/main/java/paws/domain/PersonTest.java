package paws.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person_tests")
public class PersonTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date dateCompleted;

    @ManyToOne
    @JoinColumn(name = "person_answer_id", nullable = false)
    private PersonAnswer answer;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
