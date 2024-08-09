package paws.mapper;

import org.mapstruct.Mapper;
import paws.domain.PersonQuestion;
import paws.dto.PersonQuestionDto;

@Mapper(componentModel = "spring")
public interface PersonQuestionMapper {
    PersonQuestionDto map(PersonQuestion comment);
}
