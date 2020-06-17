package rumm.springframework.petclinic.services.map;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rumm.springframework.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OwnerServiceMap_when_methods_are_called_Test {

    private static final Long OWNER1_ID = 1L;
    private static final String OWNER1_LAST_NAME = "Smyth";
    private OwnerServiceMap sut;

    @BeforeEach
    void setUp() {
        sut = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        sut.save(Owner.builder().id(OWNER1_ID).lastName(OWNER1_LAST_NAME).build());
    }

    @Test
    void findAll() {

        // Arrange

        // Act
        Set<Owner> owners = sut.findAll();

        // Assert
        assertEquals(1, owners.size());
    }

    @Test
    void delete() {

        // Arrange

        // Act
        sut.delete(sut.findById(OWNER1_ID));

        // Assert
        assertTrue(sut.findAll().isEmpty());

    }

    @Test
    void save_and_id_exists() {

        // Arrange
        Owner owner = Owner.builder().id(2L).build();

        // Act
        Owner savedOwner = sut.save(owner);

        // Assert
        assertEquals(2L, savedOwner.getId());

    }

    @Test
    void save_and_no_id_exists() {

        // Arrange
        Owner owner = Owner.builder().build();

        // Act
        Owner savedOwner = sut.save(owner);

        // Assert
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());

    }

    @Test
    void deleteById() {

        // Arrange

        // Act
        sut.deleteById(OWNER1_ID);

        // Assert
        assertTrue(sut.findAll().isEmpty());

    }

    @Test
    void findById() {

        // Arrange

        // Act
        Owner ownerFound = sut.findById(OWNER1_ID);

        // Assert
        assertNotNull(ownerFound);

    }

    @Test
    void findByLastName_found() {

        // Arrange

        // Act
        Owner ownerFound = sut.findByLastName(OWNER1_LAST_NAME);

        // Assert
        assertNotNull(ownerFound);
        assertEquals(OWNER1_ID, ownerFound.getId());

    }

    @Test
    void findByLastName_not_found() {

        // Arrange

        // Act
        Owner ownerFound = sut.findByLastName("not_existing_last_name");

        // Assert
        assertNull(ownerFound);

    }
}
