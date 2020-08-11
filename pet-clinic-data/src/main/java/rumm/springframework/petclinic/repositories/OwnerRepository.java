package rumm.springframework.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import rumm.springframework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
