package rumm.springframework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Visit;
import rumm.springframework.petclinic.services.VisitService;

import static java.util.Objects.isNull;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(final Long id) {
        super.deletById(id);
    }

    @Override
    public void delete(final Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(final Visit visit) {

        if (isNull(visit.getPet()) || isNull(visit.getPet().getOwner()) || isNull(visit.getPet().getId()) || isNull(visit.getPet().getOwner().getId())) {
            throw new RuntimeException("Invalid visit data");
        }

        return super.save(visit);
    }

    @Override
    public Visit findById(final Long id) {
        return super.findById(id);
    }
}
