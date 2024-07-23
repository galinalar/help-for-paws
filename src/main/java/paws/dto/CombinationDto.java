package paws.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import paws.domain.PersonAnswer;
import paws.domain.PetAnswer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CombinationDto {
    private Long id;

    private int result;

    private PetAnswerDto petAnswer;

    private PersonAnswerDto personAnswer;
}
