package paws.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetAnswerDto {
    private Long id;

    private String answer;

    private PetQuestionDto question;

}
