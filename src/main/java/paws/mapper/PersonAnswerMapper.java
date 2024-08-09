package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.PersonAnswer;
import paws.dto.PersonAnswerDto;

@Mapper(componentModel = "spring")
public interface PersonAnswerMapper {
    @Mapping(target = "question", source = "question")
    PersonAnswerDto map(PersonAnswer comment);
}
