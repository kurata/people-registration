package br.com.aqueteron.people.registration.api.people;

import br.com.aqueteron.people.registration.api.model.PeopleApiSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public People createPeople(final People people) {
        return this.peopleRepository.save(people);
    }

    public People retrievePeople(UUID peopleId) {
        return this.peopleRepository.findById(peopleId).orElseThrow();
    }

    public List<People> searchPeople() {
        return this.peopleRepository.findAll();
    }

    public People editPeople(People people) {
        return this.peopleRepository.findById(people.getId()).orElseThrow();
    }
}
