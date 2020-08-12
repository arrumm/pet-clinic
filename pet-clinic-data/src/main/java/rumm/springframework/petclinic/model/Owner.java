package rumm.springframework.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static java.util.Objects.nonNull;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String phoneNumber, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;

        if (nonNull(pets)) {
            this.pets = pets;
        }
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Pet getPet(final String name, final boolean ignoreNew) {
        final String normalizedNameToFind = name.toLowerCase();
        return getPets().stream().filter(pet -> (!ignoreNew || !pet.isNew()) && pet.getName().toLowerCase().equals(normalizedNameToFind)).findFirst().orElse(null);
    }
}
