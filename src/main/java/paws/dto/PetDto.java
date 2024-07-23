package paws.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import paws.domain.Shelter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {
    private Long id;

    private String name;

    private ShelterDto shelterDto;

}
