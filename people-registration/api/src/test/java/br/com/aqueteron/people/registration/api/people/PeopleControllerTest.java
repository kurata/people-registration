package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.model.PeopleApiSchema;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PeopleControllerTest {

    @InjectMocks
    private PeopleController controller;

    @Mock
    private PeopleService peopleService;

    @Mock
    private PeopleMapper peopleMapper;

    @Test
    void shouldCreatePeople() {
        final PeopleApiSchema peopleApiSchema = PeopleApiSchemaStub.createNewPeopleApiSchema();
        final People people = PeopleStubs.createNewPeople();

        when(this.peopleMapper.toPeople(any(), eq(peopleApiSchema))).thenReturn(people);
        when(this.peopleService.createPeople(people)).thenReturn(people);
        when(this.peopleMapper.toPeopleApiSchema(people)).thenReturn(peopleApiSchema);
        ResponseEntity<PeopleApiSchema> responseEntity = this.controller.createPeople(peopleApiSchema);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(peopleApiSchema, responseEntity.getBody());
    }

    @Test
    void shouldRetrievePeople() {
        final PeopleApiSchema peopleApiSchema = PeopleApiSchemaStub.createNewPeopleApiSchema();
        final People people = PeopleStubs.createNewPeople();

        when(this.peopleService.retrievePeople(people.getId())).thenReturn(people);
        when(this.peopleMapper.toPeopleApiSchema(people)).thenReturn(peopleApiSchema);
        ResponseEntity<PeopleApiSchema> responseEntity = this.controller.retrievePeople(people.getId());

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldSearchPeople() {
        final PeopleApiSchema peopleApiSchema = PeopleApiSchemaStub.createNewPeopleApiSchema();
        final People people = PeopleStubs.createNewPeople();

        when(this.peopleService.searchPeople()).thenReturn(List.of(people));
        when(this.peopleMapper.toPeopleApiSchemaList(List.of(people))).thenReturn(List.of(peopleApiSchema));
        ResponseEntity<List<PeopleApiSchema>> responseEntity = this.controller.searchPeople();

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldUpdatePeople() {
        final PeopleApiSchema peopleApiSchema = PeopleApiSchemaStub.createNewPeopleApiSchema();
        final People people = PeopleStubs.createNewPeople();

        when(this.peopleMapper.toPeople(eq(people.getId()), eq(peopleApiSchema))).thenReturn(people);
        when(this.peopleService.editPeople(people)).thenReturn(people);
        when(this.peopleMapper.toPeopleApiSchema(people)).thenReturn(peopleApiSchema);
        ResponseEntity<PeopleApiSchema> responseEntity = this.controller.updatePeople(people.getId(), peopleApiSchema);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(peopleApiSchema, responseEntity.getBody());
    }
}
