package paws.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import paws.domain.PetQuestion;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetAnswerDto {
    private Long id;

    private String answer;

    private PetQuestionDto question;

}
