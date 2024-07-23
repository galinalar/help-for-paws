package paws.mapper;

import org.mapstruct.Mapper;
import paws.domain.Person;
import paws.dto.PersonDto;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto map(Person comment);
}
