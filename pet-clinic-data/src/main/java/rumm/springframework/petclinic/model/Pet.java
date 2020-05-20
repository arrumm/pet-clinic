package rumm.springframework.petclinic.model;

import java.util.Date;

public class Pet extends BaseEntity {
    private PetType petType;
    private Owner owner;
    private Date birthDay;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(final PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(final Owner owner) {
        this.owner = owner;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(final Date birthDay) {
        this.birthDay = birthDay;
    }
}
