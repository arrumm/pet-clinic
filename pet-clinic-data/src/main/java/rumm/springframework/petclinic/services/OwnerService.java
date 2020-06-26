package rumm.springframework.petclinic.services;

import rumm.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

}
