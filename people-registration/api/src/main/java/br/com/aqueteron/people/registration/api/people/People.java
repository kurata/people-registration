package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.utils.SimpleTextAttribute;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@RequiredArgsConstructor
@Data
@Entity
public class People implements Serializable {

    @Id
    private final UUID id;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "value", column = @Column(name = "name"))
    })
    private SimpleTextAttribute name;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "value", column = @Column(name = "surname"))
    })
    private SimpleTextAttribute surname;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "value", column = @Column(name = "age"))
    })
    private Age age;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "value", column = @Column(name = "country"))
    })
    private Country country;

    protected People() {
        this(null);
    }

    public String getName() {
        if (this.name == null) {
            return null;
        }
        return this.name.value();
    }

    public void setName(final String name) {
        this.name = new SimpleTextAttribute(name);
    }

    public String getSurname() {
        if (this.surname == null) {
            return null;
        }
        return this.surname.value();
    }

    public void setSurname(String surname) {
        this.surname = new SimpleTextAttribute(surname);
    }

    public Integer getAge() {
        if (age == null) {
            return null;
        }
        return age.value();
    }

    public void setAge(final Integer ageValue) {
        this.age = new Age(ageValue);
    }

    public String getCountry() {
        if (this.country == null) {
            return null;
        }
        return country.value();
    }

    public void setCountry(final String country) {
        this.country = new Country(country);
    }
}
