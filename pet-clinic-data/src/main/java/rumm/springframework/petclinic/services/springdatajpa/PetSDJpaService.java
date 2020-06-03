package rumm.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Pet;
import rumm.springframework.petclinic.repositories.PetRepository;
import rumm.springframework.petclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private PetRepository petRepository;

    public PetSDJpaService(final PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(final Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(final Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(final Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(final Long id) {
        petRepository.deleteById(id);
    }
}
