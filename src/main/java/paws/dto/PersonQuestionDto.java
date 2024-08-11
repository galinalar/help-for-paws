package paws.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonQuestionDto {
    private Long id;

    private String question;

    private List<PersonAnswerDto> answers;
}
