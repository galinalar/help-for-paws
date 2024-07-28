package paws.service;

import paws.domain.PersonQuestion;
import paws.domain.PersonTest;
import paws.dto.PersonTestDto;

import java.util.List;

public interface PersonTestService {
    List<PersonTestDto> getAll();

    PersonTestDto getPersonTestById(Long id);
}
