package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.Person;
import paws.domain.PersonQuestion;
import paws.dto.PersonDto;
import paws.dto.PersonQuestionDto;

@Mapper(componentModel = "spring")
public interface PersonQuestionMapper {
    PersonQuestionDto map(PersonQuestion comment);
}
