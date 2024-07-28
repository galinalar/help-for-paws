package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.Person;
import paws.domain.PetTest;
import paws.dto.PersonDto;
import paws.dto.PetTestDto;

@Mapper(componentModel = "spring")
public interface PetTestMapper {
//    @Mapping(target = "shelter", source = "shelterDto")
    PetTestDto map(PetTest comment);
}
