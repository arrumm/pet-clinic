package rumm.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import rumm.springframework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
