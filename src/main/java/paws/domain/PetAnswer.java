package paws.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pet_answers")
public class PetAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_question_id", nullable = false)
    private PetQuestion question;

}
