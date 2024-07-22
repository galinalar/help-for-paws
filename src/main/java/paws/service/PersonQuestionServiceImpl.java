package paws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paws.domain.Person;
import paws.domain.PersonQuestion;
import paws.repository.PersonQuestionRepository;
import paws.repository.PersonRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PersonQuestionServiceImpl implements PersonQuestionService{
    private final PersonQuestionRepository repository;
    @Override
    public List<PersonQuestion> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }

    @Override
    public PersonQuestion getPersonById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
