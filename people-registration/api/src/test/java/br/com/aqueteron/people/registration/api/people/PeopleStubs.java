package br.com.aqueteron.people.registration.api.people;

import net.datafaker.Faker;

import java.util.UUID;

public class PeopleStubs {
    public static People createNewPeople() {
        return createNewPeople(UUID.randomUUID());
    }

    public static People createNewPeople(final UUID peopleId) {
        Faker faker = new Faker();
        People people = new People(peopleId);
        people.setName(faker.name().firstName());
        people.setSurname(faker.name().lastName());
        people.setAge(faker.random().nextInt(1, 100));
        people.setCountry(faker.country().name());
        return people;
    }
}
