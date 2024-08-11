package paws.service;

import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import paws.domain.PersonQuestion;
import paws.repository.PersonQuestionRepository;

@Service
@RequiredArgsConstructor
public class PersonQuestionServiceImpl implements PersonQuestionService{
    private final PersonQuestionRepository repository;
    @Override
    public List<PersonQuestion> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }
}
