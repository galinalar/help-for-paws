package paws.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "combinations")
public class Combination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int result;

    @ManyToOne
    @JoinColumn(name = "pet_answer_id", nullable = false)
    private PetAnswer petAnswer;

    @ManyToOne
    @JoinColumn(name = "person_answer_id", nullable = false)
    private PersonAnswer personAnswer;
}
