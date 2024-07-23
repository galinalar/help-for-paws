package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.Person;
import paws.domain.Pet;
import paws.dto.PersonDto;
import paws.dto.PetDto;

@Mapper(componentModel = "spring")
public interface PetMapper {
    @Mapping(target = "shelter", source = "shelters.shelter_id")
    PetDto map(Pet comment);
}
