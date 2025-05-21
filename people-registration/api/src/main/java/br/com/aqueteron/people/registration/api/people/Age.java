package br.com.aqueteron.people.registration.api.people;

import jakarta.persistence.Embeddable;
import lombok.Builder;

import java.io.Serializable;

@Builder
@Embeddable
public class Age implements Serializable {

    private final Integer value;

    public Age(final Integer value) {
        validate(value);
        this.value = value;
    }

    protected Age() {
        this(null);
    }

    public Integer value() {
        return value;
    }

    private void validate(final Integer age) {
        if (age == null) {
            return;
        }
        if (age < 1 || age > 100) {
            throw new IllegalArgumentException(String.format("Invalid Age: %d .Age must be between 1 and 100", age));
        }
    }

}
