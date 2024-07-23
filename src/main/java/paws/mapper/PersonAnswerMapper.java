package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.Person;
import paws.domain.PersonAnswer;
import paws.dto.PersonAnswerDto;
import paws.dto.PersonDto;

@Mapper(componentModel = "spring")
public interface PersonAnswerMapper {
    @Mapping(target = "question", source = "person_questions.person_question_id")
    PersonAnswerDto map(PersonAnswer comment);
}
