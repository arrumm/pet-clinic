package rumm.springframework.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import rumm.springframework.petclinic.model.Owner;
import rumm.springframework.petclinic.repositories.OwnerRepository;
import rumm.springframework.petclinic.repositories.PetRepository;
import rumm.springframework.petclinic.repositories.PetTypeRepository;
import rumm.springframework.petclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private OwnerRepository ownerRepository;
    private PetRepository petRepository;
    private PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(final OwnerRepository ownerRepository, final PetRepository petRepository, final PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(final Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(final String lastName) {
        String wildCard = "%";
        return ownerRepository.findAllByLastNameLike(wildCard + lastName + wildCard);
    }

    @Override
    public Owner save(final Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(final Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(final Long id) {
        ownerRepository.deleteById(id);
    }
}
