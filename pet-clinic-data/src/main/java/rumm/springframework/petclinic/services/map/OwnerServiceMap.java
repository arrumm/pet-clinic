package rumm.springframework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Owner;
import rumm.springframework.petclinic.model.Pet;
import rumm.springframework.petclinic.services.OwnerService;
import rumm.springframework.petclinic.services.PetService;
import rumm.springframework.petclinic.services.PetTypeService;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    public OwnerServiceMap(final PetTypeService petTypeService, final PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    private final PetTypeService petTypeService;
    private final PetService petService;

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(final Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(final Owner owner) {

        if (nonNull(owner)) {
            if (nonNull(owner.getPets())) {
                owner.getPets().forEach(pet -> {
                    if (nonNull(pet.getPetType()) && nonNull(pet.getPetType().getId())) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    } else {
                        throw new RuntimeException("Pet type is required");
                    }

                    if (isNull(pet.getId())) {
                        final Pet petSaved = petService.save(pet);
                        pet.setId(petSaved.getId());
                    }
                });
            }
            return super.save(owner.getId(), owner);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(final Long id) {
        super.deletById(id);
    }

    @Override
    public Owner findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return null;
    }
}
