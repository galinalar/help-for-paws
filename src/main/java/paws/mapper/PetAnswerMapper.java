package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.PetAnswer;
import paws.dto.PetAnswerDto;

@Mapper(componentModel = "spring")
public interface PetAnswerMapper {
    @Mapping(target = "question", source = "question")
    PetAnswerDto map(PetAnswer comment);
}
