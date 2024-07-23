package paws.mapper;

import org.mapstruct.Mapper;
import paws.domain.Person;
import paws.domain.PetQuestion;
import paws.dto.PersonDto;
import paws.dto.PetQuestionDto;

@Mapper(componentModel = "spring")
public interface PetQuestionMapper {
    PetQuestionDto map(PetQuestion comment);
}
