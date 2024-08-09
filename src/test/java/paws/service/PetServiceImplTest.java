package paws.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import paws.domain.Pet;
import paws.domain.Shelter;
import paws.dto.PetDto;
import paws.exception.PawsException;
import paws.mapper.PetMapper;
import paws.mapper.PetMapperImpl;
import paws.repository.PetRepository;
import paws.repository.ShelterRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {PetServiceImpl.class, PetMapperImpl.class, ShelterServiceImpl.class})
class PetServiceImplTest {
    @MockBean
    private PetRepository repository;
    @MockBean
    private ShelterRepository shelterRepository;
    @Autowired
    private ShelterService shelterService;
    @Autowired
    private PetMapper mapper;
    @Autowired
    private PetService petService;

    Shelter shelter = new Shelter(1L, "n", 1);
    Pet pet = new Pet(1L, "petname", null, shelter, 1);
    Pet pet2 = new Pet(2L, "petname2", null, shelter, 1);

    @Test
    void getAll() {
        when(repository.findAll()).thenReturn(List.of(pet, pet2));
        List<PetDto> petDtos = petService.getAll();
        assertEquals(List.of(mapper.map(pet), mapper.map(pet2)), petDtos);
    }

    @Test
    void getAllbyShelter() {
        when(repository.findByShelterIdAndActive(1L, 1)).thenReturn(List.of(pet, pet2));
        List<Pet> pets = petService.getAllbyShelter(1L);
        assertEquals(List.of(pet, pet2), pets);
    }

    @Test
    void getPetById() throws PawsException {
        when(repository.findById(2L)).thenReturn(Optional.ofNullable(pet2));
        Pet pet3 = petService.getPetById(2L);
        assertEquals(pet2, pet3);
    }

    @Test
    void savePet() throws PawsException {
        when(shelterRepository.findById(1L)).thenReturn(Optional.ofNullable(shelter));
        petService.savePet("name", 1L);

        ArgumentCaptor<Pet> captor = ArgumentCaptor.forClass(Pet.class);
        verify(repository, times(1)).save(captor.capture());
        assertEquals("name", captor.getValue().getName());
        assertEquals(shelter, captor.getValue().getShelter());
    }

    @Test
    void updatePet() throws PawsException {
        when(shelterRepository.findById(1L)).thenReturn(Optional.ofNullable(shelter));
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(pet));

        petService.savePet("petname",1L);
        petService.updatePet(1L, "petname2",1L);

        ArgumentCaptor<Pet> captor = ArgumentCaptor.forClass(Pet.class);
        verify(repository, times(2)).save(captor.capture());
        assertEquals("petname2", captor.getValue().getName());
        assertEquals(shelter, captor.getValue().getShelter());
    }

    @Test
    void deletePetById() throws PawsException {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(pet));
        petService.deletePetById(1L);

        ArgumentCaptor<Pet> captor = ArgumentCaptor.forClass(Pet.class);
        verify(repository).save(captor.capture());
        assertEquals(0, captor.getValue().getActive());
        assertEquals(pet.getName(), captor.getValue().getName());
    }
}