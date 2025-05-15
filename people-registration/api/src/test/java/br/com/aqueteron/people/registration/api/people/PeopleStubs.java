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
        people.setNome(faker.name().firstName());
        people.setSobrenome(faker.name().lastName());
        people.setIdade(faker.random().nextInt(100));
        people.setPais(faker.country().name());
        return people;
    }
}
