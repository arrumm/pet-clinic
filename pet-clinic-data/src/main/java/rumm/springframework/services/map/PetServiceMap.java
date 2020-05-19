package rumm.springframework.services.map;

import java.util.Set;

import rumm.springframework.model.Pet;
import rumm.springframework.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(final Pet pet) {
        super.delete(pet);
    }

    @Override
    public Pet save(final Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public void deleteById(final Long id) {
        super.deletById(id);
    }

    @Override
    public Pet findById(final Long id) {
        return super.findById(id);
    }
}
