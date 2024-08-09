package paws.mapper;

import org.mapstruct.Mapper;
import paws.domain.Pet;
import paws.dto.PetDto;

@Mapper(componentModel = "spring")
public interface PetMapper {
    PetDto map(Pet comment);
}
