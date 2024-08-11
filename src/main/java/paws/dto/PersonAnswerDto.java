package paws.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonAnswerDto {
    private Long id;

    private String answer;

    private PersonQuestionDto question;

}
