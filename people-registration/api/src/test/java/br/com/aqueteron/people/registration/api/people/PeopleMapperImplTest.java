package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.model.PeopleApiSchema;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PeopleMapperImplTest {

    private final PeopleMapper peopleMapper = new PeopleMapperImpl();

    @Test
    void shouldToPeople() {
        UUID peopleId = UUID.randomUUID();
        PeopleApiSchema peopleApiSchema = PeopleApiSchemaStub.createNewPeopleApiSchema();

        People peopleResult = this.peopleMapper.toPeople(peopleId, peopleApiSchema);

        assertNotNull(peopleResult);
        assertEquals(peopleId, peopleResult.getId());
        assertEquals(peopleApiSchema.getNome(), peopleResult.getName());
        assertEquals(peopleApiSchema.getSobrenome(), peopleResult.getSurname());
        assertEquals(peopleApiSchema.getIdade(), peopleResult.getAge());
        assertEquals(peopleApiSchema.getPais(), peopleResult.getCountry());
    }

    @Test
    void shouldToPeopleWithPeopleIdNullAndPeopleApiSchemaNull() {
        People peopleResult = this.peopleMapper.toPeople(null, null);

        assertNull(peopleResult);
    }

    @Test
    void shouldToPeopleWithPeopleIdNull() {
        PeopleApiSchema peopleApiSchema = PeopleApiSchemaStub.createNewPeopleApiSchema();

        People peopleResult = this.peopleMapper.toPeople(null, peopleApiSchema);

        assertNotNull(peopleResult);
        assertNull(peopleResult.getId());
        assertEquals(peopleApiSchema.getNome(), peopleResult.getName());
        assertEquals(peopleApiSchema.getSobrenome(), peopleResult.getSurname());
        assertEquals(peopleApiSchema.getIdade(), peopleResult.getAge());
        assertEquals(peopleApiSchema.getPais(), peopleResult.getCountry());
    }

    @Test
    void shouldToPeopleWithPeopleApiSchemaNull() {
        UUID peopleId = UUID.randomUUID();

        People peopleResult = this.peopleMapper.toPeople(peopleId, null);

        assertNotNull(peopleResult);
        assertEquals(peopleId, peopleResult.getId());
        assertNull(peopleResult.getName());
        assertNull(peopleResult.getSurname());
        assertNull(peopleResult.getAge());
        assertNull(peopleResult.getCountry());
    }

    @Test
    void shouldToPeopleApiSchema() {
        People people = PeopleStubs.createNewPeople();

        PeopleApiSchema peopleApiSchemaResult = this.peopleMapper.toPeopleApiSchema(people);

        assertNotNull(peopleApiSchemaResult);
        assertEquals(people.getId().toString(), peopleApiSchemaResult.getId());
        assertEquals(people.getName(), peopleApiSchemaResult.getNome());
        assertEquals(people.getSurname(), peopleApiSchemaResult.getSobrenome());
        assertEquals(people.getAge(), peopleApiSchemaResult.getIdade());
        assertEquals(people.getCountry(), peopleApiSchemaResult.getPais());
    }

    @Test
    void shouldToPeopleApiSchemaWithPeopleIdNull() {
        People people = PeopleStubs.createNewPeople(null);

        PeopleApiSchema peopleApiSchemaResult = this.peopleMapper.toPeopleApiSchema(people);

        assertNotNull(peopleApiSchemaResult);
        assertNull(peopleApiSchemaResult.getId());
        assertEquals(people.getName(), peopleApiSchemaResult.getNome());
        assertEquals(people.getSurname(), peopleApiSchemaResult.getSobrenome());
        assertEquals(people.getAge(), peopleApiSchemaResult.getIdade());
        assertEquals(people.getCountry(), peopleApiSchemaResult.getPais());
    }

    @Test
    void shouldToPeopleApiSchemaWithPeopleNull() {
        PeopleApiSchema peopleApiSchemaResult = this.peopleMapper.toPeopleApiSchema(null);

        assertNull(peopleApiSchemaResult);
    }

    @Test
    void shouldToPeopleApiSchemaList() {
        List<People> peopleList = List.of(PeopleStubs.createNewPeople());

        List<PeopleApiSchema> apiSchemaList = this.peopleMapper.toPeopleApiSchemaList(peopleList);

        assertNotNull(apiSchemaList);
        assertEquals(peopleList.size(), apiSchemaList.size());
    }

    @Test
    void shouldToPeopleApiSchemaListWithPeopleListNull() {
        List<PeopleApiSchema> apiSchemaList = this.peopleMapper.toPeopleApiSchemaList(null);

        assertNull(apiSchemaList);
    }
}
