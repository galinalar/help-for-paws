package paws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {
    private Long id;

    private String name;

    private String path;

    private ShelterDto shelterDto;

}
