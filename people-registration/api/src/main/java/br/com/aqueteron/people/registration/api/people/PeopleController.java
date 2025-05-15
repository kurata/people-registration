package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.PeopleApi;
import br.com.aqueteron.people.registration.api.model.PeopleApiSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PeopleController implements PeopleApi {

    private final PeopleMapper peopleMapper;

    private final PeopleService peopleService;

    @Override
    public ResponseEntity<PeopleApiSchema> createPeople(final PeopleApiSchema peopleApiSchema) {
        People people = this.peopleMapper.toPeople(UUID.randomUUID(), peopleApiSchema);
        people = this.peopleService.createPeople(people);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.peopleMapper.toPeopleApiSchema(people));
    }

    @Override
    public ResponseEntity<PeopleApiSchema> retrievePeople(final UUID peopleId) {
        People people = this.peopleService.retrievePeople(peopleId);
        return ResponseEntity.ok(this.peopleMapper.toPeopleApiSchema(people));
    }

    @Override
    public ResponseEntity<List<PeopleApiSchema>> searchPeople() {
        List<People> peopleList = this.peopleService.searchPeople();
        return ResponseEntity.ok(this.peopleMapper.toPeopleApiSchemaList(peopleList));
    }

    @Override
    public ResponseEntity<PeopleApiSchema> updatePeople(final UUID peopleId, final PeopleApiSchema peopleApiSchema) {
        People people = this.peopleMapper.toPeople(peopleId, peopleApiSchema);
        people = this.peopleService.editPeople(people);
        return ResponseEntity.ok(this.peopleMapper.toPeopleApiSchema(people));
    }
}
