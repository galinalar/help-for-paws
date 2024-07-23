package paws.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import paws.domain.Pet;
import paws.domain.PetAnswer;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetTestDto {
    private Long id;

    private Date dateCompleted;

    private PetAnswerDto answer;

    private PetDto pet;
}
