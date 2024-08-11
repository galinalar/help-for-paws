package paws.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person_questions")
public class PersonQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;

    @OneToMany(mappedBy="question", fetch = FetchType.EAGER)
    private List<PersonAnswer> answers;
}
