package paws.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import paws.domain.PersonQuestion;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonAnswerDto {
    private Long id;

    private String answer;

    private PersonQuestionDto question;

}
