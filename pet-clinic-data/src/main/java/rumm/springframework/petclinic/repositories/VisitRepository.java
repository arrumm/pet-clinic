package rumm.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import rumm.springframework.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
