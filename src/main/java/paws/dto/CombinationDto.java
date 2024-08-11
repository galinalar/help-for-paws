package paws.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CombinationDto {
    private Long id;

    private int result;

    private PetAnswerDto petAnswer;

    private PersonAnswerDto personAnswer;
}
