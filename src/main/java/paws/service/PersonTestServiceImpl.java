package paws.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import paws.domain.Person;
import paws.domain.PersonAnswer;
import paws.domain.PersonQuestion;
import paws.domain.PersonTest;
import paws.dto.PersonTestDto;
import paws.exception.PawsException;
import paws.mapper.PersonTestMapper;
import paws.repository.PersonAnswerRepository;
import paws.repository.PersonQuestionRepository;
import paws.repository.PersonTestRepository;

@Service
@RequiredArgsConstructor
public class PersonTestServiceImpl implements PersonTestService{
    private final PersonTestRepository repository;
    private final PersonAnswerRepository personAnswerRepository;
    private final PersonQuestionRepository personQuestionRepository;
    private final PersonTestMapper mapper;
    @Override
    public List<PersonTestDto> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).map(mapper::map).toList();
    }

    @Override
    public List<PersonQuestion> getPersonTestById(Person person) {
        List<PersonAnswer> answers = repository.findAnswersByPerson(person);
        List<PersonQuestion> newPersonQuestion = new ArrayList<>();
        if (!answers.isEmpty()){
            List<PersonQuestion> personQuestions = StreamSupport.stream(personQuestionRepository.findAll().spliterator(), false).toList();
            for (PersonQuestion question : personQuestions) {
                for (PersonAnswer answer : question.getAnswers()) {
                    if (answers.contains(answer)) {
                        newPersonQuestion.add(new PersonQuestion(question.getId(), question.getQuestion(), List.of(answer)));
                        break;
                    }
                }
            }
        }
        return newPersonQuestion;
    }

    @Override
    public void savePersonTest(Long answerId, Person person) throws PawsException {
        PersonAnswer answer = personAnswerRepository.findById(answerId).orElseThrow(()->new PawsException("Нет такого ответа"));
        Date date = new Date();
        repository.save(new PersonTest(null, date, answer, person));
    }

}
