package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class OwnerMapServiceTest {

    private final Long id = 1L;
    private final String lastName = "Smith";
    private OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(id).lastName(lastName).build());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner savedOwner = ownerMapService.save(Owner.builder().id(id).build());
        assertEquals(savedOwner.getId(), id);
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findOwnerByLastName() {
        Owner owner = ownerMapService.findOwnerByLastName(lastName);
        assertNotNull(owner);
        assertEquals(owner.getLastName(), lastName);
    }

    @Test
    void findOwnerByLastNameThatDoesntExistReturnsNull() {
        Owner foo = ownerMapService.findOwnerByLastName("foo");
        assertNull(foo);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(id);
        assertEquals(owner.getId(), id);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(owners.size(), 1);
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(id));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteWhenItDoesntExistDoesNothing() {
        ownerMapService.delete(Owner.builder().id(id).build());
        assertEquals(1, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(id);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteByIdWhenItDoesntExistDoesNothing() {
        ownerMapService.deleteById(3L);
        assertEquals(1, ownerMapService.findAll().size());
    }
}