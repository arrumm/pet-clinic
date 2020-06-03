package rumm.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import rumm.springframework.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
