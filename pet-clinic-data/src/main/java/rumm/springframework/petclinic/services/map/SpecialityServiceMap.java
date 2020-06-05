package rumm.springframework.petclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Speciality;
import rumm.springframework.petclinic.services.SpecialityService;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(final Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public Speciality save(final Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public void deleteById(final Long id) {
        super.deletById(id);
    }

    @Override
    public Speciality findById(final Long id) {
        return super.findById(id);
    }
}
