package rumm.springframework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Pet;
import rumm.springframework.petclinic.services.PetService;

@Service
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
