package paws.mapper;

import org.mapstruct.Mapper;
import paws.domain.Combination;
import paws.dto.CombinationDto;

@Mapper(componentModel = "spring")
public interface CombinationMapper {
    CombinationDto map(Combination comment);
}
