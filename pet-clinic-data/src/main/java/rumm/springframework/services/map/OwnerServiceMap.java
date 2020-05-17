package rumm.springframework.services.map;

import java.util.Set;

import rumm.springframework.model.Owner;
import rumm.springframework.services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner,Long> {

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
}
