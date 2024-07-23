package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.Person;
import paws.domain.PersonTest;
import paws.dto.PersonDto;
import paws.dto.PersonTestDto;

@Mapper(componentModel = "spring")
public interface PersonTestMapper {
    @Mapping(target = "person", source = "persons.person_id")
    @Mapping(target = "answer", source = "person_answers.person_answer_id")
    PersonTestDto map(PersonTest comment);
}
