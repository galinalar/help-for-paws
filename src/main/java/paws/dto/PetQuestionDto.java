package paws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetQuestionDto {
    private Long id;

    private String question;

    private List<PetAnswerDto> answers;
}
