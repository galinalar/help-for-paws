package paws.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import paws.domain.*;
import paws.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CombinationServiceImpl implements CombinationService{
    private final PersonTestRepository personTestRepository;
    private final PetTestRepository petTestRepository;
    private final CombinationRepository combinationRepository;

    @Override
    public CombinationResult getByAnswers(Person person, Pet pet) {
        int result = 0;
//        List<PersonTest> personAnswers = personTestRepository.findByPerson(person);
//        List<PetTest> petAnswers = petTestRepository.findByPet(pet);
//        for (PersonTest personAnswer: personAnswers){
//            for (PetTest petAnswer: petAnswers){
//                result+= combinationRepository.findResultByPetAnswerAndPersonAnswer(personAnswer.getAnswer(), petAnswer.getAnswer()).orElseThrow(RuntimeException::new);
//            }
//        }
        List<PersonAnswer> personAnswers = personTestRepository.findAnswersByPerson(person);
        List<PetAnswer> petAnswers = petTestRepository.findAnswersByPet(pet);
        for (PersonAnswer personAnswer: personAnswers){
            for (PetAnswer petAnswer: petAnswers){
                result+= combinationRepository.findResultByPetAnswerAndPersonAnswer(personAnswer, petAnswer).orElseThrow(RuntimeException::new);
            }
        }
        return new CombinationResult(null, result, pet, person);
    }
}
