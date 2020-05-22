package rumm.springframework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.PetType;
import rumm.springframework.petclinic.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(final PetType petType) {
        super.delete(petType);
    }

    @Override
    public PetType save(final PetType petType) {
        return super.save(petType.getId(), petType);
    }

    @Override
    public void deleteById(final Long id) {
        super.deletById(id);
    }

    @Override
    public PetType findById(final Long id) {
        return super.findById(id);
    }
}
