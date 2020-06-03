package rumm.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import rumm.springframework.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
