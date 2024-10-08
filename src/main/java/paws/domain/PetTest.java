package paws.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pet_tests")
public class PetTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date dateCompleted;

    @ManyToOne
    @JoinColumn(name = "pet_answer_id", nullable = false)
    private PetAnswer answer;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;
}
