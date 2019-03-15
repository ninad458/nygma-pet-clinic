package nygma.springframework.nygmapetclinic.service.springdatajpa;

import nygma.springframework.nygmapetclinic.model.Owner;
import nygma.springframework.nygmapetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJPAServiceTest {

    private static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJPAService service;
    private Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findOwnerByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(Optional.of(returnOwner));

        Owner smith = service.findOwnerByLastName("Smith");
        assertEquals(smith, returnOwner);

        assertEquals(smith.getLastName(), LAST_NAME);

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        assertNotNull(ownerRepository.findById(1L));
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertNull(service.findById(1L));
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        assertNotNull(service.save(Owner.builder().id(2L).build()));
    }

    @Test
    void findAll() {
        List<Owner> returnOwnersList = new ArrayList<>();
        returnOwnersList.add(Owner.builder().id(2L).build());
        returnOwnersList.add(Owner.builder().id(3L).build());
        when(ownerRepository.findAll()).thenReturn(returnOwnersList);

        Set<Owner> ownersSet = service.findAll();
        assertNotNull(ownersSet);
        assertEquals(ownersSet.size(), 2);
    }

    @Test
    void delete() {
        service.delete(Owner.builder().build());

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(3L);

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}