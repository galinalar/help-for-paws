package paws.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import paws.domain.*;
import paws.exception.PawsException;
import paws.repository.*;

@Service
@RequiredArgsConstructor
public class CombinationServiceImpl implements CombinationService{
    private final PersonTestRepository personTestRepository;
    private final PetTestRepository petTestRepository;
    private final CombinationRepository combinationRepository;

    @Override
    public CombinationResult getByAnswers(Person person, Pet pet) throws PawsException {
        int result = 0;
        List<PersonAnswer> personAnswers = personTestRepository.findAnswersByPerson(person);
        List<PetAnswer> petAnswers = petTestRepository.findAnswersByPet(pet);
        for (PersonAnswer personAnswer: personAnswers){
            for (PetAnswer petAnswer: petAnswers){
                result+= combinationRepository.findResultByPetAnswerAndPersonAnswer(personAnswer, petAnswer)
                        .orElseThrow(()->new PawsException("Сочетание не найдено"));
            }
        }
        return new CombinationResult(null, result, pet, person);
    }
}
