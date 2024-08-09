package paws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombinationDto {
    private Long id;

    private int result;

    private PetAnswerDto petAnswer;

    private PersonAnswerDto personAnswer;
}
