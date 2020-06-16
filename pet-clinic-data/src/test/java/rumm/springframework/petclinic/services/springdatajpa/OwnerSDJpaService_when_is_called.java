package rumm.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import rumm.springframework.petclinic.model.Owner;
import rumm.springframework.petclinic.repositories.OwnerRepository;
import rumm.springframework.petclinic.repositories.PetRepository;
import rumm.springframework.petclinic.repositories.PetTypeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaService_when_is_called {

    private static final String OWNER_SMITH_LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService sut;

    Owner smith;

    @BeforeEach
    void setUp() {
        smith = Owner.builder().id(1L).lastName(OWNER_SMITH_LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        // Arrange
        when(ownerRepository.findByLastName(eq(OWNER_SMITH_LAST_NAME))).thenReturn(smith);

        // Act
        Owner resultOwner = sut.findByLastName(OWNER_SMITH_LAST_NAME);

        // Assert
        assertNotNull(resultOwner);
        assertEquals(OWNER_SMITH_LAST_NAME, resultOwner.getLastName());

    }

    @Test
    void findAll() {

        // Arrange
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        // Act
        Set<Owner> resultOwners = sut.findAll();

        // Assert
        assertNotNull(resultOwners);
        assertEquals(2, resultOwners.size());

    }

    @Test
    void findById() {

        // Arrange
        when(ownerRepository.findById(eq(1L))).thenReturn(Optional.of(smith));

        // Act
        Owner resultOwner = sut.findById(1L);

        // Assert
        assertNotNull(resultOwner);

    }

    @Test
    void save() {

        // Arrange
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(ownerToSave)).thenReturn(smith);

        // Act
        Owner resultOwner = sut.save(ownerToSave);

        // Assert
        assertNotNull(resultOwner);

    }

    @Test
    void delete() {

        // Arrange

        // Act
        sut.delete(smith);

        // Assert
        verify(ownerRepository).delete(any());

    }

    @Test
    void deleteById() {

        // Arrange
        sut.deleteById(smith.getId());

        // Act

        // Assert
        verify(ownerRepository).deleteById(eq(1L));

    }
}
