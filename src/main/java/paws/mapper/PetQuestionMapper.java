package paws.mapper;

import org.mapstruct.Mapper;
import paws.domain.PetQuestion;
import paws.dto.PetQuestionDto;

@Mapper(componentModel = "spring")
public interface PetQuestionMapper {
    PetQuestionDto map(PetQuestion comment);
}
