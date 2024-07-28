package paws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import paws.domain.Combination;
import paws.domain.Person;
import paws.dto.CombinationDto;
import paws.dto.PersonDto;

@Mapper(componentModel = "spring")
public interface CombinationMapper {
//    @Mapping(target = "petAnswer", source = "petAnswer")
//    @Mapping(target = "personAnswer", source = "answer")
    CombinationDto map(Combination comment);
}
