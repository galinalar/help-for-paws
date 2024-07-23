package paws.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import paws.domain.PersonAnswer;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonQuestionDto {
    private Long id;

    private String question;

    private List<PersonAnswerDto> answers;
}
