package paws.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import paws.domain.Person;
import paws.domain.PersonAnswer;

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
