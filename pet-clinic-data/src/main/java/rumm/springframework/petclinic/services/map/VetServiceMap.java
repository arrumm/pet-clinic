package rumm.springframework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Vet;
import rumm.springframework.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

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
