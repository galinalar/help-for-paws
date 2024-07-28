package paws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paws.domain.PersonQuestion;
import paws.domain.PersonTest;
import paws.dto.PersonTestDto;
import paws.mapper.PersonTestMapper;
import paws.repository.PersonAnswerRepository;
import paws.repository.PersonQuestionRepository;
import paws.repository.PersonRepository;
import paws.repository.PersonTestRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PersonTestServiceImpl implements PersonTestService{
    private final PersonTestRepository repository;
    private final PersonRepository personRepository;
    private final PersonAnswerRepository personAnswerRepository;
    private final PersonTestMapper mapper;
    @Override
    public List<PersonTestDto> getAll() {
        repository.save(new PersonTest(null,null,personAnswerRepository.findById(1L).orElseThrow(),personRepository.findById(1L).orElseThrow()));
        return StreamSupport.stream(repository.findAll().spliterator(), false).map(mapper::map).toList();
    }

    @Override
    public PersonTestDto getPersonTestById(Long id) {
        return repository.findById(id).map(mapper::map).orElseThrow(RuntimeException::new);
    }
}
