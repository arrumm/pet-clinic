package rumm.springframework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Speciality;
import rumm.springframework.petclinic.model.Vet;
import rumm.springframework.petclinic.services.SpecialityService;
import rumm.springframework.petclinic.services.VetService;

import static java.util.Objects.isNull;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(final SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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

        if (vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(
                    speciality -> {
                        if (isNull(speciality.getId())) {
                            final Speciality savedSpeciality = specialityService.save(speciality);
                            speciality.setId(savedSpeciality.getId());
                        }
                    }
            );
        }

        return super.save(vet);

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
