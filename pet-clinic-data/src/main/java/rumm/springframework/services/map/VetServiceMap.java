package rumm.springframework.services.map;

import java.util.Set;

import rumm.springframework.model.Vet;
import rumm.springframework.services.CrudService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet,Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(final Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(final Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public void deleteById(final Long id) {
        super.deletById(id);
    }

    @Override
    public Vet findById(final Long id) {
        return super.findById(id);
    }
}
