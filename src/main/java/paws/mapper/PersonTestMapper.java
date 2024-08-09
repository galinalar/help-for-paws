package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.PersonTest;
import paws.dto.PersonTestDto;

@Mapper(componentModel = "spring")
public interface PersonTestMapper {
    @Mapping(target = "person", source = "person")
    @Mapping(target = "answer", source = "answer")
    PersonTestDto map(PersonTest comment);
}
