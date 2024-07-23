package paws.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import paws.domain.PetAnswer;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetQuestionDto {
    private Long id;

    private String question;

    private List<PetAnswerDto> answers;
}
