package paws.mapper;

import org.mapstruct.Mapper;
import paws.domain.Person;
import paws.domain.Shelter;
import paws.dto.PersonDto;
import paws.dto.ShelterDto;

@Mapper(componentModel = "spring")
public interface ShelterMapper {
    ShelterDto map(Shelter comment);
}
