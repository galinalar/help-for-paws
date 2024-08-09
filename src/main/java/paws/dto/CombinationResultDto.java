package paws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombinationResultDto {
    private Long id;

    private int result;

    private PetDto pet;

    private PersonDto person;
}
