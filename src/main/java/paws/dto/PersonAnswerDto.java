package paws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonAnswerDto {
    private Long id;

    private String answer;

    private PersonQuestionDto question;

}
