package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.Person;
import paws.domain.PersonAnswer;
import paws.domain.PetAnswer;
import paws.dto.PersonAnswerDto;
import paws.dto.PersonDto;
import paws.dto.PetAnswerDto;

@Mapper(componentModel = "spring")
public interface PetAnswerMapper {
    @Mapping(target = "question", source = "question")
    PetAnswerDto map(PetAnswer comment);
}
