package rumm.springframework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Owner;
import rumm.springframework.petclinic.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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
        return super.save(owner.getId(), owner);
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