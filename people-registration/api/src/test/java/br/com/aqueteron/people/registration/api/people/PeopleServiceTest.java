package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PeopleServiceTest {

    @InjectMocks
    private PeopleService service;

    @Mock
    private PeopleRepository repository;

    @Test
    void shouldCreatePeople() {
        People people = PeopleStubs.createNewPeople();

        when(this.repository.save(people)).thenReturn(people);
        People createdPeople = this.service.createPeople(people);

        assertNotNull(createdPeople);
        assertEquals(people, createdPeople);
    }

    @Test
    void shouldRetrievePeople() {
        People expectedPeople = PeopleStubs.createNewPeople();

        when(this.repository.findById(expectedPeople.getId())).thenReturn(Optional.of(expectedPeople));
        People peopleRetrieved = this.service.retrievePeople(expectedPeople.getId());
        assertNotNull(peopleRetrieved);
        assertEquals(expectedPeople, peopleRetrieved);
    }

    @Test
    void shouldRetrievePeopleAndNotFound() {
        UUID peopleId = UUID.randomUUID();

        when(this.repository.findById(peopleId)).thenReturn(Optional.empty());
        assertThrows(BusinessException.class, () -> this.service.retrievePeople(peopleId));
    }

    @Test
    void shouldSearchPeople() {
        List<People> peopleList = List.of(PeopleStubs.createNewPeople());

        when(this.repository.findAll()).thenReturn(peopleList);
        List<People> peopleListRetrieved = this.service.searchPeople();

        assertNotNull(peopleListRetrieved);
        assertEquals(peopleList, peopleListRetrieved);
    }

    @Test
    void shouldSearchPeopleWithEmptyList() {
        List<People> peopleList = List.of();

        when(this.repository.findAll()).thenReturn(peopleList);
        List<People> peopleListRetrieved = this.service.searchPeople();

        assertNotNull(peopleListRetrieved);
        assertEquals(peopleList, peopleListRetrieved);
    }

    @Test
    void shouldEditPeopleWithFullEdit() {
        People people = PeopleStubs.createNewPeople();
        People originalPeople = PeopleStubs.createNewPeople(people.getId());

        when(this.repository.findById(people.getId())).thenReturn(Optional.of(originalPeople));
        People peopleEdited = this.service.editPeople(people);
        assertNotNull(peopleEdited);
        assertEquals(people, peopleEdited);
    }

    @Test
    void shouldEditPeopleWithEmptyEdit() {
        People people = PeopleStubs.createNewPeople();
        people.setNome(null);
        people.setSobrenome(null);
        people.setIdade(null);
        people.setPais(null);
        People originalPeople = PeopleStubs.createNewPeople(people.getId());

        when(this.repository.findById(people.getId())).thenReturn(Optional.of(originalPeople));
        People peopleEdited = this.service.editPeople(people);
        assertNotNull(peopleEdited);
        assertEquals(originalPeople, peopleEdited);
    }

    @Test
    void shouldEditPeopleAndNotFound() {
        People people = PeopleStubs.createNewPeople();

        when(this.repository.findById(people.getId())).thenReturn(Optional.empty());
        assertThrows(BusinessException.class, () -> this.service.editPeople(people));
    }
}
