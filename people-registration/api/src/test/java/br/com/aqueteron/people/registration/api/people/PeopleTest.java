package br.com.aqueteron.people.registration.api.people;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {

    @Test
    void shouldCreatePeople() {
        People people = new People();
        assertNotNull(people);
        assertNull(people.getId());
    }

}
