package paws.mapper;

import org.mapstruct.Mapper;
import paws.domain.PetTest;
import paws.dto.PetTestDto;

@Mapper(componentModel = "spring")
public interface PetTestMapper {
    PetTestDto map(PetTest comment);
}
