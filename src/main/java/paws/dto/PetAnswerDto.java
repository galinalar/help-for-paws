package paws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetAnswerDto {
    private Long id;

    private String answer;

    private PetQuestionDto question;

}
