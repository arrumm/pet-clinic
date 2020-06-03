package rumm.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Vet;
import rumm.springframework.petclinic.repositories.VetRepository;
import rumm.springframework.petclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private VetRepository vetRepository;

    public VetSDJpaService(final VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(final Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(final Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(final Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(final Long id) {
        vetRepository.deleteById(id);
    }
}
