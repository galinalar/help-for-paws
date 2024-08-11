package paws.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CombinationResultDto {
    private Long id;

    private int result;

    private PetDto pet;

    private PersonDto person;
}
