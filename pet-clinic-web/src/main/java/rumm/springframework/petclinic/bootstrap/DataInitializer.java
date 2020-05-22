package rumm.springframework.petclinic.bootstrap;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import rumm.springframework.petclinic.model.Owner;
import rumm.springframework.petclinic.model.Pet;
import rumm.springframework.petclinic.model.PetType;
import rumm.springframework.petclinic.model.Speciality;
import rumm.springframework.petclinic.model.Vet;
import rumm.springframework.petclinic.services.OwnerService;
import rumm.springframework.petclinic.services.PetTypeService;
import rumm.springframework.petclinic.services.SpecialityService;
import rumm.springframework.petclinic.services.VetService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataInitializer(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService, final SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(final String... args) throws Exception {

        final int petTypesCount = petTypeService.findAll().size();

        if (petTypesCount == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner mike = new Owner();
        mike.setFirstName("Michael");
        mike.setLastName("Weston");
        mike.setAddress("223 Backgasse");
        mike.setCity("Freiburg");
        mike.setPhoneNumber("0761 558443");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(mike);
        mikesPet.setBirthDay(LocalDate.now());
        mikesPet.setName("Bob");
        mikesPet.setOwner(mike);
        mike.getPets().add(mikesPet);

        ownerService.save(mike);

        Owner fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glenanne");
        fiona.setAddress("223 Backgasse");
        fiona.setCity("Freiburg");
        fiona.setPhoneNumber("0761 558443");

        Pet fionasCat = new Pet();
        fionasCat.setName("Betsy");
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setBirthDay(LocalDate.now());
        fionasCat.setOwner(fiona);
        fiona.getPets().add(fionasCat);

        ownerService.save(fiona);

        System.out.println("Loaded Owners....");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        final Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        final Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        final Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().addAll(Arrays.asList(savedSurgery, savedDentistry));

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
