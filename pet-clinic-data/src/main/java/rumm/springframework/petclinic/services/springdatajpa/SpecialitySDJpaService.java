package rumm.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Speciality;
import rumm.springframework.petclinic.repositories.SpecialityRepository;
import rumm.springframework.petclinic.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

    private SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(final SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(final Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(final Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(final Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(final Long id) {
        specialityRepository.deleteById(id);
    }
}
