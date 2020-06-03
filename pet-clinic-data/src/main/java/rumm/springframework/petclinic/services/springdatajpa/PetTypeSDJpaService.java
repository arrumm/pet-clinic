package rumm.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.PetType;
import rumm.springframework.petclinic.repositories.PetTypeRepository;
import rumm.springframework.petclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(final PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(final Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(final PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(final PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(final Long id) {
        petTypeRepository.deleteById(id);
    }
}
