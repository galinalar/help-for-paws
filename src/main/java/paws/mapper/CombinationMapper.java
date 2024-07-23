package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.Combination;
import paws.domain.Person;
import paws.dto.CombinationDto;
import paws.dto.PersonDto;

@Mapper(componentModel = "spring")
public interface CombinationMapper {
    @Mapping(target = "petAnswer", source = "pet_answers.pet_answer_id")
    @Mapping(target = "personAnswer", source = "person_answers.person_answer_id")
    CombinationDto map(Combination comment);
}
