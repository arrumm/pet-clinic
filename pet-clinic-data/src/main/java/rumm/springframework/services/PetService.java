package rumm.springframework.services;

import java.util.Set;

import rumm.springframework.model.Pet;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
