package rumm.springframework.services.map;

import java.util.Set;

import rumm.springframework.model.Owner;
import rumm.springframework.services.OwnerService;

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
