package rumm.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Visit;
import rumm.springframework.petclinic.repositories.VisitRepository;
import rumm.springframework.petclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private VisitRepository visitRepository;

    public VisitSDJpaService(final VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(final Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(final Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(final Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(final Long id) {
        visitRepository.deleteById(id);
    }
}
