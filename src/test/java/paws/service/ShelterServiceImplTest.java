package paws.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import paws.domain.Shelter;
import paws.exception.PawsException;
import paws.repository.ShelterRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {ShelterServiceImpl.class})
class ShelterServiceImplTest {

    @MockBean
    private ShelterRepository repository;
    @Autowired
    private ShelterService shelterService;

    Shelter shelter = new Shelter(1L, "n", 1);
    Shelter shelter2 = new Shelter(2L, "n2", 1);
    @Test
    void getAll() {
        when(repository.findByActive(1)).thenReturn(List.of(shelter, shelter2));
        List<Shelter> shelters = shelterService.getAll();
        assertEquals(List.of(shelter, shelter2), shelters);
    }

    @Test
    void getShelterById() throws PawsException {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(shelter));
        Shelter shelter3 = shelterService.getShelterById(1L);
        assertEquals(shelter, shelter3);
    }

    @Test
    void saveShelter() {
        shelterService.saveShelter("n");

        ArgumentCaptor<Shelter> captor = ArgumentCaptor.forClass(Shelter.class);
        verify(repository).save(captor.capture());
        assertEquals("n", captor.getValue().getName());
        assertEquals(1, captor.getValue().getActive());
    }

    @Test
    void deleteShelterById() throws PawsException {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(shelter));
        shelterService.deleteShelterById(1L);

        ArgumentCaptor<Shelter> captor = ArgumentCaptor.forClass(Shelter.class);
        verify(repository).save(captor.capture());
        assertEquals("n", captor.getValue().getName());
        assertEquals(0, captor.getValue().getActive());
    }

    @Test
    void updateShelter() {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(shelter));

        shelterService.saveShelter("n");
        shelterService.updateShelter(1L, "n3");

        ArgumentCaptor<Shelter> captor = ArgumentCaptor.forClass(Shelter.class);
        verify(repository, times(2)).save(captor.capture());
        assertEquals("n3", captor.getValue().getName());
        assertEquals(1, captor.getValue().getActive());
    }
}