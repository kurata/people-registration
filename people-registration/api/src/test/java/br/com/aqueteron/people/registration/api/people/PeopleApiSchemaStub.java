package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.model.PeopleApiSchema;
import net.datafaker.Faker;

public class PeopleApiSchemaStub {
    public static PeopleApiSchema createNewPeopleApiSchema() {
        Faker faker = new Faker();
        PeopleApiSchema people = new PeopleApiSchema();
        people.setNome(faker.name().firstName());
        people.setSobrenome(faker.name().lastName());
        people.setIdade(faker.random().nextInt(100));
        people.setPais(faker.country().name());
        return people;
    }
}
