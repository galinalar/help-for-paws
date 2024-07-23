package paws.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import paws.domain.Person;
import paws.domain.Pet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombinationResultDto {
    private Long id;

    private int result;

    private PetDto pet;

    private PersonDto person;
}
