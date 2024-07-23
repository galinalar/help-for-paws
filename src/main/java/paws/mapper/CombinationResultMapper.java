package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.CombinationResult;
import paws.domain.Person;
import paws.dto.CombinationResultDto;
import paws.dto.PersonDto;

@Mapper(componentModel = "spring")
public interface CombinationResultMapper {
    @Mapping(target = "pet", source = "pets.pet_id")
    @Mapping(target = "person", source = "persons.person_id")
    CombinationResultDto map(CombinationResult comment);
}
