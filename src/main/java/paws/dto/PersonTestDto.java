package paws.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonTestDto {
    private Long id;

    private Date dateCompleted;

    private PersonAnswerDto answer;

    private PersonDto person;
}
