package paws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
