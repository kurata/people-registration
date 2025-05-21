package br.com.aqueteron.people.registration.api.people;

import jakarta.persistence.Embeddable;
import lombok.Builder;

import java.io.Serializable;

@Builder
@Embeddable
public class Country implements Serializable {

    private final String value;

    public Country(final String value) {
        this.value = value;
    }

    protected Country() {
        this(null);
    }

    public String value(){
        return value;
    }
}
