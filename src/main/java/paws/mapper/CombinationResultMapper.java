package paws.mapper;

import org.mapstruct.Mapper;
import paws.domain.CombinationResult;
import paws.dto.CombinationResultDto;

@Mapper(componentModel = "spring")
public interface CombinationResultMapper {
    CombinationResultDto map(CombinationResult comment);
}
