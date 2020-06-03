package rumm.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import rumm.springframework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
