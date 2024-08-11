package paws.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetTestDto {
    private Long id;

    private Date dateCompleted;

    private PetAnswerDto answer;

    private PetDto pet;
}
