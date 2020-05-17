package rumm.springframework.services;

import java.util.Set;

import rumm.springframework.model.Owner;

public interface OwnerService {

    Owner findById(Long id);

    Owner findByLastName(String lastName);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
