package paws.dto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonTestDto {
    private Long id;

    private Date dateCompleted;

    private PersonAnswerDto answer;

    private PersonDto person;
}
