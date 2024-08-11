package paws.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {
    private Long id;

    private String name;

    private String path;

    private ShelterDto shelterDto;

}
